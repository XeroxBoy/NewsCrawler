
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link rel="stylesheet" type="text/css" href="../css/style01.css">
<link rel="stylesheet" type="text/css" href="../css/foot.css">
<link rel="stylesheet" href="../css/normalize.css">

<link rel="stylesheet" href="../css/style.css" media="screen" type="text/css" />

<script type="text/javascript" src="../js/jquery.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>登录</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
</head>
<body>
<section class="login-form-wrap">
    <h1>计蒜新闻</h1>
    <p>${msg}</p>
    <form class="login-form" method="POST"  action="/user/update">
        <label>
            <input type="email" name="email" required placeholder="your Email" minlength="5" maxlength="20">
        </label>
        <label>
            <input type="text" name="username" required placeholder="your Username" minlength="4">
        </label>
        <label>
            <input type="password" name="password" required placeholder="your Password" minlength="6" maxlength="14">
        </label>
        <input type="submit" value="更新">
    </form>
    <h5><a href="zhuce.jsp">还没有注册？</a><p></p><a href="login.jsp">已有账号？</a></h5>

</section>

</body>

</html>
