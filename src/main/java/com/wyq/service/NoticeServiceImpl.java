package com.wyq.service;

import com.github.pagehelper.PageHelper;
import com.wyq.bean.CourseStudentRel;
import com.wyq.bean.Notice;
import com.wyq.mapper.NoticeMapper;
import com.wyq.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public Notice queryOne(Notice record) {
        return noticeMapper.selectByPrimaryKey(record.getId());
    }

    @Override
    public List<Notice> queryAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public int queryCount(Notice record) {
        return 0;
    }

    @Override
    public Notice queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(Notice record) {
        record.setCreateTime(new Date());
        record.setStatus(1);
        return noticeMapper.insert(record);
    }

    @Override
    public int addSelective(Notice record) {
        return 0;
    }

    @Override
    public int delete(Notice record) {
        record = noticeMapper.selectByPrimaryKey(record.getId());
        record.setStatus(0);
        record.setCreateTime(new Date());
        return noticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        record.setCreateTime(new Date());
        return noticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int queryCountByExample(Notice example) {
        return 0;
    }

    @Override
    public List<Notice> queryByExample(Notice example) {
        return null;
    }

    @Override
    public R queryAllNotice(String noticeTitle,Integer page, Integer limit) {
        Example ex = new Example(Notice.class);
        Example.Criteria criteria = ex.createCriteria();

        criteria.andCondition(" status = 1");
        if(StringUtils.isNotBlank(noticeTitle)){
            criteria.andCondition(" notice_title like '%"+noticeTitle+"%'");
        }
        ex.setOrderByClause(" create_time desc");
        PageHelper.startPage(page, limit, true);
        List<Notice> notices = noticeMapper.selectByExample(ex);
        int count = noticeMapper.selectCountByExample(ex);
        return R.ok().put("data",notices).put("count",count);
    }

    @Override
    public R queryMyNotice(String noticeTitle,int createId, Integer page, Integer limit) {
        Example ex = new Example(Notice.class);
        Example.Criteria criteria = ex.createCriteria();

        criteria.andCondition(" status = 1");
        criteria.andCondition(" create_id = "+createId);
        if(StringUtils.isNotBlank(noticeTitle)){
            criteria.andCondition(" notice_title like '%"+noticeTitle+"%'");
        }
        PageHelper.startPage(page, limit, true);
        List<Notice> notices = noticeMapper.selectByExample(ex);
        int count = noticeMapper.selectCountByExample(ex);
        return R.ok().put("data",notices).put("count",count);
    }
}
