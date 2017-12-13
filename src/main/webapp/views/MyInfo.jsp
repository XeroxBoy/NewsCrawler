
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

<script type="text/javascript">
    window.onload = function () {
        var a = document.getElementsByTagName("img");
        for(var i = 0, len = a.length; i < len; i++){
            a[i].src= decodeURI(a[i].src).replace("%","-");
        }


    }

</script>
</head>
<body style="background-color: whitesmoke">

<div class="header">
    <ul class="nav">
        <li><a href="../news/selectNews?pageNo=0&name=${sessionScope.name}&password=${sessionScope.password}"><span style="font-size: large">首页</span></a>

        </li>
        <li><a href="../user/userInfo"><span style="font-size: large">我的信息</span></a>

        </li>
        <li><a href="../views/login.jsp"><span style="font-size: large">登出</span></a></li>

    </ul>
</div>


<form class="input-group" style="margin-left: 10px;margin-right: 10px"  action="/user/upload" method="post" role="form" enctype="multipart/form-data">
        <label>修改您的头像:</label><input type="file" name="file" /> <br><img src="../pic/${sessionScope.name}.jpg" onerror="javascript:this.src='../pic/moren.jpg';alt='pic'" /><br>
    <input value="上传" type="submit">
</form>
<div class="input-group" style="font-size: medium">
        <label>用户名: </label><input name="username" type="text" readonly="readonly"
                                   value='${sessionScope.name}'  /><br> <br>
        <label>邮箱:</label><input type="email" value='${sessionScope.email}' name="email" readonly="readonly"  >
    </div>
<a href="../views/update.jsp" style="font-size: medium">修改个人信息？</a>
</body>
</html>
