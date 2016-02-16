<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="We Plus" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>我的收藏夹</title>
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/artMall.css" rel="stylesheet" type="text/css" />
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> -->
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script src="/Art/mall/js/favorite.js"></script>
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
  <!-- header 开始 -->
    <div class="header" id="header">
		<a class="new-a-back" href="javascript:history.back();">
			<span><img src="../images/iconfont-fanhui.png"></span>
		</a>
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">收藏夹</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>

  <div class="baoliao w">
  	<div class="ui-tab">
  		<div id="ulbox">
       </div>
      
      <div id = 'content'>
      	<!-- load content -->
      </div>
  </div>
 	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>
</body>
</html>