/*
Navicat MySQL Data Transfer

Source Server         : localhost@root
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : wyq

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-02-27 21:13:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `account_status` int(11) DEFAULT NULL,
  `account_type` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('2', 'admin', '1', '0', '2018-02-27 12:50:55', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '管理员1');
INSERT INTO `account` VALUES ('4', 'stu', '1', '2', '2018-02-27 12:51:27', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '学生1');
INSERT INTO `account` VALUES ('6', 'teacher3', '1', '1', '2018-02-27 12:56:49', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '老师3');
INSERT INTO `account` VALUES ('7', 'teacher4', '1', '1', '2018-02-27 16:50:16', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '老师4');
INSERT INTO `account` VALUES ('8', 'stu2', '1', '2', '2018-02-27 21:09:32', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '学生233');
INSERT INTO `account` VALUES ('9', '2323', '0', '2', '2018-02-27 19:14:10', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2323');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '课程1', '1');
INSERT INTO `course` VALUES ('2', '课程2', '1');

-- ----------------------------
-- Table structure for course_student_rel
-- ----------------------------
DROP TABLE IF EXISTS `course_student_rel`;
CREATE TABLE `course_student_rel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `rel_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_student_rel
-- ----------------------------
INSERT INTO `course_student_rel` VALUES ('1', '2018-02-27 16:34:45', '4', '0', '4', '学生1');
INSERT INTO `course_student_rel` VALUES ('2', '2018-02-27 16:47:22', '4', '0', '4', '学生1');
INSERT INTO `course_student_rel` VALUES ('3', '2018-02-27 16:48:06', '4', '0', '4', '学生1');
INSERT INTO `course_student_rel` VALUES ('4', '2018-02-27 16:48:09', '4', '1', '4', '学生1');
INSERT INTO `course_student_rel` VALUES ('5', '2018-02-27 16:50:47', '4', '1', '8', '学生2');
INSERT INTO `course_student_rel` VALUES ('6', '2018-02-27 16:50:49', '5', '1', '8', '学生2');
INSERT INTO `course_student_rel` VALUES ('7', '2018-02-27 16:51:51', '5', '0', '4', '学生1');
INSERT INTO `course_student_rel` VALUES ('8', '2018-02-27 16:52:02', '5', '1', '4', '学生1');

-- ----------------------------
-- Table structure for course_teacher_rel
-- ----------------------------
DROP TABLE IF EXISTS `course_teacher_rel`;
CREATE TABLE `course_teacher_rel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_teacher_rel
-- ----------------------------
INSERT INTO `course_teacher_rel` VALUES ('4', '2', '课程2', '2018-02-27 12:56:49', '1', '6', '老师3');
INSERT INTO `course_teacher_rel` VALUES ('5', '1', '课程1', '2018-02-27 16:50:16', '1', '7', '老师4');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_id` int(11) DEFAULT NULL,
  `create_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `notice_desc` varchar(2000) DEFAULT NULL,
  `notice_title` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '6', '老师3', '2018-02-27 17:54:45', '内容11111111', '标题1', '0');
INSERT INTO `notice` VALUES ('2', '6', '老师3', '2018-02-27 18:09:51', '222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222333222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222333222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222333', '2323', '1');
INSERT INTO `notice` VALUES ('3', '6', '老师3', '2018-02-27 18:10:17', '3333', '333', '1');
INSERT INTO `notice` VALUES ('4', '7', '老师4', '2018-02-27 18:10:58', '55555', '55555', '0');
INSERT INTO `notice` VALUES ('5', '7', '老师4', '2018-02-27 18:11:14', '123  是电风扇的', '售后发送的回复', '1');

-- ----------------------------
-- Table structure for tbl_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_menu`;
CREATE TABLE `tbl_sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型  1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `level` int(11) DEFAULT '-1' COMMENT '菜单的级别 1 一级菜单 2 二级菜单 3 三级菜单 按钮暂时定为-1',
  `status` tinyint(2) DEFAULT '1' COMMENT ' 0 删除 1正常',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10040 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of tbl_sys_menu
-- ----------------------------
INSERT INTO `tbl_sys_menu` VALUES ('10024', '0', '选课管理', null, null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10027', '0', '公告管理', null, null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10028', '0', '教务管理', null, null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10031', '10024', '我要选课', 'course/selectCourse.jsp', 'perm:student', '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10032', '10024', '我的课程', 'course/myCourseStu.jsp', 'perm:student', '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10033', '10027', '公告管理', 'notice/noticeManage.jsp', 'perm:teacher', '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10035', '10028', '人员信息管理', 'account/accountManage.jsp', 'perm:admin', '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10036', '10028', '课程信息管理', 'course/courseManage.jsp', 'perm:admin', '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10039', '10024', '我的课程', 'course/myCourseTeacher.jsp', 'perm:teacher', '1', null, '0', '1', '1');
