package com.ly.service;

import com.ly.bean.PurchaseDetail;
import com.ly.mapper.ProductMapper;
import com.ly.mapper.PurchaseDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    @Override
    public PurchaseDetail queryOne(PurchaseDetail record) {
        return null;
    }

    @Override
    public List<PurchaseDetail> queryAll(PurchaseDetail record) {
        return null;
    }

    @Override
    public int queryCount(PurchaseDetail record) {
        return 0;
    }

    @Override
    public PurchaseDetail queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(PurchaseDetail record) {
        return 0;
    }

    @Override
    public int addSelective(PurchaseDetail record) {
        return 0;
    }

    @Override
    public int delete(PurchaseDetail record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PurchaseDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(PurchaseDetail record) {
        return 0;
    }

    @Override
    public int queryCountByExample(PurchaseDetail example) {
        return 0;
    }

    @Override
    public List<PurchaseDetail> queryByExample(PurchaseDetail example) {
        return null;
    }
}
