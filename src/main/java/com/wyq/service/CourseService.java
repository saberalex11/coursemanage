package com.wyq.service;

import com.wyq.bean.Account;
import com.wyq.bean.Course;
import com.wyq.service.qco.CourseQCO;
import com.wyq.utils.R;

import java.util.List;

public interface CourseService {
    List<Course> queryAllCourse();

    R queryCourse(String courseName,String teacherName,Integer page, Integer limit);

    R selectCourse(Account current,Integer relId);

    R unSelectCourse(Account current,Integer relId);

    R queryStudentCourse(Account current, CourseQCO qco, Integer page, Integer limit);

    R queryTeacherCourse(Account current, CourseQCO qco, Integer page, Integer limit);
}
