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
    <title>添加店铺</title>
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
<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee; margin-top: 50px; background-color: #f1f2f7">
    <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
        <div class="layui-tab-content" style="min-height: 150px; margin-top: 25px;">
            <div class="layui-tab-item layui-show">
                <div class="form-horizontal "style="margin-top: 70px;margin-left: 200px;">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">店铺名：</label>
                        <div class="col-xs-4">
                            <input type="hidden" id="referrer" value="1">
                            <input type="text" class="form-control" name="accountName" id="inputEmail3" placeholder="数字或字母，只能为8~12位！">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
                        <div class="col-xs-4">
                            <input type="password" class="form-control" name="accountPassword" id="inputPassword3" placeholder="数字或字母，只能为8~12位！">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">姓名：</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" name="userName" id="inputEmai14">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">联系方式：</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" name="userPhone" id="inputEmai15">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">收货地址：</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" name="site" id="inputEmai16">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">分润：</label>
                        <div class="col-xs-4">
                            <select class="form-control" name="param" id="param">
                                <option selected="selected" value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                    </div>
                    <input type="hidden" value="1" name="referrer">
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">提交</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/newsadd.js"></script>
<script charset="UTF-8" type="text/javascript">
    $(function(){
        $(".btn").click(function(){
            var username=$("input[name='accountName']").val();
            var password=$("input[name='accountPassword']").val();
            var userName=$("input[name='userName']").val();
            var userPhone=$("input[name='userPhone']").val();
            var site=$("input[name='site']").val();
            var param=$("#param").val();
            var re = new RegExp(/^[a-zA-Z0-9]{4,8}$/);       // ^表示开始  $表示结束
            if (!re.test(username)){
                alert("用户名必须为数字或字母，只能为8~12位！");
                return;
            }
            if (!re.test(password)){
                alert("密码必须为数字或字母，只能为8~12位！");
                return;
            }
            var referrer=$("#referrer").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/account/saveShop.admin",
                type:"POST",
                data:{"accountName":username,
                    "param":param,
                    "userName":username,
                    "userPhone":userPhone,
                    "site":site,
                    "accountPassword":password,
                "referrer":referrer},
                success:function (res) {
                    if (res == false){
                        alert("添加失败");
                        window.location.href="${pageContext.request.contextPath}/loginController/userShouYe";
                        return;
                    }
                    if (res=="1") {
                        alert("该用户已存在!");
                        return;
                    }
                    if (res!=true&&res!="1") {
                        alert("添加成功");
                        window.location.href="${pageContext.request.contextPath}/loginController/userShouYe";
                        return;
                    }
                }
            });
        });
    });

</script>
</body>
</html>

