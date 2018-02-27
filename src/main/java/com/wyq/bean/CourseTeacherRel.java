package com.wyq.bean;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "course_teacher_rel")
public class CourseTeacherRel implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer teacherId;

    private String teacherName;

    private Integer courseId;

    private String courseName;

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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
        return "CourseTeacherRel{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
