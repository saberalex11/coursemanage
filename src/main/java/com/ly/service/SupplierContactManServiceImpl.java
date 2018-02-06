package com.ly.service;

import com.github.pagehelper.PageHelper;
import com.ly.bean.Product;
import com.ly.bean.SupplierContactMan;
import com.ly.mapper.SalesManMapper;
import com.ly.mapper.SupplierContactManMapper;
import com.ly.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SupplierContactManServiceImpl implements SupplierContactManService {

    @Autowired
    private SupplierContactManMapper supplierContactManMapper;

    @Override
    public SupplierContactMan queryOne(SupplierContactMan record) {
        return null;
    }

    @Override
    public List<SupplierContactMan> queryAll(SupplierContactMan record) {
        return null;
    }

    @Override
    public int queryCount(SupplierContactMan record) {
        return 0;
    }

    @Override
    public SupplierContactMan queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(SupplierContactMan record) {
        return 0;
    }

    @Override
    public int addSelective(SupplierContactMan record) {
        return 0;
    }

    @Override
    public int delete(SupplierContactMan record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SupplierContactMan record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(SupplierContactMan record) {
        return 0;
    }

    @Override
    public int queryCountByExample(SupplierContactMan example) {
        return 0;
    }

    @Override
    public List<SupplierContactMan> queryByExample(SupplierContactMan example) {
        Example ex = new Example(SupplierContactMan.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andCondition(" supplier_id = "+example.getSupplierId()+"");
        List<SupplierContactMan> infos = supplierContactManMapper.selectByExample(ex);
        return infos;
    }
}
