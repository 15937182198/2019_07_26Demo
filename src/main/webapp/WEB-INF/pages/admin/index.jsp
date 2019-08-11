<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dys
  Date: 2019/7/26
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminstyle.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" media="all">
</head>
<body style="overflow: hidden">
<div class="layui-layout layui-layout-admin" id="layui_layout">
    <!-- 顶部区域 -->
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <!-- logo区域 -->
            <div class="admin-logo-box">
                <a class="logo" href="${pageContext.request.contextPath}/loginController/userShouYe" title="logo">后台管理系统</a>
            </div>
            <!-- 右侧导航 -->
            <ul class="layui-nav larry-header-item">
                <li class="layui-nav-item">
                    账户名：${pageContext.session.getAttribute("username")}
                </li>
                <li class="layui-nav-item">
                    <a href="/logout">
                        <i class="iconfont icon-exit"></i>
                        退出</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧侧边导航开始 -->
    <div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
        <div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">

            <!-- 左侧菜单 -->
            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item layui-this" >
                    <a href="${pageContext.request.contextPath}/loginController/userShouYe">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>后台首页</span>
                    </a>

                </li>
                <hr class="layui-bg-blue" style="margin: 0;padding: 0">
                <li class="layui-nav-item layui-this" >
                    <a href="${pageContext.request.contextPath}/account/pageInfo">
                        <i class="iconfont icon-sousuo2" data-icon='icon-home1'></i>
                        <span>用户信息</span>
                    </a>
                    <hr class="layui-bg-blue" style="margin: 0;padding: 0">
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="${pageContext.request.contextPath}/loginController/addUser">
                        <i class="iconfont icon-refurbish" data-icon='icon-home1'></i>
                        <span>添加用户</span>
                    </a>
                </li>
                <hr class="layui-bg-blue" style="margin: 0;padding: 0">

                <li class="layui-nav-item layui-this" >
                    <a href="${pageContext.request.contextPath}/account/ShopPageInfo">
                        <i class="iconfont icon-sousuo2" data-icon='icon-home1'></i>
                        <span>店铺信息</span>
                    </a>
                </li>
                <hr class="layui-bg-blue" style="margin: 0;padding: 0">

                <li class="layui-nav-item layui-this" >
                    <a href="${pageContext.request.contextPath}/loginController/addShop">
                        <i class="iconfont icon-refurbish" data-icon='icon-home1'></i>
                        <span>添加店铺</span>
                    </a>
                </li>
                <hr class="layui-bg-blue" style="margin: 0;padding: 0">
                <c:if test="${pageContext.session.getAttribute('username')=='root'}">
                    <li class="layui-nav-item layui-this" >
                        <a href="${pageContext.request.contextPath}/account/adminPageInfo">
                            <i class="iconfont icon-sousuo2" data-icon='icon-home1'></i>
                            <span>管理员信息</span>
                        </a>
                    </li>
                    <hr class="layui-bg-blue" style="margin: 0;padding: 0">
                <li class="layui-nav-item layui-this" >
                    <a href="${pageContext.request.contextPath}/loginController/userGuanLi">
                        <i class="iconfont icon-refurbish" data-icon='icon-home1'></i>
                        <span>添加管理员</span>
                    </a>
                </li>
                <hr class="layui-bg-blue" style="margin: 0;padding: 0">
                </c:if>
            </ul>
        </div>
    </div>
</div>
<!-- 加载js文件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/larry.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>
