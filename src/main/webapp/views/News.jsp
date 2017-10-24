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
<head>
    <title>Title</title>
</head>
<body>
<%--嵌套两层循环输出新闻数据--%>
<c:forEach items="${newsPage}" var="item">
    <c:set var="index" value="0"/>
    <c:forEach var="x" begin="0" end="9" step="1">
        <a href="<c:out value="${item.getList().get(index).getResource()}"></c:out>">
            <c:out value="${item.getList().get(index).getTitle()}"></c:out>
        </a>
        <c:out value="          ${item.getList().get(index).getWriter()}"></c:out>
        <br>
        <c:out value="${item.getList().get(index).getSummary()}"></c:out>

        <c:out value="${item.getList().get(index).getTime()}"></c:out>
        <c:set var="index" value="${index+1}"/>
    </c:forEach>
</c:forEach>
</body>
</html>
