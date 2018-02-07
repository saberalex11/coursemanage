package com.ly.service;

import com.ly.bean.PurchaseDetail;
import com.ly.bean.PurchaseMaster;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class PurchaseVo implements Serializable {

    private PurchaseMaster purchaseMaster;

    private List<PurchaseDetail> purchaseDetail;

    public PurchaseMaster getPurchaseMaster() {
        return purchaseMaster;
    }

    public void setPurchaseMaster(PurchaseMaster purchaseMaster) {
        this.purchaseMaster = purchaseMaster;
    }

    public List<PurchaseDetail> getPurchaseDetail() {
        return purchaseDetail;
    }

    public void setPurchaseDetail(List<PurchaseDetail> purchaseDetail) {
        this.purchaseDetail = purchaseDetail;
    }
}
