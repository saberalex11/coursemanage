
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:v-bind="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>商品资料管理</title>
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
                <label class="layui-form-label">产品名称：</label>
                <div class="layui-input-inline">
                    <input type="text" name="prodcutName" placeholder="请输入名称" class="layui-input">
                </div>
                <a class="layui-btn" lay-submit lay-filter="productSearchFilter">查询</a>
            </div>
        </form>

        <div class="site-demo-button">
            <div>
                <a class="layui-btn layui-btn-primary" id="add" href="newProduct.jsp" >新增</a>
            </div>
        </div>
    </div>
    <div class="layui-tab layui-tab-brief" lay-filter="solutionTab">
        <div class="layui-tab-content" style="height: 100px;padding: 0px;margin: 0px;">
            <div class="layui-tab-item layui-show">
                <div class="layui-tab-item layui-show" style="padding:0px;">
                    <table id="productTableList" lay-filter="productTable"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<!--工具条 -->
<script type="text/html" id="productBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i>编辑</a>
    <a class="layui-btn layui-btn-xs" lay-event="delete"><i class="layui-icon">&#x1006;</i>删除</a>
</script>


<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../libs/jquery.min.js"></script>
<script type="text/javascript" src="../libs/vue.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/infoMange/productManage.js"></script>
</body>
</html>
