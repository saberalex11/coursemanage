package com.ly.service.vo;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

public class DeliveryDetailExport implements Serializable {

    private Integer deliveryId;

    private Integer salesQuantity;

    private Double salesUnitPrice;

    private Double salesAmount;

    private String productName;

    @Override
    public String toString() {
        return "DeliveryDetailExport{" +
                "deliveryId=" + deliveryId +
                ", salesQuantity=" + salesQuantity +
                ", salesUnitPrice=" + salesUnitPrice +
                ", salesAmount=" + salesAmount +
                ", productName='" + productName + '\'' +
                '}';
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public Double getSalesUnitPrice() {
        return salesUnitPrice;
    }

    public void setSalesUnitPrice(Double salesUnitPrice) {
        this.salesUnitPrice = salesUnitPrice;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
