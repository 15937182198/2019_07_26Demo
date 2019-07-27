<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/27
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试后台登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <!-- load css -->
    <link rel="stylesheet" type="text/css" href="common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="css/login.css" media="all">
</head>

<body style="overflow: hidden">
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
    <h1>
        <strong>管理系统后台</strong>
        <em>Management System</em>
    </h1>
    <form autocomplete="on" action="login" method="post">
        <div class="layui-user-icon larry-login">
            <input name="username" type="text" placeholder="账号"  class="login_txtbx" autofocus required/>
        </div>
        <div class="layui-pwd-icon larry-login">
            <input name="password" type="password" placeholder="密码"  class="login_txtbx" autofocus required/>
        </div>
        <div class="layui-submit larry-login">
            <input type="submit" value="立即登陆" class="submit_btn"/>
        </div>
    </form>
    <div class="layui-login-text">
        <!--<p>版权所有</p>
        <p>鄂xxxxxx</p>-->
    </div>
</div>
<script type="text/javascript" src="common/layui/lay/dest/layui.all.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
    $(function(){
        $(".layui-canvs").jParticle({
            background: "#141414",
            color: "#E6E6E6"
        });
        //登录链接测试，使用时可删除
        $(".submit_btn").click(function(){
            var username=$("input[name='account']").val();
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
            // location.href="index.";
        });
    });
</script>
</body>
</html>
