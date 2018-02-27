package com.wyq.mapper;

import com.wyq.bean.Course;
import com.wyq.service.qco.CourseQCO;
import com.wyq.service.vo.CourseVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CourseMapper extends Mapper<Course> {

    public List<CourseVo> queryStudentCourse(CourseQCO qco);

    public int queryStudentCourseCount(CourseQCO qco);

    public List<CourseVo> queryTeacherCourse(CourseQCO qco);

    public int queryTeacherCourseCount(CourseQCO qco);
}
