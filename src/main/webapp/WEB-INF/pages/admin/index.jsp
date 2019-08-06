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


</head>
<body style="overflow: hidden">
<div class="layui-layout layui-layout-admin" id="layui_layout">
    <!-- 顶部区域 -->
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <!-- logo区域 -->
            <div class="admin-logo-box">
                <a class="logo" href="http://www.kuxuebao.net" title="logo">后台管理系统</a>
                <div class="larry-side-menu" style="background: #23262E;">
                    <i class="fa fa-bars" aria-hidden="true" ></i>
                </div>
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
                    <a href="javascript:;" data-url="main.jsp">
                        <i class="iconfont icon-home1" data-icon='icon-home1'></i>
                        <span>后台首页</span>
                    </a>
                </li>
                <!-- 个人信息 -->
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli" ></i>
                        <span>用户管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="${pageContext.request.contextPath}/loginController/userInfor" data-url="table.jsp">
                                <i class="iconfont icon-geren1" data-icon='icon-geren1'></i>
                                <span>用户信息</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/loginController/userInforUpdate" data-url="changepwd.jsp">
                                <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                                <span>修改信息</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="changepwd.html">
                                <i class="iconfont icon-iconfuzhi01" data-icon='icon-iconfuzhi01'></i>
                                <span>新增用户</span>
                            </a>
                        </dd>
                    </dl>
                </li>
                <!-- 用户管理 -->
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <i class="iconfont icon-jiaoseguanli2" ></i>
                        <span>店铺管理</span>
                        <em class="layui-nav-more"></em>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="${pageContext.request.contextPath}/loginController/userInfor" data-url="table.jsp">
                                <i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
                                <span>店铺信息</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;"  data-url="table_1.jsp">
                                <i class="iconfont icon-jiaoseguanli4" data-icon='icon-jiaoseguanli4'></i>
                                <span>用的上就用</span>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" data-url="myloginfo.jsp">
                                <i class="iconfont icon-quanxian2" data-icon='icon-quanxian2'></i>
                                <span>用不上就删</span>
                            </a>
                        </dd>
                    </dl>
                </li>

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
