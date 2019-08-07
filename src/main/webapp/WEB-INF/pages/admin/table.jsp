<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/27
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户信息</title>
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
</head>
<body>
<jsp:include page="index.jsp" flush="true"/>
<div class="layui-body" id="larry-body" style="bottom: 0;border-left: solid 2px #2299ee; margin-top: 50px;">
    <div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab" lay-filter="demo" lay-allowclose="true">
        <div class="layui-tab-content" style="min-height: 150px; ">
            <div class="layui-tab-item layui-show">

<section class="layui-larry-box">
    <div class="larry-personal">
        <div class="layui-tab">
            <blockquote class="layui-elem-quote news_search">
                <div class="layui-inline">
                    <div class="layui-input-inline">
                        <input value="" placeholder="请输入用户名" class="layui-input search_input" type="text">
                    </div>
                    <button class="layui-btn search_btn">查询</button>
                </div>
            </blockquote>

            <!-- 操作日志 -->
            <div class="layui-form news_list">
                <table class="layui-table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>积分余额</th>
                        <th>创建时间</th>
                        <th>推荐人</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody class="news_content">
                    <%--  --%>
                    <c:forEach items="${pageInfo.list}" var="account" varStatus="id">
                        <tr>
                            <td>${(pageInfo.pageNum-1)*5+id.count}</td>
                            <td align="left">${account.accountName}</td>
                            <td>${account.accountMoney}</td>
                            <td>${account.accountCreateDate}</td>
                            <td>${account.referrer}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/loginController/userInforUpdate?accountId=${account.accountId}" class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="larry-table-page clearfix">
                    <div class="box-footer">

                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li><a href="javascript:pageBeanNumber(1)" aria-label="Previous">首页</a></li>
                                <li><a href="javascript:pageBeanNumber(${pageInfo.pageNum-1})">上一页</a></li>
                                <li><a href="javascript:pageBeanNumber(${i})">${i}</a></li>
                                    <c:forEach begin="1" end="${pageInfo.pageNum+4}" var="i">
                                        <c:if test="${pageInfo.pageNum-2}<0">
                                            <li><a href="javascript:pageBeanNumber(${i})">${i}</a></li>
                                        </c:if>
                                        <c:if test="${pageInfo.pageNum-2>0?pageInfo.pageNum:1<i<=5}">
                                            <li><a href="javascript:pageBeanNumber(${i})">${i}</a></li>
                                        </c:if>
                                    </c:forEach>
                                <li><a href="javascript:pageBeanNumber(${pageInfo.pageNum+1})">下一页</a></li>
                                <li><a href="javascript:pageBeanNumber(${pageInfo.pages})" aria-label="Next">尾页</a></li>
                            </ul>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>

</section>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/newslist.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/common/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/larry.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="../../../js/jquery-3.2.1.min.js"></script>
<script>
    <%--分页函数--%>
    function pageBeanNumber(nowPage) {
        //获取页面数据大小

        if(nowPage<1){
            return;
        }

        if(nowPage>${pageInfo.pages}){
            return;
        }
        location.href="${pageContext.request.contextPath}/account/pageInfo?currPage="+nowPage;
    }
</script>
</body>
</html>
