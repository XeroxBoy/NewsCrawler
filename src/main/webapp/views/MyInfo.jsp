
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link rel="stylesheet" type="text/css" href="../css/style01.css">
<link rel="stylesheet" type="text/css" href="../css/foot.css">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

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
<body style="background-color: #5670a4">

<div class="header">
    <ul class="nav">
        <li><a href="selectNews?pageNo=0&name=${sessionScope.name}&password=${sessionScope.password}"><span style="font-size: large">首页</span></a>

        </li>
        <li><a href="../user/userInfo"><span style="font-size: large">我的信息</span></a>

        </li>


    </ul>
</div>

<span style="font-size: medium">${user.email}</span><br>
<span style="font-size: medium">${user.password}</span><br>
<span style="font-size: medium">${user.username}</span><br>
<a href="../user/update" style="font-size: medium">修改个人信息？</a>
</body>
</html>
