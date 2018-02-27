package com.wyq.controller;

import com.wyq.bean.Account;
import com.wyq.bean.Course;
import com.wyq.service.CourseService;
import com.wyq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "course")
public class CourseController extends BaseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("queryAllCourse")
    public R queryAllCourse(){
        List<Course> courses = courseService.queryAllCourse();
        return R.ok().put("data",courses);
    }

    @RequestMapping("queryCourse")
    public R queryCourse(String courseName,String teacherName,Integer page, Integer limit){
        List<Course> courses = courseService.queryAllCourse();
        return R.ok().put("data",courses);
    }
}
