<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>报表导出</title>
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
<div class="layui-container" id="newProductApp">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>报表导出</legend>
    </fieldset>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <a href="${pageContext.request.contextPath}/export/exportPurchase.do" type="button" class="layui-btn" >采购导出</a>
            <a href="${pageContext.request.contextPath}/export/deliveryExport.do" type="button" class="layui-btn layui-btn-danger" >销售导出</a>
        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../libs/jquery.min.js"></script>
<script type="text/javascript" src="../libs/vue.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
</html>
