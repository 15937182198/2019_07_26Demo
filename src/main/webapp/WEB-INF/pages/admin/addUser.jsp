<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/bootstrap/css/bootstrap.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/global.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personal.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminstyle.css" media="all">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body class="childrenBody">
<jsp:include page="index.jsp" flush="true"/>
<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee; margin-top: 50px;">
    <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">

        <div class="layui-tab-content" style="min-height: 150px; margin-top: 25px;">
            <div class="layui-tab-item layui-show">
                <form class="form-horizontal ">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
                        <div class="col-xs-4">
                            <input type="email" class="form-control" name="" id="inputEmail3" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
                        <div class="col-xs-4">
                            <input type="password" class="form-control" name="" id="inputPassword3" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">积分余额：</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" id="" name="" value="1000" readonly>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">用户权限：</label>
                        <div class="col-xs-4" style="height:40px;">
                            <select class="form-control">
                                <option selected="selected" value="1">普通用户</option>
                                <option value="3">后台管理</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">确认修改</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/newsadd.js"></script>

</body>
</html>

