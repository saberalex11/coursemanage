package com.wyq.service;

import com.wyq.bean.Account;
import com.wyq.bean.Course;
import com.wyq.bean.CourseTeacherRel;
import com.wyq.mapper.CourseMapper;
import com.wyq.mapper.CourseTeacherRelMapper;
import com.wyq.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

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
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return 0;
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
}
