<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>计算新闻</title>

    <link rel="stylesheet" href="../css/normalize.css">

    <link rel="stylesheet" href="../css/style.css" media="screen" type="text/css" />
    <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>

</head>

<body>
<section class="login-form-wrap">
    <h1>计蒜新闻</h1>
    <p>${msg}</p>
    <form class="login-form" method="POST"  action="/user/zhuce">
        <label>
            <input type="email" name="email" required placeholder="Email">
        </label>
        <label>
            <input type="text" name="username" required placeholder="your username" minlength="4">
        </label>

        <label>
            <input type="password" name="password" required placeholder="Password" minlength="6" max="14">
        </label>
        <input type="submit" value="注册">
        <h5><a href="login.jsp">已有账号？</a></h5>

    </form>
</section>

</body>
</html>

</body>

</html>