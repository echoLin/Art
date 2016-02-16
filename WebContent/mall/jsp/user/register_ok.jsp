<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <h2>注册成功</h2>
      </div>
  </header>
  <!--header 结束-->
  
  <div class="w main">
  	<div class="register_verify">
    	<div class="ok_iocn"><img src="/Art/mall/images/iconfont-iconxianluyudingchenggong.png" height="80"></div>
        <h1 style="margin-bottom:20px;">恭喜您！已成功注册艺术品网站！</h1>
        <a href="/Art/mall/login">立即登录</a><br><br>
        <a href="/Art/mall/index">返回首页</a>
    </div>
  </div>
</div>
</body>
</html>