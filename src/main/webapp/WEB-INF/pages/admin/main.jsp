<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/27
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/bootstrap/css/bootstrap.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/common/global.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personal.css" media="all">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminstyle.css" media="all">

</head>
<body>
<jsp:include page="index.jsp" flush="true"/>

<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee; margin-top: 50px;">
    <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
        <div class="layui-tab-content" style="min-height: 150px; ">
            <div class="layui-tab-item layui-show">
                <section class="larry-wrapper">
                    <!-- overview 用户-->
                    <div class="row state-overview">
                        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
                            <section class="panel">
                                <div class="symbol userblue layui-anim layui-anim-rotate"> <i class="iconpx-users"></i>
                                </div>
                                <div class="value">
                                    <a href="#">
                                        <p id="count1"></p>
                                    </a>
                                    <p>用户总数</p>
                                </div>
                            </section>
                        </div>
                        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
                            <section class="panel">
                                <div class="symbol commred layui-anim layui-anim-rotate"> <i class="iconpx-user-add"></i>
                                </div>
                                <div class="value">
                                    <a href="#">
                                        <h1 id="count2"></h1>
                                    </a>
                                    <p>今日注册用户</p>
                                </div>
                            </section>
                        </div>
                        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
                            <section class="panel">
                                <div class="symbol articlegreen layui-anim layui-anim-rotate">
                                    <i class="iconpx-file-word-o"></i>
                                </div>
                                <div class="value">
                                    <a href="#">
                                        <h1 id="count3"></h1>
                                    </a>
                                    <p>推荐人数超过6的用户数</p>
                                </div>
                            </section>
                        </div>
                        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
                            <section class="panel">
                                <div class="symbol rsswet layui-anim layui-anim-rotate">
                                    <i class="iconpx-check-circle"></i>
                                </div>
                                <div class="value">
                                    <a href="#">
                                        <h1 id="count4"></h1>
                                    </a>
                                    <p>普通用户今日收益</p>
                                </div>
                            </section>
                        </div>
                    </div>
                    <%--店铺--%>
                    <div class="row state-overview">
                        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
                            <section class="panel">
                                <div class="symbol userblue layui-anim layui-anim-rotate"> <i class="iconpx-users"></i>
                                </div>
                                <div class="value">
                                    <a href="#">
                                        <p id="count5"></p>
                                    </a>
                                    <p>店铺总数</p>
                                </div>
                            </section>
                        </div>
                        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
                            <section class="panel">
                                <div class="symbol commred layui-anim layui-anim-rotate"> <i class="iconpx-user-add"></i>
                                </div>
                                <div class="value">
                                    <a href="#">
                                        <h1 id="count6"></h1>
                                    </a>
                                    <p>今日注册店铺</p>
                                </div>
                            </section>
                        </div>
                        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
                            <section class="panel">
                                <div class="symbol articlegreen layui-anim layui-anim-rotate">
                                    <i class="iconpx-file-word-o"></i>
                                </div>
                                <div class="value">
                                    <a href="#">
                                        <h1 id="count7"></h1>
                                    </a>
                                    <p>推荐人数超过6的用户数</p>
                                </div>
                            </section>
                        </div>
                        <div class="col-lg-3 col-sm-6 layui-anim layui-anim-up">
                            <section class="panel">
                                <div class="symbol rsswet layui-anim layui-anim-rotate">
                                    <i class="iconpx-check-circle"></i>
                                </div>
                                <div class="value">
                                    <a href="#">
                                        <h1 id="count8"></h1>
                                    </a>
                                    <p>店铺今日收益</p>
                                </div>
                            </section>
                        </div>
                    </div>
                    <!-- overview end -->
                    <div class="row" style="margin-top: 20px">
                        <div class="col-md-1"></div>
                        <div class="col-md-8">
                            <section class="panel">
                                <header class="panel-heading bm0">
                                    <span class='span-title'>系统概览</span>
                                    <span class="tools pull-right"><a href="javascript:;" class="iconpx-chevron-down"></a></span>
                                </header>
                                <div class="panel-body" >
                                    <table class="table table-hover personal-task">
                                        <tbody>
                                        <tr>
                                            <td>
                                                <strong>后台管理</strong>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>当前登录用户</strong>： <span class="current_user">${pageContext.session.getAttribute("username")}</span>

                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>网站域名</strong>： <span class="current_user">未定义</span>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>服务器IP</strong>： <span class="current_user">未定义</span>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>端口号</strong>：<span class="current_user">8080</span>
                                            </td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <strong>当前版本</strong>：<span class="current_user">1.0</span>
                                            </td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </section>
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    layui.use(['jquery','layer','element'],function(){
        window.jQuery = window.$ = layui.jquery;
        window.layer = layui.layer;
        window.element = layui.element();

        $('.panel .tools .iconpx-chevron-down').click(function(){
            var el = $(this).parents(".panel").children(".panel-body");
            if($(this).hasClass("iconpx-chevron-down")){
                $(this).removeClass("iconpx-chevron-down").addClass("iconpx-chevron-up");
                el.slideUp(200);
            }else{
                $(this).removeClass("iconpx-chevron-up").addClass("iconpx-chevron-down");
                el.slideDown(200);
            }
        })

    });
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jsplug/echarts.min.js"></script>
<script src="../../../js/jquery-3.2.1.min.js"></script>
<script>
    $(function () {
        var count1 = $("#count1");
        var count2=$("#count2");
        var count3=$("#count3");
        var count4 = $("#count4");
        var count5 = $("#count5");
        var count6 = $("#count6");
        var count7 = $("#count7");
        var count8 = $("#count8");
        $.ajax({
            url:"../account/findAccountNumber",
            "type"		:"post",
            "dataType"	:"JSON",
            "success"	:function (data) {
                count1.html(data);
            }
        });
        $.ajax({
            url:"../account/findAccountByDate",
            "type"		:"post",
            "dataType"	:"JSON",
            "success"	:function (data) {
                count2.html(data);
                count4.html(data*1000+"元");
            }
        });
        $.ajax({
            url:"../account/findAccountByReferrer",
            "type"		:"post",
            "dataType"	:"JSON",
            "success"	:function (data) {
                count3.html(data);
            }
        });

        $.ajax({
            url:"../account/findShopNumber",
            "type"		:"post",
            "dataType"	:"JSON",
            "success"	:function (data) {
                count5.html(data);
            }
        });
        $.ajax({
            url:"../account/findShopByDate",
            "type"		:"post",
            "dataType"	:"JSON",
            "success"	:function (data) {
                count6.html(data);
                count8.html(data*10000+"元");
            }
        });
        $.ajax({
            url:"../account/findShopByReferrer",
            "type"		:"post",
            "dataType"	:"JSON",
            "success"	:function (data) {
                count7.html(data);
            }
        });
    });
</script>
</body>
</html>
