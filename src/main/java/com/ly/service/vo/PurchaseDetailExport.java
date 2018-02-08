package com.ly.service.vo;

import java.io.Serializable;

public class PurchaseDetailExport implements Serializable {

    private Integer purchaseId;

    private Integer purchaseQuantity;

    private Double purchaseUnitPrice;

    private Double purchaseAmount;

    private String productName;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Double getPurchaseUnitPrice() {
        return purchaseUnitPrice;
    }

    public void setPurchaseUnitPrice(Double purchaseUnitPrice) {
        this.purchaseUnitPrice = purchaseUnitPrice;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "PurchaseDetailExport{" +
                "purchaseId=" + purchaseId +
                ", purchaseQuantity=" + purchaseQuantity +
                ", purchaseUnitPrice=" + purchaseUnitPrice +
                ", purchaseAmount=" + purchaseAmount +
                ", productName='" + productName + '\'' +
                '}';
    }
}
