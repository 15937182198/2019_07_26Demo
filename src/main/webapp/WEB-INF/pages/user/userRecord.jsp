<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>交易记录</title>
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
<div class="container" style="background-color: #e7eaed;margin-top: 20px; padding-top: 15px;height: 500px">
    <p class="text-left"><h2><span class="glyphicon glyphicon-user" aria-hidden="true"> </span> 交易记录</h2></p>

    <div class="form-horizontal">
        <table class="table table-bordered">
          <tr>
              <th>交易编号</th>
              <th>收入/支出</th>
              <th>交易时间</th>
              <th>所属账户</th>
          </tr>
          <tr>
              <td align="left">110</td>
              <td>111?</td>
              <td>2019.08.12</td>
              <td>小明</td>
          </tr>
        </table>
        <div class="larry-table-page clearfix">
            <div style="margin-top: 50px"><span>共${pageInfo.accountNum}个用户</span><span>当前是第${pageInfo.pageNum}页</span></div>
            <div class="box-footer">
                <div class="box-tools pull-right">
                    <ul class="pagination">
                        <li><a href="javascript:pageBeanNumber(1)" aria-label="Previous">首页</a></li>
                        <li><a href="javascript:pageBeanNumber(${pageInfo.pageNum-1})">上一页</a></li>
                        <li><a href="javascript:pageBeanNumber(${i})">1</a></li>
                        <li><a href="javascript:pageBeanNumber(${i})">2</a></li>
                        <li><a href="javascript:pageBeanNumber(${i})">3</a></li>

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
</body>
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
</html>
