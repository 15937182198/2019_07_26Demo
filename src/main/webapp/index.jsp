<%--
  Created by IntelliJ IDEA.
  User: Dys
  Date: 2019/7/27
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script>
        $(function () {
            $("#form").submit();
        });
    </script>
</head>
<body>

<sec:authentication property="principal.username" scope="session" var="username"/>
<form action="loginController/login" method="post" id="form">
    <input type="hidden" name="accountName" value="${sessionScope.username}">
</form>
</body>
</html>
