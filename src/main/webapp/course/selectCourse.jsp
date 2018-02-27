
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:v-bind="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>选课</title>
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="Access-Control-Allow-Origin" content="*"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <link rel="shortcut icon" href="/favicon.ico"/>

    <link rel="stylesheet" href="../layui/css/layui.css"/>
    <link rel="stylesheet" href="../css/global.css"/>
    <link rel="stylesheet" href="../css/table-header.css"/>
    <link rel="stylesheet" href="../plugins/webuploader/webuploader.css"/>
</head>
<body>
<div id="productManageApp" v-cloak>
    <div  class="layui-form geec-tab">
        <form class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">课程名称：</label>
                <div class="layui-input-inline">
                    <input type="text" name="courseName" placeholder="请输入名称" class="layui-input">
                </div>
                <label class="layui-form-label">教师名称：</label>
                <div class="layui-input-inline">
                    <input  type="text" name="teacherName" placeholder="请输入名称"  class="layui-input">
                </div>
                <a class="layui-btn" lay-submit lay-filter="searchFilter">查询</a>
            </div>
        </form>
    </div>
    <div class="layui-tab layui-tab-brief" lay-filter="solutionTab">
        <div class="layui-tab-content" style="height: 100px;padding: 0px;margin: 0px;">
            <div class="layui-tab-item layui-show">
                <div class="layui-tab-item layui-show" style="padding:0px;">
                    <table id="courseTableList" lay-filter="courseTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>


<!--工具条 -->
<script type="text/html" id="courseBar">
    <a class="layui-btn layui-btn-xs" lay-event="selectCourse"><i class="layui-icon">&#xe605;</i>选课</a>
</script>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../libs/jquery.min.js"></script>
<script type="text/javascript" src="../libs/vue.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/course/selectCourse.js"></script>
</body>
</html>
