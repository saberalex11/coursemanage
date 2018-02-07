package com.ly.service;

import com.github.pagehelper.PageHelper;
import com.ly.bean.Product;
import com.ly.mapper.DeliveryMasterMapper;
import com.ly.mapper.ProductMapper;
import com.ly.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product queryOne(Product record) {
        return null;
    }

    @Override
    public List<Product> queryAll(Product record) {
        return productMapper.selectAll();
    }

    @Override
    public int queryCount(Product record) {
        return 0;
    }

    @Override
    public Product queryByPrimaryKey(Object key) {
        return productMapper.selectByPrimaryKey(key);
    }

    @Override
    public int add(Product record) {
        return 0;
    }

    @Override
    public int addSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public int delete(Product record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return productMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int queryCountByExample(Product example) {
        return 0;
    }

    @Override
    public List<Product> queryByExample(Product example) {
        return null;
    }

    @Override
    public R queryProduct(String prodcutName, Integer page, Integer limit) {
        Example ex = new Example(Product.class);
        Example.Criteria criteria = ex.createCriteria();
        if(StringUtils.isNotBlank(prodcutName)){
            criteria.andCondition(" product_name like '%"+prodcutName+"%'");
            PageHelper.startPage(page, limit, true);
            List<Product> products = productMapper.selectByExample(ex);
            int i = productMapper.selectCountByExample(ex);
            return R.ok().put("data",products).put("count",i);
        }else{
            PageHelper.startPage(page, limit, true);
            List<Product> products = productMapper.selectAll();
            int i = productMapper.selectCountByExample(ex);
            return R.ok().put("data",products).put("count",i);
        }
    }
}
