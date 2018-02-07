package com.ly.controller.pruchaseManage;


import com.alibaba.fastjson.JSONObject;
import com.ly.controller.BaseController;
import com.ly.service.PurchaseDetailService;
import com.ly.service.PurchaseMasterService;
import com.ly.service.PurchaseVo;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("purchase")
public class PurchaseController extends BaseController{

    @Autowired
    private PurchaseMasterService purchaseMasterService;

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @RequestMapping("addPurchase")
    public R addPurchase(@RequestBody PurchaseVo vo){
        logger.info("=");
        return R.ok();
    }
}
