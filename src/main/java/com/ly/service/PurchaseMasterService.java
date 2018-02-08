package com.ly.service;

import com.ly.bean.PurchaseMaster;
import com.ly.service.vo.PurchaseVo;
import com.ly.utils.R;

public interface PurchaseMasterService extends BasicService<PurchaseMaster> {
     void addPurchase(PurchaseVo vo);
     R reducePuchase(PurchaseVo vo);
}
