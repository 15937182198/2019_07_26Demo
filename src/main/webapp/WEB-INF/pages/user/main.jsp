<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<div class="container"><!--0-start-->
    <div class="row margintop">   <!--1-start-->
        <!--导航栏-------------------------------------->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/Home/usershouye">首页</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">

                        <li><a href="#">产品详情</a></li>
                        <li><a href="#">合作公司</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="/logout" class="dropdown-toggle" role="button" aria-haspopup="true" aria-expanded="false">退出</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">个人中心<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/Home/userAdd">新增用户</a></li>
                                <li><a href="${pageContext.request.contextPath}/Home/shopAdd">新增店铺</a></li>
                                <li><a href="${pageContext.request.contextPath}/Home/UpdateUser">修改密码</a></li>
                                <li><a href="${pageContext.request.contextPath}/Home/recommender">我的推荐</a></li>
                                <li><a href="${pageContext.request.contextPath}/Home/userjiaoyi">积分交易</a></li>
                                <li><a href="${pageContext.request.contextPath}/Home/userRecord">交易记录</a></li>
                                <li><a href="javascript:alert('请联系管理员');">积分提现</a></li>
                                <li><a href="#">节点积分：${pageContext.session.getAttribute("account").accountMoney}</a></li>
                                <li><a href="#">可用积分：${pageContext.session.getAttribute("account").usableMoney}</a></li>
                                <li><a href="#">冻结积分：${pageContext.session.getAttribute("account").freezeMoney}</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>  <!-- /.navbar-collapse -->
            </div>  <!-- /.container-fluid -->
        </nav>
    </div>	<!--导航条结束-------------------------------------->
    <!--我的信息-->
</div><!--0-end-->

