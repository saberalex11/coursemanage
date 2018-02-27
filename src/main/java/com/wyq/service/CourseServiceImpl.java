package com.wyq.service;

import com.wyq.bean.Course;
import com.wyq.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> queryAllCourse() {
        return courseMapper.selectAll();
    }
}
