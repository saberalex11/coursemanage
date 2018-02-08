package com.ly.controller.salesManage;

import com.ly.bean.SalesMan;
import com.ly.controller.BaseController;
import com.ly.service.DeliveryMasterService;
import com.ly.service.PurchaseDetailService;
import com.ly.service.PurchaseMasterService;
import com.ly.service.SalesManService;
import com.ly.service.vo.PurchaseVo;
import com.ly.service.vo.SalesVo;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesController extends BaseController {

    @Autowired
    private DeliveryMasterService deliveryMasterService;

    @RequestMapping("addDelivery")
    public R addDelivery(@RequestBody SalesVo vo){
        deliveryMasterService.addDelivery(vo);
        return R.ok();
    }

    @RequestMapping("reduceDelivery")
    public R reduceDelivery(@RequestBody SalesVo vo){
        return deliveryMasterService.reduceDelivery(vo);
    }
}
