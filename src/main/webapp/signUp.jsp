
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>选课管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="./layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="./css/signUp.css" media="all" />
    <link rel="shortcut icon" href="./favicon.ico">
</head>
<body>
<div class="video_mask"></div>
<div class="signup" id="dqapp" v-cloak>
    <h1>用户注册</h1>
    <div class="layui-form" action="">

        <div class="layui-form-item">
            <label class="layui-form-label left">类型：</label>
            <div class="layui-input-block">
                <select name="accountType" lay-verify="required" lay-search="" lay-filter="typeFilter">
                    <option value="0">管理员</option>
                    <option value="1">老师</option>
                    <option value="2">学生</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item layui-hide" id="courseSelect">
            <label class="layui-form-label left">课程：</label>
            <div class="layui-input-block">
                <select name="courseId" lay-verify="required" lay-search="" >
                    <%--<option v-for="course in courses"  v-bind:value="course.courseId">{{course.courseName}}</option>--%>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label left">账号：</label>
            <div class="layui-input-block">
                <input class="layui-input" name="userAccount" placeholder="账号" v-model="userAccount" type="text" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label left">姓名：</label>
            <div class="layui-input-block">
                <input class="layui-input" name="name" placeholder="姓名" v-model="name" type="text" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label left">密码：</label>
            <div class="layui-input-block">
                <input class="layui-input" name="password" placeholder="密码" v-model="password" type="password" >
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label left">确认密码：</label>
            <div class="layui-input-block">
                <input class="layui-input"  placeholder="密码" v-model="rePassword" type="password" >
            </div>
        </div>
        <button class="layui-btn login_btn layui-bg-blue"  @click="signUp">注册</button>
    </div>
</div>
<script src="layui/layui.js"></script>
<script src="libs/vue.min.js"></script>
<script src="libs/jquery.min.js"></script>
<script src="js/common.js"></script>
<script src="js/signUp.js"></script>
<script src="libs/SHR256.min.js"></script>
</body>
</html>
