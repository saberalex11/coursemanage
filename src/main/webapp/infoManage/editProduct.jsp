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
    <title>修改商品</title>
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
<div class="layui-container" id="editProductApp">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>修改商品</legend>
    </fieldset>

    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"><em class="require">*</em>产品名称</label>
            <div class="layui-input-block">
                <input v-model="productName" type="text" name="productName" lay-verify="required" autocomplete="off" placeholder="产品名称" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><em class="require">*</em>安全存量</label>
            <div class="layui-input-block">
                <input v-model="safeStock" type="text" name="safeStock" lay-verify="required|number" autocomplete="off" placeholder="安全存量" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><em class="require">*</em>库存</label>
            <div class="layui-input-block">
                <input v-model="quantity" type="text" name="quantity" lay-verify="required|number" autocomplete="off" placeholder="库存" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">建议购买价</label>
            <div class="layui-input-block">
                <input v-model="suggestBuyPrice" type="text" name="suggestBuyPrice" lay-verify="number" autocomplete="off" placeholder="建议购买价" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">建议销售价</label>
            <div class="layui-input-block">
                <input v-model="suggestSalePrice" type="text" name="suggestSalePrice" lay-verify="number" autocomplete="off" placeholder="建议销售价" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="productSubmit">提交</button>
                <a type="button" class="layui-btn layui-btn-danger" href="productManage.jsp">取消</a>
            </div>
        </div>
        <input type="hidden" name="id" v-model="id"/>
    </form>
</div>

</body>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../libs/jquery.min.js"></script>
<script type="text/javascript" src="../libs/vue.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/infoMange/editProduct.js"></script>
</html>
