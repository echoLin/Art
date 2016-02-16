<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>艺术家介绍</title>
<meta name="author" content="We Plus" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/frozenui/css/frozen.css" rel="stylesheet" type="text/css">
<link href="/Art/mall/css/artworkInfo.css" rel="stylesheet" type="text/css">
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<link href="/Art/mall/css/index.css" rel="stylesheet" type="text/css" />
<script src="/Art/mall/js/public.js"></script>
<script src="/Art/mall/js/artMall/detail.js"></script>
<script src="/Art/mall/js/artistInfo.js"></script>
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
    <div class="header">
      <a class="new-a-back" href="javascript:history.back();">
			<span><img src="../images/iconfont-fanhui.png"></span>
	  </a>
      <h2>艺术家</h2>
      <div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
    </div>
  </header>
  <!--header 结束-->
  <c:if test="${not empty artist }">
  <div class="view w">
  	<div class="bl_view_img"><img src="${artist.user.avatar }" style="border-radius:10px;"/></div>
    <div class="bl_view_title">
    	<c:set var="favorite" value="人气:${artist.favoriteNum }+"/>
    	<span class="bl_type">${favorite }</span>
    	<span class="bl_type" style="background-color:#53bf1e;">${artist.user.username }</span>
    	<span class="bl_type" style="background-color:#00bb9c;">艺术家</span>
    	${artist.real_name }
    </div>
    <div class="bl_view_tag">
   		<c:set var="education" value="学历：${artist.education }"/>
   		<div class="bl_view_user">${education}</div>
    </div>
    <div class="bl_view_tag">
    	<c:set var="art_direction" value="创作方向：${artist.art_direction }"/>
    	<div class="bl_view_user">${art_direction }</div>
    </div>
    <div class="go_buy">
    	<input class='form-control' id='id' name='id' value="${artist.id }" type='hidden'/>
    	<a onClick='connect(${artist.user.userid})' style="width:50%;border-radius:10px;">联系Ta</a>
    	<div id='favorite'>
    	<c:choose>
    	<c:when test="${artist.favorite }">
    		<a onClick='unfavorite(1,${artist.id})' style='background-color:#FF6063; width:50%; border-radius:10px;'>取消收藏</a>
    	</c:when>
    	<c:otherwise>
    		<a onClick='favorite(1,${artist.id})' style='background-color:#FF6063; width:50%; border-radius:10px;'>加收藏</a>
    	</c:otherwise>
    	</c:choose>
    	</div>
    </div>
	<div class="baoliao w">
	  		<div class="ui-tab">
		  		<div id="ulbox">
		        </div>
	      	</div>
	      	<div id = 'content'>
	      		<!-- load content -->
	      	</div>
	  </div>
  </div>
  </c:if>
  
    <!-- gotop 开始 -->
	<div class="gotop backtop" style="display:none;"></div>
	<!-- gotop 结束 -->
	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>
</body>
</html>