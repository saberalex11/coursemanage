package com.ly.service;

import com.ly.bean.*;
import com.ly.mapper.DeliveryDetailMapper;
import com.ly.mapper.DeliveryMasterMapper;
import com.ly.service.vo.SalesVo;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeliveryMasterServiceImpl implements DeliveryMasterService {

    @Autowired
    private DeliveryMasterMapper deliveryMasterMapper;

    @Autowired
    private DeliveryDetailMapper deliveryDetailMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    public static final String ADD_DELIVERY = "1";
    public static final String REDUCE_DELIVERY = "-1";

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

    @Override
    public R addDelivery(SalesVo vo) {
        //校验库存
        Map<String,Integer> productMap = new HashMap<>();
        List<DeliveryDetail> deliveryDetail = vo.getDeliveryDetail();
        for(DeliveryDetail t : deliveryDetail){
            if(productMap.get(t.getProductId()) != null){
                int count = productMap.get(t.getProductId());
                productMap.put(t.getProductId(),count+Integer.valueOf(t.getSalesQuantity()));
            }else{
                productMap.put(t.getProductId(),Integer.valueOf(t.getSalesQuantity()));
            }
        }
        for(String key:productMap.keySet()){
            Product product = productService.queryByPrimaryKey(Integer.valueOf(key));
            if(product.getQuantity() < productMap.get(key)){
                return R.error(-1,"商品编号为"+key+"的商品库存不足，无法销售");
            }
        }

        DeliveryMaster deliveryMaster = vo.getDeliveryMMaster();
        deliveryMaster.setDeliveryProperty(ADD_DELIVERY);
        //保存主表
        deliveryMasterMapper.insertSelective(deliveryMaster);

        //保存明细表
        for(DeliveryDetail t : deliveryDetail){
            t.setDeliveryId(deliveryMaster.getDeliveryId());
            deliveryDetailMapper.insertSelective(t);
            //刷新对应产品库存
            Product product = productService.queryByPrimaryKey(Integer.valueOf(t.getProductId()));
            product.setLastDeliveryDate(deliveryMaster.getDeliveryDate());
            product.setQuantity(product.getQuantity() - Integer.valueOf(t.getSalesQuantity()));
            productService.updateByPrimaryKeySelective(product);
        }
        //刷新客户表
        Customer customer = customerService.queryByPrimaryKey(deliveryMaster.getCustomerId());
        customer.setLastDeluveryDate(deliveryMaster.getDeliveryDate());
        customerService.updateByPrimaryKeySelective(customer);
        return R.ok();
    }

    @Override
    public R reduceDelivery(SalesVo vo) {
        DeliveryMaster deliveryMaster = vo.getDeliveryMMaster();
        deliveryMaster.setDeliveryProperty(REDUCE_DELIVERY);
        //保存主表
        deliveryMasterMapper.insertSelective(deliveryMaster);

        //保存明细表
        List<DeliveryDetail> deliveryDetail = vo.getDeliveryDetail();
        for(DeliveryDetail t : deliveryDetail){
            t.setDeliveryId(deliveryMaster.getDeliveryId());
            deliveryDetailMapper.insertSelective(t);
            //刷新对应产品库存
            Product product = productService.queryByPrimaryKey(Integer.valueOf(t.getProductId()));
            product.setLastDeliveryDate(deliveryMaster.getDeliveryDate());
            product.setQuantity(product.getQuantity() + Integer.valueOf(t.getSalesQuantity()));
            productService.updateByPrimaryKeySelective(product);
        }
        //刷新客户表
        Customer customer = customerService.queryByPrimaryKey(deliveryMaster.getCustomerId());
        customer.setLastDeluveryDate(deliveryMaster.getDeliveryDate());
        customerService.updateByPrimaryKeySelective(customer);
        return R.ok();
    }
}
