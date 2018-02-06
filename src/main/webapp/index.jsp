
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>水果进出货管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="./layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="./css/index.css" media="all"/>
    <link rel="stylesheet" href="./css/global.css" media="all"/>

</head>
<body class="main_body">
<div class="layui-layout layui-layout-admin" id="layui_layout">
    <!-- 顶部 -->
    <div class="layui-header header header-menu">
        <div class="layui-main">
            <a href="#" class="logo">水果进出货管理系统</a>

            <!-- 顶级菜单区域 -->
            <div class="larry-top-menu posb topMenu" id="topMenu">
            </div>
            <!-- 顶部右侧菜单 -->
            <div class="larry-right-menu posb">
                <ul class="layui-nav clearfix">
                    <li class="layui-nav-item" mobile>
                        <a href="login.html" class="signOut"><i class="iconfont icon-tuichu"></i> 退出</a>
                    </li>
                </ul>
            </div><!--顶部右侧菜单结束-->

        </div><!--layui-main 结束-->
    </div><!--顶部 结束-->

    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div class="user-photo">
            <a class="img" title="我的头像" ><img src="images/face.jpg"></a>
            <p>你好！<span class="userName">{{user.userAccount}}</span>, 欢迎登录</p>
        </div>
        <!-- 左侧菜单-->
        <div class="navBar layui-side-scroll" id="navBarId">
            <ul class="layui-nav clearfix layui-top-nav "  lay-filter="test">
            </ul>
        </div>
    </div>

    <!-- 主体main内容 -->
    <div class="layui-body layui-form">

        <div class="layui-tab marg0" lay-filter="bodyTab" id="top_tabs_box">
            <ul class="layui-tab-title top_tab" id="top_tabs">
                <li class="layui-this" lay-id=""><i class="iconfont icon-computer"></i> <cite>我的首页</cite></li>
            </ul>
            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <%--<a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>--%>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
                        <dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-guanbi4"></i> 关闭其他</a></dd>
                        <dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a></dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content clildFrame">
                <div class="layui-tab-item layui-show">
                    <iframe src=""></iframe>
                </div>
            </div>
        </div>

    </div>
    <!-- 底部 -->
    <div class="layui-footer footer">
        <p>copyright @2017 此处是底部版权文字</p>
    </div>

</div><!--layui_layout结束-->

<!-- 移动导航 -->
<div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
</div>
<div class="site-mobile-shade"></div>

<script type="text/javascript" src="libs/jquery.min.js"></script>
<script type="text/javascript" src="libs/vue.js"></script>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/index/index.js"></script>
</body>
</html>
