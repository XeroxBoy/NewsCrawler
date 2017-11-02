
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
        <li><a href="../news/selectNews?pageNo=0&name=${sessionScope.name }&password=${sessionScope.password }">首页</a>

        </li>
        <li><a href="user/userInfo">我的信息</a>

        </li>

    </ul>
</div>
<form class="login-form" method="POST"  action="/user/update">
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
