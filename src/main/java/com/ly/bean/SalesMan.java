package com.ly.bean;

import javax.persistence.*;

@Table(name = "sales_man")
public class SalesMan {

    @Id
    private Integer salesManId;

    private String chineseName;

    private String englishName;

    private String telephone;

    private String mobilePhone;

    private String contactAddress;

    private String email;

    public Integer getSalesManId() {
        return salesManId;
    }

    public void setSalesManId(Integer salesManId) {
        this.salesManId = salesManId;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SalesMan{" +
                "salesManId=" + salesManId +
                ", chineseName='" + chineseName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
