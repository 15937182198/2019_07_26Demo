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
    <title>今日用户注册</title>
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
            <!-- 操作日志 -->
            <div class="layui-form news_list">
                <table class="layui-table">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>联系方式</th>
                        <th>节点积分</th>
                        <th>可用积分</th>
                        <th>冻结积分</th>
                        <th>创建时间</th>
                        <th>推荐人</th>
                        <th>收货地址</th>
                        <th>上级</th>
                        <th>下级</th>
                        <th>是否满足十层</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody class="news_content">
                    <%--  --%>
                    <c:forEach items="${pageInfo.list}" var="account" varStatus="id">
                        <tr>
                            <td align="left">${account.accountName}</td>
                            <td>${account.userName}</td>
                            <td>${account.userPhone}</td>
                            <td>${account.accountMoney}</td>
                            <td>${account.usableMoney}</td>
                            <td>${account.freezeMoney}</td>
                            <td>${account.accountCreateDate}</td>
                            <td>${account.referrer}</td>
                            <td>${account.site}</td>
                            <td>${account.accountLead}</td>
                            <td>${account.junior1}|${account.junior2}</td>
                            <c:if test="${account.boo==true}">
                                <td>是</td>
                            </c:if>
                            <c:if test="${account.boo!=true}">
                                <td>否</td>
                            </c:if>
                            <td>
                                <a href="${pageContext.request.contextPath}/loginController/userInforUpdate?accountId=${account.accountId}" class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 修改信息</a>
                                <a href="${pageContext.request.contextPath}/loginController/updateMoney?accountId=${account.accountId}" class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 修改密码</a>
                                <a href="${pageContext.request.contextPath}/loginController/record?accountId=${account.accountId}" class="layui-btn layui-btn-mini news_edit"><i class="iconfont icon-edit"></i> 交易记录</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="larry-table-page clearfix">
                    <div style="margin-top: 50px"><span>共${pageInfo.accountNum}个用户</span><span>当前是第${pageInfo.pageNum}页</span></div>
                    <div class="box-footer">
                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li><a href="javascript:pageBeanNumber(1)" aria-label="Previous">首页</a></li>
                                <li><a href="javascript:pageBeanNumber(${pageInfo.pageNum-1})">上一页</a></li>
                                <c:choose>
                                    <c:when test="${pageInfo.pages<=5}">
                                        <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                                            <li><a href="javascript:pageBeanNumber(${i})">${i}</a></li>
                                        </c:forEach>
                                    </c:when>

                                    <c:otherwise>
                                        <c:if test="${pageInfo.pageNum+4<pageInfo.pages}">
                                            <c:set var="start" value="${pageInfo.pageNum}"/>
                                            <c:set var="end" value="${pageInfo.pageNum+4}"/>
                                        </c:if>
                                        <c:if test="${pageInfo.pageNum+4>=pageInfo.pages}">
                                            <c:set var="start" value="${pageInfo.pages-4}"/>
                                            <c:set var="end" value="${pageInfo.pages}"/>
                                        </c:if>
                                        <c:forEach begin="${start}" end="${end}" var="i">
                                            <li><a href="javascript:pageBeanNumber(${i})">${i}</a></li>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
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
<script>
    $(function () {
        $("#button1").click(function () {
            var val = $("#accountName").val();
            window.location.href="${pageContext.request.contextPath}/account/findAccountByAccountName?accountName="+val;
        });
    });
</script>
</body>
</html>
