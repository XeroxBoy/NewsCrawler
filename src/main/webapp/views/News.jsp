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
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="../js/jquery.min.js"></script>

<script type="text/javascript">
    $(function () {
        var _this1 = null;
        $('.nav>li').hover(function () {
            _this1 = $(this);
            _this1.find('.second-nav').show();
            var _this2 = null;
            _this1.find('.second-nav').find('li').hover(function () {
                _this2 = $(this);
                _this2.find('.third-nav').show();
                _this2.find('.third-nav').hover(function () {
                    $(this).show();
                }, function () {
                    $(this).hide();
                });
            }, function () {
                _this2.find('.third-nav').hide();
            });
        }, function () {
            _this1.find('.second-nav').hide();
        });
    });
</script>
<style >
    .bar5 {background: #683B4D;}
    .bar5 input, .bar5 button { background: transparent; }
    .bar5 input { border: 2px solid #F9F0DA; }
    .bar5 button { position:relative;top:0px; left:100px; }
    .bar5 button:before { content: "\f002"; font-family: FontAwesome; font-size: 12px; color: #F9F0DA; }
    .bar5 input:focus { border-color: #311c24 }

</style>
</head>
<body style="background-color:white">

<div class="header">
    <ul class="nav">
        <li><a href="selectNews?pageNo=0&name=${sessionScope.name}"><span style="font-size: large">首页</span></a>

        </li>
        <li><a href="../user/userInfo"><span style="font-size: large">我的信息</span></a>

        </li>
        <li><a href="../views/login.jsp"><span style="font-size: large">登出</span></a></li>

            <div> <form action="search" method="post">
                <li><input type="text" name="key" style="position:relative;top:-10px;height: 35px;width: 180px;" placeholder="请输入您要搜索的内容..."></li>
                <li><button type="submit" class="btn btn-default" style="position:relative;top:-20px;left:10px;height: 35px;width: 75px;vertical-align: text-top">搜索</button> </li></form>
            </div>

        </li>

    </ul>
</div>
<%--嵌套两层循环输出新闻数据--%>
<c:set var="index" value="0"/>
<c:set var="totalPage" value="${sessionScope.totalPage-1}"></c:set>
<c:set var="ender" value="9"></c:set>
<c:if test="${sessionScope.currPage eq totalPage}">
    <c:set var="ender" value="${sessionScope.lastNewsNum-1}"></c:set>
</c:if>

<c:forEach var="x" begin="0" end="${ender}" step="1">
    <a target="_blank" href=<c:out value="${newsPage.getList().get(index).getResource()}"></c:out>>
       <h3><c:out value="${newsPage.getList().get(index).getTitle()}"></c:out>
           <small>
               <c:out value="          ${newsPage.getList().get(index).getWriter()}"></c:out>
           </small>
       </h3>
    </a>


    <span style="font-size: medium" class="lead"><c:out value="${newsPage.getList().get(index).getSummary()}"></c:out></span>
    <br>
   <span style="background-color: #cecece"> <c:out value="${newsPage.getList().get(index).getTime()}"></c:out></span>
    <br>
    <c:set var="index" value="${index+1}"></c:set>
</c:forEach>
<div class="yahoo">

        <c:forEach var="a" begin="1" end="${sessionScope.totalPage}" step="1">
            <a href="http://localhost:8080/news/selectNews.do?pageNo=${a-1}&name=${sessionScope.name}&password=${sessionScope.password}">
            <span style="font-size:medium">${a}</span></a>
        </c:forEach>

</div>
</body>
</html>
