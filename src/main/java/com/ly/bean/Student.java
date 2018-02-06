package com.ly.bean;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tbl_student")
public class Student implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private Integer sid;

    private String sname;

    private String scode;

    private String spassword;

    private Integer sage;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    @Override
    public String toString() {
        return "student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", scode='" + scode + '\'' +
                ", spassword='" + spassword + '\'' +
                ", sage=" + sage +
                '}';
    }
}
