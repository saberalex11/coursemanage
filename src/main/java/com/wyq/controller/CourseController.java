package com.wyq.controller;

import com.wyq.bean.Account;
import com.wyq.bean.Course;
import com.wyq.service.CourseService;
import com.wyq.service.qco.CourseQCO;
import com.wyq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 学生查询可选课程
     * @param courseName
     * @param teacherName
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("queryCourse")
    public R queryCourse(String courseName,String teacherName,Integer page, Integer limit){
        return courseService.queryCourse(courseName,teacherName,page,limit);
    }

    /**
     * 学生选课
     * @param request
     * @param relId 课程-教师表的主键
     * @return
     */
    @RequestMapping("selectCourse")
    public R selectCourse(HttpServletRequest request,Integer relId){
        Account current = this.getCurrent(request);
        return courseService.selectCourse(current,relId);
    }

    /**
     * 学生退课
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("unSelectCourse")
    public R unSelectCourse(HttpServletRequest request,Integer id){
        Account current = this.getCurrent(request);
        return courseService.unSelectCourse(current,id);
    }


    /**
     * 学生查询已选课程
     * @param request
     * @param qco
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("queryStudentCourse")
    public R queryStudentCourse(HttpServletRequest request, CourseQCO qco, Integer page, Integer limit){
        Account current = this.getCurrent(request);
        return courseService.queryStudentCourse(current,qco,page,limit);
    }

    /**
     * 老师查看自己的课程信息
     * @param request
     * @param qco
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("queryTeacherCourse")
    public R queryTeacherCourse(HttpServletRequest request, CourseQCO qco, Integer page, Integer limit){
        Account current = this.getCurrent(request);
        return courseService.queryTeacherCourse(current,qco,page,limit);
    }

    @RequestMapping("updateTeacherCourse")
    public R updateTeacherCourse( Integer teacherId, Integer courseId){
        return courseService.updateTeacherCourse(teacherId,courseId);
    }
}
