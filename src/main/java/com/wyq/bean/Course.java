package com.wyq.bean;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "course")
public class Course implements Serializable {

    @Id
    private Integer id;

    private String courseName;

    /**0停用 1启用**/
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", status=" + status +
                '}';
    }
}
