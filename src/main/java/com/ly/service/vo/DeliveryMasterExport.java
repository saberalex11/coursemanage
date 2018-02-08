package com.ly.service.vo;

import java.io.Serializable;
import java.util.Date;

public class DeliveryMasterExport implements Serializable {

    private Integer deliveryId;

    private Date deliveryDate;

    private String deliveryAddress;

    private Double amount;

    private String customerSimpleName;

    private String chineseName;

    private String deliveryType;

    @Override
    public String toString() {
        return "DeliveryMasterExport{" +
                "deliveryId=" + deliveryId +
                ", deliveryDate=" + deliveryDate +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", amount=" + amount +
                ", customerSimpleName='" + customerSimpleName + '\'' +
                ", chineseName='" + chineseName + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                '}';
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCustomerSimpleName() {
        return customerSimpleName;
    }

    public void setCustomerSimpleName(String customerSimpleName) {
        this.customerSimpleName = customerSimpleName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

}
