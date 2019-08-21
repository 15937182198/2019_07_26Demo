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
    <title>&nbsp;</title>

</head>
<body>
<sec:authentication property="principal.username" scope="session" var="username"/>
</body>
<script>
    window.location.href="${pageContext.request.contextPath}/login/login";
</script>
</html>