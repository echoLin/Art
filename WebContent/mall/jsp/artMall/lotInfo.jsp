<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>竞拍品详情</title>
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
<script>
function goBid(id,nowPrice, addPrice){
	var money = 0;
	money = nowPrice + addPrice;
	$.ajax({
		url:'/Art/bid.json',
		type:'POST',
		data:{
			lot_id:id,
			money:nowPrice + addPrice
		},
		success:function(data){
			if(data.errno == 2){
				window.location.href = data.data;
			}else if(data.errno == 1){
				alert(data.data);
			}else{
				window.location.reload();
			}
		}
	});
}
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
    <div class="header">
      <a class="new-a-back" href="javascript:history.back();">
			<span><img src="/Art/mall/images/iconfont-fanhui.png"></span>
	  </a>
      <h2>竞拍品详情</h2>
      <div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
    </div>
  </header>
  <!--header 结束-->
  <c:if test="${not empty lot }">
  <div class="view w">
  	<div class="bl_view_img"><img src="${lot.artwork.head_url }" /></div>
    <div class="bl_view_title">
    	<span class="bl_type">${lot.artwork.category.name }</span>
    	<span class="bl_type" style="background-color:#53bf1e;">${lot.artwork.shop.artist.real_name }</span>
    	<span class="bl_type" style="background-color:#00bb9c;">
    	<c:choose>
 		<c:when test="${lot.artwork.type == 4 }">拍卖品</c:when>
    	</c:choose>
    	</span>
    	${lot.artwork.name }
    </div>
    
    <c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set> 
    <c:choose>
	<c:when test="${nowDate-lot.start_time.time >= 0 && nowDate-lot.end_time.time <=0}"> 
		<div class="bl_view_tag">
    	<c:set var="price" value="当前最高价：￥${lot.now_price }"/>
   		<div class="bl_view_price">${price }</div>  
    	</div>
    	<c:if test="${not empty lot.user }">
    	<div class="bl_view_tag">
    	<c:set var="user" value="出价者：￥${lot.user.username }"/>
   		<div class="bl_view_price"  style="color:#53bf1e;">${user}</div>  
    	</div>
    	</c:if>
	</c:when>
	<c:otherwise>
		<div class="bl_view_tag">
	    	<c:set var="price" value="起拍价：￥${lot.price }"/>
	   		<div class="bl_view_price">${price }</div>      
	    </div>
	</c:otherwise>
	</c:choose>
    <div class="bl_view_tag">
    	<c:set var="add_price" value="加价：￥${lot.add_price }"/>
   		<div class="bl_view_price">${add_price }</div>      
    </div>
    <div class="bl_view_tag">
	    	<c:set var="start_time" value="开拍时间：${lot.startTime }"/>
	   		<div class="bl_view_user">${start_time }</div>      
	</div>
	<div class="bl_view_tag">
	    <c:set var="end_time" value="结束时间：${lot.endTime }"/>
	   	<div class="bl_view_user">${end_time }</div>      
	</div>
    <div class="bl_view_tag">
    	<c:set var="artist" value="艺术家：${lot.artwork.shop.artist.real_name }"/>
    	<div class="bl_view_user" onClick="artistInfo(${lot.artwork.shop.artist.id })">${artist }</div>
        <!-- <div class="bl_view_time">人气：360次浏览</div> -->
    </div>
    <div class="bl_view_tag">
    	<c:set var="createYear" value="创作年份：${lot.artwork.create_year }"/>	
    	<div class="bl_view_user">${createYear }</div>
    </div>
    <div class="go_buy">
    	<input class='form-control' id='id' name='id' value="${lot.id }" type='hidden'/>
    	<a onClick='goBid(${lot.id},${lot.now_price}, ${lot.add_price})' style="width:100%; border-radius:10px;">我要拍</a>
    </div>
    <div id="detail" style="padding:10px;">${lot.artwork.content }</div>
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