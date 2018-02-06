package com.ly.service;

import com.ly.bean.PurchaseMaster;
import com.ly.mapper.ProductMapper;
import com.ly.mapper.PurchaseMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseMasterServiceImpl implements PurchaseMasterService {

    @Autowired
    private PurchaseMasterMapper purchaseMasterMapper;

    @Override
    public PurchaseMaster queryOne(PurchaseMaster record) {
        return null;
    }

    @Override
    public List<PurchaseMaster> queryAll(PurchaseMaster record) {
        return null;
    }

    @Override
    public int queryCount(PurchaseMaster record) {
        return 0;
    }

    @Override
    public PurchaseMaster queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(PurchaseMaster record) {
        return 0;
    }

    @Override
    public int addSelective(PurchaseMaster record) {
        return 0;
    }

    @Override
    public int delete(PurchaseMaster record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PurchaseMaster record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(PurchaseMaster record) {
        return 0;
    }

    @Override
    public int queryCountByExample(PurchaseMaster example) {
        return 0;
    }

    @Override
    public List<PurchaseMaster> queryByExample(PurchaseMaster example) {
        return null;
    }
}
