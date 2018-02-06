package com.ly.service;

import com.ly.bean.DeliveryMaster;
import com.ly.mapper.DeliveryDetailMapper;
import com.ly.mapper.DeliveryMasterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryMasterServiceImpl implements DeliveryMasterService {

    @Autowired
    private DeliveryMasterMapper deliveryMasterMapper;

    @Override
    public DeliveryMaster queryOne(DeliveryMaster record) {
        return null;
    }

    @Override
    public List<DeliveryMaster> queryAll(DeliveryMaster record) {
        return null;
    }

    @Override
    public int queryCount(DeliveryMaster record) {
        return 0;
    }

    @Override
    public DeliveryMaster queryByPrimaryKey(Object key) {
        return null;
    }

    @Override
    public int add(DeliveryMaster record) {
        return 0;
    }

    @Override
    public int addSelective(DeliveryMaster record) {
        return 0;
    }

    @Override
    public int delete(DeliveryMaster record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DeliveryMaster record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(DeliveryMaster record) {
        return 0;
    }

    @Override
    public int queryCountByExample(DeliveryMaster example) {
        return 0;
    }

    @Override
    public List<DeliveryMaster> queryByExample(DeliveryMaster example) {
        return null;
    }
}
