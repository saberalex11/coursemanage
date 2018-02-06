package com.ly.service;

import com.ly.bean.DeliveryDetail;
import com.ly.mapper.CustomerMapper;
import com.ly.mapper.DeliveryDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryDetailServiceImpl implements DeliveryDetailService {

    @Autowired
    private DeliveryDetailMapper deliveryDetailMapper;

    @Override
    public DeliveryDetail queryOne(DeliveryDetail record) {
        return null;
    }

    @Override
    public List<DeliveryDetail> queryAll(DeliveryDetail record) {
        return null;
    }

    @Override
    public int queryCount(DeliveryDetail record) {
        return 0;
    }

    @Override
    public DeliveryDetail queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(DeliveryDetail record) {
        return 0;
    }

    @Override
    public int addSelective(DeliveryDetail record) {
        return 0;
    }

    @Override
    public int delete(DeliveryDetail record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DeliveryDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(DeliveryDetail record) {
        return 0;
    }

    @Override
    public int queryCountByExample(DeliveryDetail example) {
        return 0;
    }

    @Override
    public List<DeliveryDetail> queryByExample(DeliveryDetail example) {
        return null;
    }
}
