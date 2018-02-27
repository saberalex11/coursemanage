<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 2018/2/6
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>修改公告</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../css/table-header.css">
    <link rel="stylesheet" href="../css/global.css">
</head>
<body>
<div class="layui-container" id="editApp">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>修改公告</legend>
    </fieldset>

    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"><em class="require">*</em>公告标题</label>
            <div class="layui-input-block">
                <input type="text" v-model="noticeTitle" name="noticeTitle" lay-verify="required" autocomplete="off" placeholder="公告标题" class="layui-input"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><em class="require">*</em>公告内容</label>
            <div class="layui-input-block">
                <textarea name="noticeDesc" v-model="noticeDesc" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>
            </div>
        </div>

        <input type="hidden" name="id" v-model="id"/>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="submit">提交</button>
                <a type="button" class="layui-btn layui-btn-danger" href="noticeManage.jsp">取消</a>
            </div>
        </div>
    </form>
</div>

</body>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../libs/jquery.min.js"></script>
<script type="text/javascript" src="../libs/vue.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/notice/editNotice.js"></script>
</html>
