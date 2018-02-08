package com.ly.service.vo;

import java.io.Serializable;
import java.util.Date;

public class PurchaseMasterExport implements Serializable {

    private Date purchaseDate;

    private Double amount;

    private String supplierSimpleName;

    private String purchaseType;

    private Integer purchaseId;

    @Override
    public String toString() {
        return "PurchaseMasterExport{" +
                "purchaseDate=" + purchaseDate +
                ", amount=" + amount +
                ", supplierSimpleName='" + supplierSimpleName + '\'' +
                ", purchaseType='" + purchaseType + '\'' +
                ", purchaseId=" + purchaseId +
                '}';
    }

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSupplierSimpleName() {
        return supplierSimpleName;
    }

    public void setSupplierSimpleName(String supplierSimpleName) {
        this.supplierSimpleName = supplierSimpleName;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

}
