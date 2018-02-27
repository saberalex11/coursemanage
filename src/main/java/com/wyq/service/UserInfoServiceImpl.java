package com.wyq.service;

import com.github.pagehelper.PageHelper;
import com.wyq.bean.Account;
import com.wyq.bean.Course;
import com.wyq.bean.CourseTeacherRel;
import com.wyq.bean.Notice;
import com.wyq.mapper.CourseMapper;
import com.wyq.mapper.CourseTeacherRelMapper;
import com.wyq.mapper.UserInfoMapper;
import com.wyq.service.vo.TeacherVo;
import com.wyq.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper AccountMapper;

    @Autowired
    private CourseTeacherRelMapper courseTeacherRelMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Account queryOne(Account record) {
        return null;
    }

    @Override
    public List<Account> queryAll() {
        return null;
    }

    @Override
    public int queryCount(Account record) {
        return 0;
    }

    @Override
    public Account queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(Account record) {
        return 0;
    }

    @Override
    public int addSelective(Account record) {
        return AccountMapper.insertSelective(record);
    }

    @Override
    public int delete(Account record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Account record) {
        record = AccountMapper.selectByPrimaryKey(record.getId());
        record.setAccountStatus(0);
        record.setCreateTime(new Date());
        return AccountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        record.setCreateTime(new Date());
        return AccountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int queryCountByExample(Account example) {
        return 0;
    }

    @Override
    public List<Account> queryByExample(Account example) {
        return null;
    }

    @Override
    public Account queryByAccount(String account) {
        Example ex = new Example(Account.class);
        ex.createCriteria().andCondition(" account='"+account+"'")
        .andCondition(" account_status="+1);
        List<Account> Accounts = AccountMapper.selectByExample(ex);
        if(Accounts != null && Accounts.size() > 0){
            return Accounts.get(0);
        }
        return null;
    }

    @Override
    public Account queryByAccountAndPassword(String account, String password) {
        Example ex = new Example(Account.class);
        ex.createCriteria().andCondition(" account= '"+account+"'")
                .andCondition(" account_status="+1)
        .andCondition(" password='"+password+"'");
        List<Account> Accounts = AccountMapper.selectByExample(ex);
        if(Accounts != null && Accounts.size() > 0){
            return Accounts.get(0);
        }
        return null;
    }

    @Override
    public void signUp(Account account, Integer courseId) {
        account.setCreateTime(new Date());
        AccountMapper.insertSelective(account);
        //如果是老师需要保存任课信息
        if(account.getAccountType() == 1){
            Course course = courseMapper.selectByPrimaryKey(courseId);
            CourseTeacherRel rel = new CourseTeacherRel();
            rel.setCourseId(courseId);
            rel.setCourseName(course.getCourseName());
            rel.setCreateTime(new Date());
            rel.setStatus(1);
            rel.setTeacherId(account.getId());
            rel.setTeacherName(account.getName());
            courseTeacherRelMapper.insertSelective(rel);
        }

    }

    @Override
    public Account checkAdmin() {
        Example ex = new Example(Account.class);
        ex.createCriteria().andCondition(" account_type= '"+0+"'")
                .andCondition(" account_status="+1);
        List<Account> Accounts = AccountMapper.selectByExample(ex);
        if(Accounts != null && Accounts.size() > 0){
            return Accounts.get(0);
        }
        return null;
    }

    @Override
    public R listAccount(String account, String name, Integer page, Integer limit) {
        Example ex = new Example(Account.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andCondition(" account_status = 1");
        if(StringUtils.isNotBlank(account)){
            criteria.andCondition(" account like '%"+account+"%'");
        }
        if(StringUtils.isNotBlank(name)){
            criteria.andCondition(" name like '%"+name+"%'");
        }
        PageHelper.startPage(page, limit, true);
        List<Account> notices = AccountMapper.selectByExample(ex);
        int count = AccountMapper.selectCountByExample(ex);
        return R.ok().put("data",notices).put("count",count);
    }

    @Override
    public R listTeacherAccount(String account, String name, Integer page, Integer limit) {
        Example ex = new Example(Account.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andCondition(" account_status = 1");
        criteria.andCondition( " account_type = 1");
        if(StringUtils.isNotBlank(account)){
            criteria.andCondition(" account like '%"+account+"%'");
        }
        if(StringUtils.isNotBlank(name)){
            criteria.andCondition(" name like '%"+name+"%'");
        }
        PageHelper.startPage(page, limit, true);
        List<Account> accounts = AccountMapper.selectByExample(ex);
        int count = AccountMapper.selectCountByExample(ex);

        List<TeacherVo> collect = accounts.parallelStream().map(p -> {
            TeacherVo vo = new TeacherVo();
            BeanUtils.copyProperties(p, vo);
            Example ex1 = new Example(CourseTeacherRel.class);
            Example.Criteria criteria1 = ex1.createCriteria();
            criteria1.andCondition(" teacher_id =" + p.getId());
            criteria1.andCondition(" status = 1");
            List<CourseTeacherRel> courseTeacherRels = courseTeacherRelMapper.selectByExample(ex1);
            CourseTeacherRel ctr = courseTeacherRels.get(0);
            vo.setCourseName(ctr.getCourseName());
            return vo;
        }).collect(Collectors.toList());
        return R.ok().put("data",collect).put("count",count);
    }
}
