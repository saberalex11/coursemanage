
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
    <link rel="stylesheet" href="./css/login.css" media="all" />
    <link rel="shortcut icon" href="./favicon.ico">
</head>
<body>
<div class="video_mask"></div>
<div class="login" id="dqapp" v-cloak>
    <h1>选课管理系统</h1>
    <div class="layui-form">
        <div class="layui-form-item">
            <input class="layui-input" name="userAccount" placeholder="用户名" v-model="userAccount" type="text" >
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="password" placeholder="密码" v-model="password" type="password" >
        </div>
        <div class="layui-row">
            <div class="layui-col-xs6 left">
                <button class="layui-btn login_btn layui-bg-blue"  @click="signUp">注册</button>
            </div>
            <div class="layui-col-xs6 right">
                <button class="layui-btn login_btn layui-bg-blue"  @click="login">登录</button>
            </div>
        </div>
    </div>
</div>
<script src="layui/layui.js"></script>
<script src="libs/vue.min.js"></script>
<script src="libs/jquery.min.js"></script>
<script src="js/common.js"></script>
<script src="js/login.js"></script>
<script src="libs/SHR256.min.js"></script>
</body>
</html>
