<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/27
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改管理员</title>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="all">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body class="childrenBody">
<jsp:include page="index.jsp" flush="true"/>
<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee; margin-top: 50px;background-color: #f1f2f7">
    <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
        <div class="layui-tab-content" style="min-height: 150px; margin-top: 25px;">
            <div class="layui-tab-item layui-show">
<div class="form-horizontal " style="margin-top: 70px;margin-left: 200px;">
    <span class="glyphicon glyphicon-user" aria-hidden="true" style="font-size: 25px; margin-left: 80px;margin-bottom: 30px;"> </span>&nbsp;&nbsp;<span style="font-family: '微软雅黑'; font-size: 25px">管理员</span>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">管理员：</label>
        <div class="col-xs-4">
            <input type="hidden" value="${account.accountId}" id="accountId">
            <input type="text" class="form-control" name="accountName" id="inputEmail3" value="${account.accountName}" readonly>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label" id="accountPassword">密码：</label>
        <div class="col-xs-4">
            <input type="password" class="form-control" name="accountPassword" id="inputPassword3" placeholder="数字或字母，只能为8~12位！">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">创建时间：</label>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="" value="${account.accountCreateDate}" readonly>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">确认修改</button>
        </div>
    </div>
</div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/newsadd.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("input[name='accountPassword']").blur(function () {
            var password=$("input[name='accountPassword']").val();
            var re = new RegExp(/^[a-zA-Z0-9]{4,8}$/);       // ^表示开始  $表示结束
            if (!re.test(password)){
                alert("密码必须为数字或字母，只能为8~12位！");
            }
        });
        $(".btn").click(function(){
            var val = $("#accountId").val();
            var password=$("input[name='accountPassword']").val();
            var re = new RegExp(/^[a-zA-Z0-9]{4,8}$/);       // ^表示开始  $表示结束
            if (!re.test(password)){
                alert("密码必须为数字或字母，只能为8~12位！");
                return;
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/account/updateAccountPassword",
                type:"POST",
                data:{"accountId":val,
                    "accountPassword":password},
                success:function (res) {
                    if (res == false){
                        alert("修改失败");
                    } else {
                        alert("修改成功");
                    }
                }
            })
        });
    });
</script>
</body>
</html>
