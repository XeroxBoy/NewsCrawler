<%--
  Created by IntelliJ IDEA.
  User: AlexAnderIch
  Date: 2017/10/15
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link rel="stylesheet" type="text/css" href="../css/style01.css">
<link rel="stylesheet" type="text/css" href="../css/foot.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        var _this1=null;
        $('.nav>li').hover(function(){
            _this1=$(this);
            _this1.find('.second-nav').show();
            var _this2=null;
            _this1.find('.second-nav').find('li').hover(function(){
                _this2=$(this);
                _this2.find('.third-nav').show();
                _this2.find('.third-nav').hover(function(){
                    $(this).show();
                },function(){
                    $(this).hide();
                });
            },function(){
                _this2.find('.third-nav').hide();
            });
        },function(){
            _this1.find('.second-nav').hide();
        });
    });
</script>

</head>
<body>

<div class="header">
    <ul class="nav">
        <li><a href="News.jsp">首页</a>

        </li>
        <li><a href="/userInfo">我的信息</a>

        </li>

    </ul>
</div>
<%--嵌套两层循环输出新闻数据--%>
    <c:set var="index" value="${newsPage.getCurrPage()}" />
    <c:forEach var="x" begin="0" end="9" step="1">
        <a href=<c:out value="${newsPage.getList().get(index).getResource()}"></c:out>>
            <c:out value="${newsPage.getList().get(index).getTitle()}"></c:out>
        </a>
        <c:out value="          ${newsPage.getList().get(index).getWriter()}"></c:out>
        <br>
        <c:out value="${newsPage.getList().get(index).getSummary()}"></c:out>

        <c:out value="${newsPage.getList().get(index).getTime()}"></c:out>
    </c:forEach>
<div class="yahoo">
	<c:set var="pageIndex" value="1" />
	<c:forEach var="x" begin="1" end="${newsPage.getPageSize()}" step="1">
	<c:out value="<a href='news/selectNews.do?pageNo=${pageIndex}'>${pageIndex}</a>"></c:out>
	<c:set var="pageIndex" value="${pageIndex+1}" />
	</c:forEach>

</div>
</body>
</html>
