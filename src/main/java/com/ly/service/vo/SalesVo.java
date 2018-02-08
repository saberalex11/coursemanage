package com.ly.service.vo;

import com.ly.bean.DeliveryDetail;
import com.ly.bean.DeliveryMaster;
import com.ly.bean.PurchaseDetail;

import java.io.Serializable;
import java.util.List;

public class SalesVo implements Serializable {

    private DeliveryMaster deliveryMaster;

    private List<DeliveryDetail> deliveryDetail;

    public DeliveryMaster getDeliveryMMaster() {
        return deliveryMaster;
    }

    public void setDeliveryMaster(DeliveryMaster deliveryMaster) {
        this.deliveryMaster = deliveryMaster;
    }

    public List<DeliveryDetail> getDeliveryDetail() {
        return deliveryDetail;
    }

    public void setDeliveryDetail(List<DeliveryDetail> deliveryDetail) {
        this.deliveryDetail = deliveryDetail;
    }

    @Override
    public String toString() {
        return "SalesVo{" +
                "deliveryMaster=" + deliveryMaster +
                ", deliveryDetail=" + deliveryDetail +
                '}';
    }
}
