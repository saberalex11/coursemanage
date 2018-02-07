package com.ly.service;

import com.github.pagehelper.PageHelper;
import com.ly.bean.Product;
import com.ly.bean.Supplier;
import com.ly.mapper.SupplierContactManMapper;
import com.ly.mapper.SupplierMapper;
import com.ly.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper SupplierMapper;

    @Override
    public Supplier queryOne(Supplier record) {
        return null;
    }

    @Override
    public List<Supplier> queryAll(Supplier record) {
        return SupplierMapper.selectAll();
    }

    @Override
    public int queryCount(Supplier record) {
        return 0;
    }

    @Override
    public Supplier queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(Supplier record) {
        return 0;
    }

    @Override
    public int addSelective(Supplier record) {
        return 0;
    }

    @Override
    public int delete(Supplier record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Supplier record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Supplier record) {
        return 0;
    }

    @Override
    public int queryCountByExample(Supplier example) {
        return 0;
    }

    @Override
    public List<Supplier> queryByExample(Supplier example) {
        return null;
    }

    @Override
    public R querySupplier(String supplierSimpleName, Integer page, Integer limit) {
        Example ex = new Example(Supplier.class);
        Example.Criteria criteria = ex.createCriteria();
        if(StringUtils.isNotBlank(supplierSimpleName)){
            criteria.andCondition(" supplier_simple_name like '%"+supplierSimpleName+"%'");
            PageHelper.startPage(page, limit, true);
            List<Supplier> infos = SupplierMapper.selectByExample(ex);
            int i = SupplierMapper.selectCountByExample(ex);
            return R.ok().put("data",infos).put("count",i);
        }else{
            PageHelper.startPage(page, limit, true);
            List<Supplier> infos = SupplierMapper.selectAll();
            int i = SupplierMapper.selectCountByExample(ex);
            return R.ok().put("data",infos).put("count",i);
        }
    }
}
