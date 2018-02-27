
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:v-bind="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>人员信息管理</title>
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
                <label class="layui-form-label">账号：</label>
                <div class="layui-input-inline">
                    <input type="text" name="account" placeholder="请输入账号" class="layui-input">
                </div>
                <label class="layui-form-label">名称：</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" placeholder="请输入名称" class="layui-input">
                </div>
                <a class="layui-btn" lay-submit lay-filter="searchFilter">查询</a>
            </div>
        </form>
    </div>
    <div class="layui-tab layui-tab-brief" >
        <div class="layui-tab-content" style="height: 100px;padding: 0px;margin: 0px;">
            <div class="layui-tab-item layui-show">
                <div class="layui-tab-item layui-show" style="padding:0px;">
                    <table id="accountTableList" lay-filter="accountTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="resetDiv" v-cloak style="display: none;width:500px;padding-top: 20px" class="layui-container">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-block">
                <input type="password" name="password" class="layui-input" v-model="password"/>
            </div>
        </div>
    </form>
</div>

<div id="editNameDiv" v-cloak style="display: none;width:500px;padding-top: 20px" class="layui-container">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">名称:</label>
            <div class="layui-input-block">
                <input type="text" name="name" class="layui-input" v-model="name"/>
            </div>
        </div>
    </form>
</div>

<!--工具条 -->
<script type="text/html" id="accountBar">
    <a class="layui-btn layui-btn-xs" lay-event="reset"><i class="layui-icon">&#xe705;</i>重置密码</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
    <a class="layui-btn layui-btn-xs" lay-event="delete"><i class="layui-icon">&#x1006;</i>删除</a>
</script>

<script type="text/html" id="TypeTpl">
    {{# if(d.accountType == 0){ }}
    <span class="label label-success">管理员</span>
    {{# } else if(d.accountType == 1){ }}
    <span class="label label-success">教师</span>
    {{# } else if(d.accountType == 2){ }}
    <span class="label label-success">学生</span>
    {{# }  }}
</script>

<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../libs/jquery.min.js"></script>
<script type="text/javascript" src="../libs/vue.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/account/accountManage.js"></script>
<script src="../libs/SHR256.min.js"></script>
</body>
</html>
