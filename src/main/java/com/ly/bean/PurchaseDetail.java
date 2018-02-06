package com.ly.bean;

import javax.persistence.*;

@Table(name = "purchase_detail")
public class PurchaseDetail {

    @Id
    private Integer id;

    private Integer productId;

    private Integer purchaseId;

    private Integer purchaseQuantity;

    private Double purchaseUnitPrice;

    private Double purchaseAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

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

    @Override
    public String toString() {
        return "PurchaseDetail{" +
                "id=" + id +
                ", productId=" + productId +
                ", purchaseId=" + purchaseId +
                ", purchaseQuantity=" + purchaseQuantity +
                ", purchaseUnitPrice=" + purchaseUnitPrice +
                ", purchaseAmount=" + purchaseAmount +
                '}';
    }
}
