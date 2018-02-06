package com.ly.service;

import com.ly.bean.CustomerContactMan;
import com.ly.bean.SupplierContactMan;
import com.ly.mapper.CustomerContactManMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CustomerContactManServiceImpl implements CustomerContactManService {

    @Autowired
    private CustomerContactManMapper customerContactManMapper;

    @Override
    public CustomerContactMan queryOne(CustomerContactMan record) {
        return null;
    }

    @Override
    public List<CustomerContactMan> queryAll(CustomerContactMan record) {
        return null;
    }

    @Override
    public int queryCount(CustomerContactMan record) {
        return 0;
    }

    @Override
    public CustomerContactMan queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(CustomerContactMan record) {
        return 0;
    }

    @Override
    public int addSelective(CustomerContactMan record) {
        return 0;
    }

    @Override
    public int delete(CustomerContactMan record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CustomerContactMan record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(CustomerContactMan record) {
        return 0;
    }

    @Override
    public int queryCountByExample(CustomerContactMan example) {
        return 0;
    }

    @Override
    public List<CustomerContactMan> queryByExample(CustomerContactMan example) {
        Example ex = new Example(CustomerContactMan.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andCondition(" customer_id = "+example.getCustomerId()+"");
        List<CustomerContactMan> infos = customerContactManMapper.selectByExample(ex);
        return infos;
    }
}
