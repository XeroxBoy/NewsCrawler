<%--
  Created by IntelliJ IDEA.
  User: AlexAnderIch
  Date: 2017/10/17
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="login-form" method="POST"  action="/login/update.do">
    <label>
        <input type="text" name="username" required placeholder="your Username">
    </label>
    <label>
        <input type="email" name="email" required placeholder="Confirm your password">
    </label>
    <label>
        <input type="password" name="password" required placeholder="your Password">
    </label>
    <input type="submit" value="修改">
</form>
</body>
</html>
