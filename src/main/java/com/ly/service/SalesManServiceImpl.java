package com.ly.service;

import com.github.pagehelper.PageHelper;
import com.ly.bean.Customer;
import com.ly.bean.SalesMan;
import com.ly.mapper.PurchaseMasterMapper;
import com.ly.mapper.SalesManMapper;
import com.ly.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SalesManServiceImpl implements SalesManService {

    @Autowired
    private SalesManMapper salesManMapper;

    @Override
    public SalesMan queryOne(SalesMan record) {
        return null;
    }

    @Override
    public List<SalesMan> queryAll(SalesMan record) {
        return null;
    }

    @Override
    public int queryCount(SalesMan record) {
        return 0;
    }

    @Override
    public SalesMan queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(SalesMan record) {
        return 0;
    }

    @Override
    public int addSelective(SalesMan record) {
        return 0;
    }

    @Override
    public int delete(SalesMan record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SalesMan record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(SalesMan record) {
        return 0;
    }

    @Override
    public int queryCountByExample(SalesMan example) {
        return 0;
    }

    @Override
    public List<SalesMan> queryByExample(SalesMan example) {
        return null;
    }

    @Override
    public R querySalesMan(String chineseName, Integer page, Integer limit) {
        Example ex = new Example(SalesMan.class);
        Example.Criteria criteria = ex.createCriteria();
        if(StringUtils.isNotBlank(chineseName)){
            criteria.andCondition(" chinese_name like '%"+chineseName+"%'");
            PageHelper.startPage(page, limit, true);
            List<SalesMan> infos = salesManMapper.selectByExample(ex);
            int i = salesManMapper.selectCountByExample(ex);
            return R.ok().put("data",infos).put("count",i);
        }else{
            PageHelper.startPage(page, limit, true);
            List<SalesMan> infos = salesManMapper.selectAll();
            int i = salesManMapper.selectCountByExample(ex);
            return R.ok().put("data",infos).put("count",i);
        }
    }
}
