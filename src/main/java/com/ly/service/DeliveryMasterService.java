package com.ly.service;

import com.ly.bean.DeliveryMaster;
import com.ly.service.vo.PurchaseVo;
import com.ly.service.vo.SalesVo;
import com.ly.utils.R;

public interface DeliveryMasterService extends BasicService<DeliveryMaster> {

    R addDelivery(SalesVo vo);
    R reduceDelivery(SalesVo vo);
}
