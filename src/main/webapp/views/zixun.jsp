<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>

    <!--360 browser -->
    <meta name="renderer" content="webkit">
    <meta name="author" content="wos">
    <!-- Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/i/app.png">
    <!--Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="images/i/app.png">
    <!--Win8 or 10 -->
    <meta name="msapplication-TileImage" content="images/i/app.png">
    <meta name="msapplication-TileColor" content="#e1652f">

    <link rel="icon" type="image/png" href="images/i/favicon.png">
    <link rel="stylesheet" href="assets/css/amazeui.min.css">
    <link rel="stylesheet" href="css/public.css">

    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="assets/js/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lte IE 8 ]>
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="assets/js/amazeui.ie8polyfill.min.js"></script>
    <![endif]-->
    <script src="assets/js/amazeui.min.js"></script>
    <script src="js/public.js"></script>
</head>
<body>

<header class="am-topbar am-topbar-fixed-top wos-header">
    <div class="am-container">
        <h1 class="am-topbar-brand">
            <a href="#"><img src="images/logo.png" alt=""></a>
        </h1>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-warning am-show-sm-only"
                data-am-collapse="{target: '#collapse-head'}">
            <span class="am-sr-only">导航切换</span>
            <span class="am-icon-bars"></span>
        </button>

        <div class="am-collapse am-topbar-collapse" id="collapse-head">
            <ul class="am-nav am-nav-pills am-topbar-nav">
                <li><a href="index.html">首页</a></li>
                <li class="am-active"><a href="#">资讯</a></li>
                <li><a href="cases.jsp">专栏</a></li>

            </ul>

            <div class="am-topbar-right">
                <button class="am-btn am-btn-default am-topbar-btn am-btn-sm"><span class="am-icon-pencil"></span>注册</button>
            </div>

            <div class="am-topbar-right">
                <button class="am-btn am-btn-danger am-topbar-btn am-btn-sm"><span class="am-icon-user"></span> 登录</button>
            </div>
        </div>
    </div>
</header>
<!--banner-->



<div class="am-g am-container padding-none">
    <div class="am-u-sm-12 am-u-md-12 am-u-lg-8">
        <div data-am-widget="list_news" class="am-list-news am-list-news-default ">
            <div class="am-list-news-bd">
                <ul class="am-list">
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" style="border-top: 0px">
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>
                    <div class="newsico am-fr">
                        <i class="am-icon-clock-o">2016/11/11</i>
                        <i class="am-icon-hand-pointer-o">12322</i>
                    </div>



                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>

                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>

                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>

                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>

                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>

                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>

                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>
                    <li class="am-g am-list-item-desced am-list-item-thumbed am-list-item-thumb-left" >
                        <div class="am-u-sm-5 am-list-thumb">
                            <a href="http://www.douban.com/online/11624755/">
                                <img src="Temp-images/b2.jpg" alt="我最喜欢的一张画"/>
                            </a>
                        </div>

                        <div class=" am-u-sm-7 am-list-main">
                            <h3 class="am-list-item-hd"><a href="http://www.douban.com/online/11624755/">我最喜欢的一张画</a></h3>

                            <div class="am-list-item-text">你最喜欢的艺术作品，告诉大家它们的------名图画，色彩，交织，撞色，线条雕塑装置当代古代现代作品的照片美我最喜欢的画群296795413进群发画，少说多发图，</div>

                        </div>
                    </li>

                </ul>

                <ul data-am-widget="pagination" class="am-pagination am-pagination-default">

                    <li class="am-pagination-first">
                        <a href="#" class="am-hide-sm">第一页</a>
                    </li>

                    <li class="am-pagination-prev ">
                        <a href="#" class="">上一页</a>
                    </li>


                    <li>
                        <a href="#" class="am-active">1</a>
                    </li>
                    <li >
                        <a href="#" class="am-hide-sm">2</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">3</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">4</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">5</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">6</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">7</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">8</a>
                    </li>
                    <li>
                        <a href="#"  class="am-hide-sm">9</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">10</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">11</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">12</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">13</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">14</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">15</a>
                    </li>
                    <li>
                        <a href="#" class="am-hide-sm">16</a>
                    </li>
                    <li class="am-pagination-next ">
                        <a href="#" class="">下一页</a>
                    </li>
                    <li class="am-pagination-last ">
                        <a href="#" class="am-hide-sm">最末页</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="am-u-sm-0 am-u-md-0 am-u-lg-4 am-hide-sm">
        <div class="tag bgtag">
            <div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" >
                <h2 class="am-titlebar-title ">
                    热门标签
                </h2>
            </div>
            <ul>
                <li class="active"><a href="#">的房间打开</a></li>
                <li><a href="#">阿斯达</a></li>
                <li><a href="#">恩恩</a></li>
                <li><a href="#">十二分</a></li>
                <li><a href="#">爱妃</a></li>
                <li><a href="#">而非</a></li>
                <li><a href="#">为非</a></li>
                <li><a href="#">二位</a></li>
                <li><a href="#">维吾尔</a></li>
                <li><a href="#">玩儿玩儿</a></li>
            </ul>
            <div class="am-cf"></div>
        </div>
    </div>
</div>


<div data-am-widget="gotop" class="am-gotop am-gotop-fixed" >
    <a href="#top" title="回到顶部">
        <span class="am-gotop-title">回到顶部</span>
        <i class="am-gotop-icon am-icon-chevron-up"></i>
    </a>
</div>

<footer>
    <div class="content">
        <ul class="am-avg-sm-5 am-avg-md-5 am-avg-lg-5 am-thumbnails">
            <li><a href="#">联系我们</a></li>
            <li><a href="#">加入我们</a></li>
            <li><a href="#">合作伙伴</a></li>
            <li><a href="#">广告及服务</a></li>
            <li><a href="#">友情链接</a></li>
        </ul>

    </div>
</footer>
</body>
</html>