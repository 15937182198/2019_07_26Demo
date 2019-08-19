<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="main.jsp" flush="true"/>
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
                <div class="item active"><a href="${pictureTop.get(0).pictureRoute}">
                    <img src="${pictureTop.get(0).pictureRoute}" alt="..."></a>
                </div>
                <div class="item"><a href="${pictureTop.get(1).pictureRoute}">
                    <img src="${pictureTop.get(1).pictureRoute}" alt="..."></a>

                </div>
                <div class="item"><a href="${pictureTop.get(2).pictureRoute}">
                    <img src="${pictureTop.get(2).pictureRoute}" alt="..."></a>
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
    <script type="text/javascript">
        $('.carousel').carousel({
            interval: 2000
        })
    </script>

    <div class="row one"><!--3start -->
        <!--导航栏-------------------------------------->
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header" style="margin-left: 44%;">
                    <a name="top" class="navbar-brand " href="#" style="font-size: 28px;"><strong>畅销爆款</strong></a>
                </div>
            </div>
        </nav>
        <div class="row">
            <div class="col-md-6"><a href="${pictureTop.get(3).pictureRoute}">
                <img src="${pictureTop.get(3).pictureRoute}" style="width:80%;"/></a>
            </div>
            <div class="col-md-6" style="margin-top:118px;">
                <div class="col-md-6">
                    <div class="thumbnail"><a href="${pictureTop.get(4).pictureRoute}">
                        <img src="${pictureTop.get(4).pictureRoute}" style="width: 260px;height: 260px;" class="img-responsive"/></a>
                        <p>${pictureTop.get(4).pictureInfo}</p>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="thumbnail"> <a href="${pictureTop.get(5).pictureRoute}" >
                        <img src="${pictureTop.get(5).pictureRoute}" style="width: 260px;height: 260px;" class="img-responsive"/></a>
                        <p>${pictureTop.get(5).pictureInfo}</p>
                    </div>
                </div>

            </div>
        </div>


        <!--导航条结束-------------------------------------->
    </div><!-- 3end -->

    <div class="row container" style="margin-left: -30px;"><!--0-4start-->
        <span style="font-size:25px;">热门商品</span><img src="../../../img/title2.jpg" style="width: 210px;height: 13px;"/>
    </div><!--0-4end-->

    <div class="row">
        <c:forEach items="${pictures}" var="picture" varStatus="i">
        <div class="col-md-3">
            <div class="thumbnail">
                <a href="${picture.pictureRoute}">
                    <img src="${picture.pictureRoute}" style="width: 260px;height: 260px;" class="img-responsive"/></a>
                <p>${picture.pictureInfo}</p>
            </div>
        </div>
        </c:forEach>
    </div>
    <%--底部--%>
    <div>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header" style="margin-left: 44%;">
                    <a class="navbar-brand " href="#" style="font-size: 12px;margin-left: -77px"></a>
                </div>
            </div>
        </nav>
    </div>
</div><!--0-end-->
</body>
</html>
