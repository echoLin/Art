<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>艺术品详情</title>
<meta name="author" content="We Plus" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/frozenui/css/frozen.css" rel="stylesheet" type="text/css">
<link href="/Art/mall/css/artworkInfo.css" rel="stylesheet" type="text/css">
<link href="/Art/mall/css/owl.carousel.css" rel="stylesheet">
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/owl.carousel.min.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script src="/Art/mall/js/artMall/detail.js"></script>
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
      <h2>艺术品详情</h2>
      <div class="head_right" style="top:8px;">
			<c:if test="${artist==true }"><a href="/Art/mall/jsp/artist/shop/uploadArtwork?shop_id=${artwork.shop.id }&artwork_id=${artwork.id }" id="${artist }" style="font-size:16px">修改</a></c:if>
			<c:if test="${artist==false }"><a href="/Art/mall/index" id="${artist }"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a></c:if>
		</div>
    </div>
  </header>
  <!--header 结束-->
  <c:if test="${not empty artwork }">
  <div class="view w">
  	<div class="bl_view_img"><img src="${artwork.head_url }" /></div>
    <div class="bl_view_title">
    	<span class="bl_type">${artwork.category.name }</span>
    	<span class="bl_type" style="background-color:#53bf1e;">${artwork.shop.artist.real_name }</span>
    	<span class="bl_type" style="background-color:#00bb9c;">
    	<c:choose>
    	<c:when test="${artwork.type == 1 }">非卖品</c:when>
 		<c:when test="${artwork.type == 2 }">成品</c:when>
 		<c:when test="${artwork.type == 3 }">定制品</c:when>
 		<c:when test="${artwork.type == 4 }">拍卖品</c:when>
    	</c:choose>
    	</span>
    	${artwork.name }
    </div>
    <div class="bl_view_tag">
    	<c:set var="price" value="￥${artwork.price }"/>
   		<div class="bl_view_price">${price }</div>
        <!-- <div class="bl_view_oprice">￥138.00</div>  -->       
    </div>
    <div class="bl_view_tag">
    	<c:set var="artist" value="艺术家：${artwork.shop.artist.real_name }"/>
    	<div class="bl_view_user" onClick="artistInfo(${artwork.shop.artist.id })">${artist }</div>
        <!-- <div class="bl_view_time">人气：360次浏览</div> -->
    </div>
    <div class="bl_view_tag">
    	<c:set var="createYear" value="创作年份：${artwork.create_year }"/>	
    	<div class="bl_view_user">${createYear }</div>
    </div>
    <div class="go_buy">
    	<input class='form-control' id='id' name='id' value="${artwork.id }" type='hidden'/>
    	<c:choose>
    	<c:when test="${artwork.type == 2 }">
    		<a onClick='goBuy(${artwork.id})' style="width:50%; border-radius:10px;">我想要</a>
    	</c:when>
    	<c:otherwise>
    		<a onClick='connect(${artwork.shop.artist.user.userid})' style="width:50%; border-radius:10px;">联系艺术家</a>
    	</c:otherwise>
    	</c:choose>
    	<div id='favorite'>
    	<c:choose>
    	<c:when test="${artwork.favorite }">
    		<a onClick='unfavorite(3,${artwork.id})' style='background-color:#FF6063; width:50%; border-radius:10px;'>取消收藏</a>
    	</c:when>
    	<c:otherwise>
    		<a onClick='favorite(3,${artwork.id})' style='background-color:#FF6063; width:50%; border-radius:10px;'>加收藏</a>
    	</c:otherwise>
    	</c:choose>
    	</div>
    </div>
    <div id="detail" style="padding:10px;">${artwork.content }</div>
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