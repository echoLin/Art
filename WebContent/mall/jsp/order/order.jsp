<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>订单管理</title>
<link href=" /Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/order.css" rel="stylesheet" type="text/css"/>
<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>

<script type="text/javascript" src="http://meet.xpro.im/v2/api/xmeet.api.js?nickname=用户想使用的昵称&amp;xnest=yourNameSpace&amp;xnest_name=显示在窗口的标题"></script>

    <script>
        $(window).load(function() {
            $("#status").fadeOut();
            $("#preloader").delay(350).fadeOut("slow");
        });

        
    </script>
</head>

<body>

<div class="mobile">

  <!--页面加载 开始-->
  <div id="preloader">
    <div id="status">
      <p class="center-text"><span>拼命加载中···</span></p>
    </div>
  </div>
  <!--页面加载 结束-->

  <!--header 开始-->
  <header>
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>订单管理</h2>
      <div class="header_right shaixuan"><a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png"></a></div>
    </div>
  </header>
  <!--header 结束-->



    <div class="user_nav_list w">
    	<ul>

            <li>
            	<a href="/Art/mall/jsp/order/orderlist?type=1&status=1&page=1">
                	<div class="u_nav_icon fukuan"></div>
                    <div class="u_nav_name">待付款订单</div>
                    <div class="nt_icon"></div>
              </a>
            </li>

            <li>
            	<a href="/Art/mall/jsp/order/orderlist?type=1&status=2&page=1">
                	<div class="u_nav_icon fahuo"></div>
                    <div class="u_nav_name">待发货订单</div>
                    <div class="nt_icon"></div>
              </a>
            </li>

            <li>
            	<a href="/Art/mall/jsp/order/orderlist?type=1&status=3&page=1">
                	<div class="u_nav_icon qiandao"></div>
                    <div class="u_nav_name">待收货订单</div>
                    <div class="nt_icon"></div>
              </a>
            </li>

            <li>
            	<a href="/Art/mall/jsp/order/orderlist?type=1&&status=4&page=1">
                	<div class="u_nav_icon pingjia"></div>
                    <div class="u_nav_name">待评价订单</div>
                    <div class="nt_icon"></div>
              </a>
            </li>

            <li>
                <a href="/Art/mall/jsp/order/orderlist?type=1&&status=5&page=1">
                    <div class="u_nav_icon pingjia"></div>
                    <div class="u_nav_name">已评价订单</div>
                    <div class="nt_icon"></div>
                </a>
            </li>

        </ul>


        </div>


</div>

</body>
</html>