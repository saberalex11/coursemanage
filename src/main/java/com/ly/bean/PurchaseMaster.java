package com.ly.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "purchase_master")
public class PurchaseMaster {

    @Id
    private Integer purchaseId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date purchaseDate;

    private Integer supplierId;

    private Integer purchaseProperty;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getPurchaseProperty() {
        return purchaseProperty;
    }

    public void setPurchaseProperty(Integer purchaseProperty) {
        this.purchaseProperty = purchaseProperty;
    }

    @Override
    public String toString() {
        return "PurchaseMaster{" +
                "purchaseId=" + purchaseId +
                ", purchaseDate=" + purchaseDate +
                ", supplierId=" + supplierId +
                ", purchaseProperty=" + purchaseProperty +
                '}';
    }
}
