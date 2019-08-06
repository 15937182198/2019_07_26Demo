<%--
  Created by IntelliJ IDEA.
  User: Dys
  Date: 2019/7/26
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
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
<jsp:include page="main.jsp"/>
<%--<%@include file="main.jsp"%>--%>
<div class="container">        <!--0-start-->
    <div class="row"><!--0-2start-->
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/img/1.jpg" alt="...">
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/img/2.jpg" alt="...">

                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/img/3.jpg" alt="...">

                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div><!--0-2end-->

    <div class="row one"><!--3start -->
        <!--导航栏-------------------------------------->
        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">产品详情:</a>
                    <table class="table table-hover">
                        <tr>
                            <td>123</td>
                            <td>456</td>
                            <td>789</td>
                            <td>123</td>
                            <td>456</td>
                            <td>789</td>
                        </tr>
                        <tr>
                            <td>123</td>
                            <td>456</td>
                            <td>789</td>
                            <td>121</td>
                            <td>789</td>
                            <td>121</td>
                        </tr>
                        <tr>
                            <td>123</td>
                            <td>456</td>
                            <td>789</td>
                            <td>121</td>
                            <td>789</td>
                            <td>121</td>
                        </tr>

                    </table>

                </div>
            </div>
        </nav>
        <!--导航条结束-------------------------------------->
    </div><!-- 3end -->

    <div class="row"><!--4start -->
        <!--导航栏-------------------------------------->
        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">合作公司:</a>
                    <table class="table table-hover">
                        <tr>
                            <td>123</td>
                            <td>456</td>
                            <td>789</td>
                            <td>123</td>
                            <td>456</td>
                            <td>789</td>
                        </tr>
                        <tr>
                            <td>123</td>
                            <td>456</td>
                            <td>789</td>
                            <td>121</td>
                            <td>789</td>
                            <td>121</td>
                        </tr>
                        <tr>
                            <td>123</td>
                            <td>456</td>
                            <td>789</td>
                            <td>121</td>
                            <td>789</td>
                            <td>121</td>
                        </tr>

                    </table>
                </div>
            </div>
        </nav>
    </div>	<!--4导航条结束-------------------------------------->
    <div class="row">
    </div>
</div><!--0-end-->
</body>
</html>
