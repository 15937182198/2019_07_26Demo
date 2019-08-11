<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>推荐人</title>
    <!-- Bootstrap -->
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
    <!--[endif]-->
</head>
<body>
<jsp:include page="main.jsp" flush="true"/>
<div class="container" style="background-color: #e7eaed;margin-top: 20px; padding-top: 15px;height: 500px">
    <p class="text-left"><h2><span class="glyphicon glyphicon-user" aria-hidden="true"> </span> 推荐人</h2></p>

    <div class="form-horizontal">
        <table class="table table-bordered">
          <tr>
              <td>上级用户</td>
              <td>下级用户1</td>
              <td>下级用户2</td>
          </tr>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
