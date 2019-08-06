<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改信息</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        .one{
            margin-top: 25px;
        }
        .margintop{
            margin-top: 70px;
        }

    </style>
</head>
<body>
<jsp:include page="main.jsp" flush="true"/>
<div class="container" style="background-color: #dff0d8;padding-left: 300px;margin-top: 20px; padding-top: 15px;">
    <p class="text-left"><h2><span class="glyphicon glyphicon-user" aria-hidden="true"> </span> 修改信息</h2></p>

    <form class="form-horizontal">
        <div class="form-group" style="margin-left: 15px;margin-top: 30px;">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名：</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="inputEmail3" placeholder="用户名" name="username">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 15px;">
            <label for="inputPassword3" class="col-sm-2 control-label">新密码：</label>
            <div class="col-xs-4">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 15px;">
            <div class="col-sm-offset-2 col-xs-4" style="text-align: center;margin-top: 15px;margin-bottom: 150px;">
                <button type="submit" class="btn btn-default" style="background-color: #5bc0de;">确定</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript">
    $(function(){
        $(".btn").click(function(){
            var username=$("input[name='username']").val();
            var password=$("input[name='password']").val();
            var re = new RegExp(/^[a-zA-Z0-9]{4,8}$/);       // ^表示开始  $表示结束
            if (!re.test(username)){
                alert("用户名必须为数字或字母，只能为8~12位！");
                return;
            }
            if (!re.test(password)){
                alert("密码必须为数字或字母，只能为8~12位！");
                return;
            }
        });
    });
</script>

</body>
</html>
