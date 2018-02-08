package com.ly.service;

import com.ly.bean.Product;
import com.ly.bean.PurchaseDetail;
import com.ly.bean.PurchaseMaster;
import com.ly.mapper.PurchaseDetailMapper;
import com.ly.mapper.PurchaseMasterMapper;
import com.ly.service.vo.PurchaseVo;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseMasterServiceImpl implements PurchaseMasterService {

    @Autowired
    private PurchaseMasterMapper purchaseMasterMapper;

    @Autowired
    private PurchaseDetailMapper purchaseDetailMapper;

    @Autowired
    private ProductService productService;
    
    public static final int ADD_PURCHASE = 1;
    public static final int REDUCE_PURCHASE = -1;

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

    @Override
    public void addPurchase(PurchaseVo vo) {
        PurchaseMaster purchaseMaster = vo.getPurchaseMaster();
        purchaseMaster.setPurchaseProperty(ADD_PURCHASE);
        //保存主表
        purchaseMasterMapper.insertSelective(purchaseMaster);

        //保存明细表
        List<PurchaseDetail> purchaseDetail = vo.getPurchaseDetail();
        for(PurchaseDetail t : purchaseDetail){
            t.setPurchaseId(purchaseMaster.getPurchaseId());
            purchaseDetailMapper.insertSelective(t);
            //刷新对应产品库存
            Product product = productService.queryByPrimaryKey(t.getProductId());
            product.setLastPurchaseDate(purchaseMaster.getPurchaseDate());
            product.setQuantity(product.getQuantity() + t.getPurchaseQuantity());
            productService.updateByPrimaryKeySelective(product);
        }


    }

    @Override
    public R reducePuchase(PurchaseVo vo) {
        //校验库存
        Map<Integer,Integer> productMap = new HashMap<>();
        List<PurchaseDetail> purchaseDetail = vo.getPurchaseDetail();
        for(PurchaseDetail t : purchaseDetail){
            if(productMap.get(t.getProductId()) != null){
                int count = productMap.get(t.getProductId());
                productMap.put(t.getProductId(),count+t.getPurchaseQuantity());
            }else{
                productMap.put(t.getProductId(),t.getPurchaseQuantity());
            }
        }
        for(int key:productMap.keySet()){
            Product product = productService.queryByPrimaryKey(key);
            if(product.getQuantity() < productMap.get(key)){
                return R.error(-1,"商品编号为"+key+"的商品库存不足，无法出库");
            }
        }
        PurchaseMaster purchaseMaster = vo.getPurchaseMaster();
        purchaseMaster.setPurchaseProperty(REDUCE_PURCHASE);
        //保存主表
        purchaseMasterMapper.insertSelective(purchaseMaster);

        //保存明细表
        for(PurchaseDetail t : purchaseDetail){
            t.setPurchaseId(purchaseMaster.getPurchaseId());
            purchaseDetailMapper.insertSelective(t);
            //刷新对应产品库存
            Product product = productService.queryByPrimaryKey(t.getProductId());
            product.setLastPurchaseDate(purchaseMaster.getPurchaseDate());
            product.setQuantity(product.getQuantity() - t.getPurchaseQuantity());
            productService.updateByPrimaryKeySelective(product);
        }
        return R.ok();
    }
}
