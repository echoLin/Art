<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>注册成功</title>

<link href="/Art/mall/frozenui/css/frozen.css" rel="stylesheet" type="text/css">
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/login.css" rel="stylesheet" type="text/css">
<link href="/Art/mall/css/shop.css" rel="stylesheet" type="text/css" >
<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>

<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
})
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
      <h2>确认定制</h2>
      </div>
  </header>
  <!--header 结束-->
		<div>
			<div class="shop_top">
	            <div class="img">
	            <img src="${shop.head_url }">
	            </div>
	            <div class="shop_info">
	            <div class="shop_name">${shop.name }</div>
	            <div class="shop_name">简介：${shop.introduction }</div>
	            </div>
	        </div>
	   		
	   		<c:choose>
	   		<c:when test="${shop.is_customized == 1}">
	        <div class="toAddGoods">
	        <a href='/Art/mall/index' style="width:50%; border-radius:10px;">放弃定制</a>
			<a href='/Art/mall/jsp/buy/customizationPage?shop_id=${shop.id }' style="width:50%; border-radius:10px;">确认定制</a>
			</div>
			</c:when>
			<c:otherwise>
			<div class="toAddGoods">
				<a href='/Art/mall/index' style="width:50%; border-radius:10px;">该店不提供定制服务</a>
			</div>
			</c:otherwise>
			</c:choose>
		</div>
</div>
</body>
</html>