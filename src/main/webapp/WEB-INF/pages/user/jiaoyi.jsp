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
</head>
<body>


<jsp:include page="main.jsp" flush="true"/>

<div class="container">
    <p class="text-left"><h2><span class="glyphicon glyphicon-transfer" aria-hidden="true"> </span> 积分交易</h2></p>
    <div class="row">
        <table class="table">
            <!-- On cells (`td` or `th`) -->
            <tr>
                <td class="active">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">交易给：</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputEmail3" placeholder="用户名" ">
                            </div>
                        </div>
                    </form>
                </td>
            </tr>
        </table>
    </div>

    <div class="row">
        <table class="table">
            <!-- On cells (`td` or `th`) -->
            <tr>
                <td class="success">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">交易数量：</label>
                            <div class="col-xs-4">
                                <input type="text" class="form-control" id="inputEmail3" placeholder="积分" ">
                            </div>
                        </div>
                    </form>
                </td>
            </tr>
        </table>
    </div>
    <div class="row">
        <table class="table">
            <!-- On cells (`td` or `th`) -->
            <tr>
                <td class="warning">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <div class="col-xs-4">
                                <button type="submit" class="btn btn-default" style="margin-left: 320px;">确定</button>
                            </div>
                        </div>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>

