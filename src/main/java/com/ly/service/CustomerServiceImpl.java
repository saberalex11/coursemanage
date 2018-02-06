package com.ly.service;

import com.github.pagehelper.PageHelper;
import com.ly.bean.Customer;
import com.ly.bean.Product;
import com.ly.mapper.CustomerMapper;
import com.ly.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer queryOne(Customer record) {
        return null;
    }

    @Override
    public List<Customer> queryAll(Customer record) {
        return null;
    }

    @Override
    public int queryCount(Customer record) {
        return 0;
    }

    @Override
    public Customer queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(Customer record) {
        return 0;
    }

    @Override
    public int addSelective(Customer record) {
        return 0;
    }

    @Override
    public int delete(Customer record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Customer record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return 0;
    }

    @Override
    public int queryCountByExample(Customer example) {
        return 0;
    }

    @Override
    public List<Customer> queryByExample(Customer example) {
        return null;
    }

    @Override
    public R queryCustomer(String customerSimpleName, Integer page, Integer limit) {
        Example ex = new Example(Customer.class);
        Example.Criteria criteria = ex.createCriteria();
        if(StringUtils.isNotBlank(customerSimpleName)){
            criteria.andCondition(" customer_simple_name like '%"+customerSimpleName+"%'");
            PageHelper.startPage(page, limit, true);
            List<Customer> infos = customerMapper.selectByExample(ex);
            int i = customerMapper.selectCountByExample(ex);
            return R.ok().put("data",infos).put("count",i);
        }else{
            PageHelper.startPage(page, limit, true);
            List<Customer> infos = customerMapper.selectAll();
            int i = customerMapper.selectCountByExample(ex);
            return R.ok().put("data",infos).put("count",i);
        }
    }
}
