package com.wyq.service;

import com.github.pagehelper.PageHelper;
import com.wyq.bean.Account;
import com.wyq.bean.Course;
import com.wyq.bean.CourseStudentRel;
import com.wyq.bean.CourseTeacherRel;
import com.wyq.mapper.CourseMapper;
import com.wyq.mapper.CourseStudentRelMapper;
import com.wyq.mapper.CourseTeacherRelMapper;
import com.wyq.service.qco.CourseQCO;
import com.wyq.service.vo.CourseVo;
import com.wyq.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseTeacherRelMapper courseTeacherRelMapper;

    @Autowired
    private CourseStudentRelMapper courseStudentRelMapper;

    @Override
    public List<Course> queryAllCourse() {
        return courseMapper.selectAll();
    }

    @Override
    public R queryCourse(String courseName, String teacherName, Integer page, Integer limit) {
        Example ex = new Example(CourseTeacherRel.class);
        Example.Criteria criteria = ex.createCriteria();

        if(StringUtils.isNotBlank(courseName)){
            criteria.andCondition(" course_name like '%"+courseName+"%'");
        }
        if(StringUtils.isNotBlank(teacherName)){
            criteria.andCondition(" teacher_name like '%"+teacherName+"%'");
        }
        criteria.andCondition(" status = 1");
        PageHelper.startPage(page, limit, true);
        List<CourseTeacherRel> courseTeacherRels = courseTeacherRelMapper.selectByExample(ex);
        int i = courseTeacherRelMapper.selectCountByExample(ex);
        return R.ok().put("data",courseTeacherRels).put("count",i);
    }

    @Override
    public R selectCourse(Account current, Integer relId) {
        Example ex = new Example(CourseStudentRel.class);
        Example.Criteria criteria = ex.createCriteria();

        //校验是否选过该课程
        criteria.andCondition(" student_id="+current.getId())
                .andCondition(" rel_id="+relId)
                .andCondition(" status = 1");
        List<CourseStudentRel> courseStudentRels = courseStudentRelMapper.selectByExample(ex);
        if(courseStudentRels != null && courseStudentRels.size() > 0){
            return R.error(-1,"你已经选过这门课程了");
        }

        //开始选课
        CourseStudentRel rel = new CourseStudentRel();
        rel.setCreateTime(new Date());
        rel.setRelId(relId);
        rel.setStatus(1);
        rel.setStudentId(current.getId());
        rel.setStudentName(current.getName());
        courseStudentRelMapper.insertSelective(rel);
        return R.ok();
    }

    @Override
    public R unSelectCourse(Account current, Integer id) {
        Example ex = new Example(CourseStudentRel.class);
        Example.Criteria criteria = ex.createCriteria();

        //校验是否选过该课程
        criteria.andCondition(" student_id="+current.getId())
                .andCondition(" id="+id)
                .andCondition(" status = 1");
        List<CourseStudentRel> courseStudentRels = courseStudentRelMapper.selectByExample(ex);
        if(courseStudentRels != null && courseStudentRels.size() > 0){
            CourseStudentRel rel = courseStudentRels.get(0);
            rel.setStatus(0);
            rel.setCreateTime(new Date());
            courseStudentRelMapper.updateByPrimaryKeySelective(rel);
            return R.ok();
        }
        return R.error(-1,"未查询到选过该门课程的记录");
    }

    @Override
    public R queryStudentCourse(Account current, CourseQCO qco, Integer page, Integer limit) {
        qco.setStudentId(current.getId());
        PageHelper.startPage(page, limit, true);
        List<CourseVo> courseVos = courseMapper.queryStudentCourse(qco);
        int count = courseMapper.queryStudentCourseCount(qco);
        return R.ok().put("data",courseVos).put("count",count);
    }

    @Override
    public R queryTeacherCourse(Account current, CourseQCO qco, Integer page, Integer limit) {
        qco.setTeacherId(current.getId());
        PageHelper.startPage(page, limit, true);
        List<CourseVo> courseVos = courseMapper.queryTeacherCourse(qco);
        int count = courseMapper.queryTeacherCourseCount(qco);
        return R.ok().put("data",courseVos).put("count",count);
    }

    @Override
    public R updateTeacherCourse(Integer teacherId, Integer courseId) {
        Example ex = new Example(CourseTeacherRel.class);
        Example.Criteria criteria = ex.createCriteria();

        //校验是否选过该课程
        criteria.andCondition(" teacher_id="+teacherId)
                .andCondition(" status = 1");
        List<CourseTeacherRel> courseTeacherRels = courseTeacherRelMapper.selectByExample(ex);
        CourseTeacherRel courseTeacherRel = courseTeacherRels.get(0);
        Course course = courseMapper.selectByPrimaryKey(courseId);
        courseTeacherRel.setCourseId(courseId);
        courseTeacherRel.setCourseName(course.getCourseName());
        courseTeacherRelMapper.updateByPrimaryKeySelective(courseTeacherRel);
        return R.ok();
    }
}
