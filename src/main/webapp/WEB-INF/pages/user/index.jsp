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
                <div class="item active">
                    <img src="${pageContext.request.contextPath}/img/16008002.jpg" alt="...">
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/img/166663.jpg" alt="...">

                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/img/16008004.jpg" alt="...">

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
            <div class="col-md-6">
                <img src="${pageContext.request.contextPath}/img/160000.jpg" style="width:80%;"/>
            </div>
            <div class="col-md-6" style="margin-top:212px;">
                <div class="col-md-6">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/img/1700000.jpg" style="width: 67%;" class="img-responsive"/>
                        <p>大豆肽<br/><span>大豆肽,小分子肽，大豆蛋白肽粉</span><br/><span>零售价：&yen;399.00 &nbsp;会员价：<font color="red">55.00</font></span></p>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="thumbnail">
                        <img src="${pageContext.request.contextPath}/img/19400.jpg" style="width: 60%;" class="img-responsive"/>
                        <p>大豆肽<br/><span>大豆肽,小分子肽，大豆蛋白肽粉</span><br/><span>零售价：&yen;399.00 &nbsp;会员价：<font color="red">55.00</font></span></p>
                    </div>
                </div>

            </div>
        </div>


        <!--导航条结束-------------------------------------->
    </div><!-- 3end -->

    <div class="row container"><!--0-4start-->
        <span style="font-size:25px;">热门商品</span><img src="${pageContext.request.contextPath}/img/title2.jpg""/>
    </div><!--0-4end-->

    <div class="row">
        <div class="col-md-3">
            <div class="thumbnail">
                <img src="${pageContext.request.contextPath}/img/19800.jpg" style="width: 53%;" class="img-responsive"/>
                <p>大麦若叶青汁代餐粉，盒装，3克/条<br/>零售价：120.00，会员价：<font color="red">&yen;19.00</font></p>
            </div>
        </div>
        <div class="col-md-3">
            <div class="thumbnail">
                <img src="${pageContext.request.contextPath}/img/19500.jpg" style="width: 50%;" class="img-responsive"/>
                <p>道阿夫帝王至尊800ML洗发膏洗发水沐浴露<br/>零售价：118.00，会员价：<font color="red">&yen;15.000</font></p>
            </div>
        </div>
        <div class="col-md-3">
            <div class="thumbnail">
                <img src="${pageContext.request.contextPath}/img/19600.jpg" style="width: 58%;" class="img-responsive"/>
                <p>量子活力舒丝巾<br/>零售价：860.00，会员价：<font color="red">&yen;15.00</font></p>
            </div>
        </div>
        <div class="col-md-3">
            <div class="thumbnail">
                <img src="${pageContext.request.contextPath}/img/19700.jpg" style="width: 65%;" class="img-responsive"/>
                <p>舒克舒敏亮白牙膏/120g<br/>零售价：25.00，会员价：<font color="red">&yen;7.00</font></p>
            </div>
        </div>

    </div>
    <%--底部--%>
    <div>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header" style="margin-left: 44%;">
                    <a class="navbar-brand " href="#" style="font-size: 12px;margin-left: -77px">版权所有：博爱县汇满鑫电子科技有限公司</a>
                </div>
            </div>
        </nav>
    </div>
</div><!--0-end-->
</body>
</html>
