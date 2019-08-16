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
    <title>购买店铺</title>
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
<div class="container" style="background-color: #e7eaed;padding-left: 300px;margin-top: 20px; padding-top: 15px;">
    <p class="text-left"><h2><span class="glyphicon glyphicon-user" aria-hidden="true"> </span> 购买店铺</h2></p>

    <div class="form-horizontal">
        <div class="form-group" style="margin-left: 15px;margin-top: 30px;">
            <label for="inputEmail3" class="col-sm-2 control-label">店铺名：</label>
            <div class="col-xs-4">
                <%--推荐人id--%>
                <input type="hidden" value="${pageContext.session.getAttribute("account").accountId}" id="referrer">
                <input type="text" class="form-control" id="inputEmail3" placeholder="数字或字母，只能为8~12位！" name="accountName">
                <span id="uname"></span>
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 15px;">
            <label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
            <div class="col-xs-4">
                <input type="password" class="form-control" id="inputPassword3" placeholder="数字或字母，只能为8~12位！" name="password">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 30px;">
            <label for="inputEmail3" class="col-sm-2 control-label">姓名：</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="inputEmail2" placeholder="" name="userName">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 30px;">
            <label for="inputEmail3" class="col-sm-2 control-label">联系方式：</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="inputEmail6" placeholder="" name="userPhone">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 30px;">
            <label for="inputEmail3" class="col-sm-2 control-label">收货地址：</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="inputEmail4" placeholder="" name="site">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 15px;">
            <label for="inputEmail3" class="col-sm-2 control-label">积分减少：</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="inputEmai14" value="1000" readonly="readonly">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 15px;">
            <div class="col-sm-offset-2 col-xs-4" style="text-align: center;margin-top: 15px;margin-bottom: 150px;">
                <p style="color: red">您的积分必须在10000以上才可购买，如果不够请联系管理员</p>
                <button type="submit" class="btn btn-default" style="background-color: #5bc0de;">确定</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){

        $("input[name='accountName']").blur(function () {
            var username = $("input[name='accountName']").val();
            var re = new RegExp(/^[a-zA-Z0-9]{4,8}$/);       // ^表示开始  $表示结束
            if (!re.test(username)){
                $("#uname").html("用户名必须为数字或字母，只能为8~12位！");
                return;
            }
            if (re.test(username)) {
                $("#uname").html("");
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/account/userFindAccountByAccountName",
                type:"POST",
                data:{
                    "accountName":username},
                success:function (res) {
                    if (res!=1){
                        $("#uname").html("该账号已存在!");
                    }else {
                        $("#uname").html("");
                    }
                }
            });
        });

        $(".btn").click(function(){
            var accountName=$("input[name='accountName']").val();
            var username=$("input[name='userName']").val();
            var password=$("input[name='password']").val();
            var userPhone=$("input[name='userPhone']").val();
            var site=$("input[name='site']").val();
            var re = new RegExp(/^[a-zA-Z0-9]{4,8}$/);       // ^表示开始  $表示结束
            if (!re.test(accountName)){
                alert("用户名必须为数字或字母，只能为8~12位！");
                return;
            }
            if (!re.test(password)){
                alert("密码必须为数字或字母，只能为8~12位！");
                return;
            }

            var accountId = $("#referrer").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/account/userSaveShop",
                type:"POST",
                data:{"referrer":accountId,
                    "accountName":username,
                    "accountPassword":password},
                success:function (res) {
                    if (res=="1"){
                        alert("该用户名已存在!");
                    }else if (res=="2"){
                        alert("您的积分不够11000请联系管理员");
                    }else if (res == false){
                        alert("购买失败");
                        window.location.href="${pageContext.request.contextPath}/loginController/userAdd";
                    }else {
                        alert("购买成功");
                        window.location.href="${pageContext.request.contextPath}/loginController/userAdd";
                    }
                }
            });
        });
    });
</script>
</body>
</html>
