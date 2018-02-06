package com.ly.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "product")
public class Product {

    @Id
    private Integer id;

    private String productName;

    private Integer safeStock;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastPurchaseDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastDeliveryDate;

    private Integer quantity;

    private Double suggestBuyPrice;

    private Double suggestSalePrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSafeStock() {
        return safeStock;
    }

    public void setSafeStock(Integer safeStock) {
        this.safeStock = safeStock;
    }

    public Date getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(Date lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    public Date getLastDeliveryDate() {
        return lastDeliveryDate;
    }

    public void setLastDeliveryDate(Date lastDeliveryDate) {
        this.lastDeliveryDate = lastDeliveryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSuggestBuyPrice() {
        return suggestBuyPrice;
    }

    public void setSuggestBuyPrice(Double suggestBuyPrice) {
        this.suggestBuyPrice = suggestBuyPrice;
    }

    public Double getSuggestSalePrice() {
        return suggestSalePrice;
    }

    public void setSuggestSalePrice(Double suggestSalePrice) {
        this.suggestSalePrice = suggestSalePrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", safeStock=" + safeStock +
                ", lastPurchaseDate=" + lastPurchaseDate +
                ", lastDeliveryDate=" + lastDeliveryDate +
                ", quantity=" + quantity +
                ", suggestBuyPrice=" + suggestBuyPrice +
                ", suggestSalePrice=" + suggestSalePrice +
                '}';
    }
}
