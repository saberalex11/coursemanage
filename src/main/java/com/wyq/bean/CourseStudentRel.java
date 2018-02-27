package com.wyq.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "course_student_rel")
public class CourseStudentRel implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**此id为课程教师关系的主键**/
    private Integer relId;

    private Integer studentId;

    private String studentName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**0停用 1启用**/
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRelId() {
        return relId;
    }

    public void setRelId(Integer relId) {
        this.relId = relId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseStudentRel{" +
                "id=" + id +
                ", relId=" + relId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
