<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>积分交易</title>
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
    <script>
        $(function () {
            $("#sub").click(function () {
                var val = $("#accountId").val();
                var inputEmail3=$("#inputEmail3").val();
                var inputPassword3=$("#inputPassword3").val();
                $.ajax({
                    url:"${pageContext.request.contextPath}/account/transfer",
                    type:"POST",
                    data:{"accountId":val,
                        "accountName":inputEmail3,
                        "accountMoney":inputPassword3},
                    success:function (res) {
                        if (res==1){
                            alert("余额不足");
                            return;
                        }
                        if (res){
                            alert("交易成功");
                            window.location.href="${pageContext.request.contextPath}/loginController/userjiaoyi";
                        }else {
                            alert("交易失败");
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>


<jsp:include page="main.jsp" flush="true"/>

<div class="container" style="background-color: #e7eaed;padding-left: 300px;margin-top: 20px; padding-top: 15px;">
    <p class="text-left"><h2><span class="glyphicon glyphicon-transfer" aria-hidden="true"> </span> 积分交易</h2></p>

    <div class="form-horizontal">
        <div class="form-group" style="margin-left: 15px;margin-top: 30px;">
            <label for="inputEmail3" class="col-sm-2 control-label">交易给：</label>
            <div class="col-xs-4">
                <input type="hidden" id="accountId" value="${pageContext.session.getAttribute("account").accountId}">
                <input type="text" class="form-control" id="inputEmail3" placeholder="用户名">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 15px;">
            <label for="inputPassword3" class="col-sm-2 control-label">交易金额：</label>
            <div class="col-xs-4">
                <input type="text" class="form-control" id="inputPassword3" placeholder="请输入积分">
            </div>
        </div>
        <div class="form-group" style="margin-left: 15px;margin-top: 15px;">
            <div class="col-sm-offset-2 col-xs-4" style="text-align: center;margin-top: 15px;margin-bottom: 150px;">
                <button type="submit" id="sub" class="btn btn-default" style="background-color: #5bc0de;">确定</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>

