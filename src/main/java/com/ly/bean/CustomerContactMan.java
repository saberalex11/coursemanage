package com.ly.bean;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "customer_contact_man")
public class CustomerContactMan implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact_man.contact_id
     *
     * @mbggenerated
     */
    @Id
    private Integer contactId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact_man.chinese_name
     *
     * @mbggenerated
     */
    private String chineseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact_man.english_name
     *
     * @mbggenerated
     */
    private String englishName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact_man.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact_man.telephone
     *
     * @mbggenerated
     */
    private String telephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact_man.mobile_phone
     *
     * @mbggenerated
     */
    private String mobilePhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_contact_man.customer_id
     *
     * @mbggenerated
     */
    private Integer customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer_contact_man
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact_man.contact_id
     *
     * @return the value of customer_contact_man.contact_id
     *
     * @mbggenerated
     */
    public Integer getContactId() {
        return contactId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact_man.contact_id
     *
     * @param contactId the value for customer_contact_man.contact_id
     *
     * @mbggenerated
     */
    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact_man.chinese_name
     *
     * @return the value of customer_contact_man.chinese_name
     *
     * @mbggenerated
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact_man.chinese_name
     *
     * @param chineseName the value for customer_contact_man.chinese_name
     *
     * @mbggenerated
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact_man.english_name
     *
     * @return the value of customer_contact_man.english_name
     *
     * @mbggenerated
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact_man.english_name
     *
     * @param englishName the value for customer_contact_man.english_name
     *
     * @mbggenerated
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact_man.title
     *
     * @return the value of customer_contact_man.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact_man.title
     *
     * @param title the value for customer_contact_man.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact_man.telephone
     *
     * @return the value of customer_contact_man.telephone
     *
     * @mbggenerated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact_man.telephone
     *
     * @param telephone the value for customer_contact_man.telephone
     *
     * @mbggenerated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact_man.mobile_phone
     *
     * @return the value of customer_contact_man.mobile_phone
     *
     * @mbggenerated
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact_man.mobile_phone
     *
     * @param mobilePhone the value for customer_contact_man.mobile_phone
     *
     * @mbggenerated
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_contact_man.customer_id
     *
     * @return the value of customer_contact_man.customer_id
     *
     * @mbggenerated
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_contact_man.customer_id
     *
     * @param customerId the value for customer_contact_man.customer_id
     *
     * @mbggenerated
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_contact_man
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CustomerContactMan other = (CustomerContactMan) that;
        return (this.getContactId() == null ? other.getContactId() == null : this.getContactId().equals(other.getContactId()))
            && (this.getChineseName() == null ? other.getChineseName() == null : this.getChineseName().equals(other.getChineseName()))
            && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getMobilePhone() == null ? other.getMobilePhone() == null : this.getMobilePhone().equals(other.getMobilePhone()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_contact_man
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getContactId() == null) ? 0 : getContactId().hashCode());
        result = prime * result + ((getChineseName() == null) ? 0 : getChineseName().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getMobilePhone() == null) ? 0 : getMobilePhone().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_contact_man
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", contactId=").append(contactId);
        sb.append(", chineseName=").append(chineseName);
        sb.append(", englishName=").append(englishName);
        sb.append(", title=").append(title);
        sb.append(", telephone=").append(telephone);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", customerId=").append(customerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}