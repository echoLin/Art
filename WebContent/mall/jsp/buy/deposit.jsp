<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="We Plus" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>支付押金</title>
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/artMall.css" rel="stylesheet" type="text/css" />
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script>
function deposit(lot_id){
	$.ajax({
		url:'/Art/deposit.json',
		type:'POST',
		data:{lot_id:lot_id},
		success:function(data){
			if(data.errno == 2){
				window.location.href = data.data;
			}else if(data.errno == 1){
				alert(data.data);
			}else{
				window.location.href='/Art/mall/jsp/artMall/lotInfo?id='+lot_id;
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
  <!-- header 开始 -->
    <div class="header" id="header">
		<a class="new-a-back" href="javascript:history.back();">
			<span><img src="../images/iconfont-fanhui.png"></span>
		</a>
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">支付押金</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
  <div class="baoliao w">
  	<div class="ui-tab">
      <div id = 'content'>
      	
      	<c:if test="${not empty lot }">
      	 <div class="m_baoliao w">
	  		<div class="baoliao_title"><span>支付押金</span><em></em></div>
	  		<input class='form-control' id='lot_id' name='lot_id' value="${lot.id }" type='hidden'/>
	      		<div class="ui-tab-content" id='itemList'>
			      	<a onClick='artworkInfo(${lot.artwork.id})'>
				      	<div class="baoliao_content">
						    <div class="bl_img"><img src="${lot.artwork.head_url }" /></div>
						    <div class="bl_right">
						        <div class="bl_title"><span class="bl_type" style="background-color:#53bf1e;">${ lot.artwork.category.name}</span>${ lot.artwork.name}</div>
						        <div class="bl_tag">
						            <div class="bl_price">押金：</div>
						            <c:set var="price" value="￥${lot.price }"/>
						            <div class="bl_price">${ price}</div>
						            <c:set var="createYear" value="创作年份：${lot.artwork.create_year }"/>
						            <div class="bl_time">${ createYear}</div>
						            <c:set var="artist" value="艺术家：${lot.artwork.shop.artist.real_name }"/>
						            <div class="bl_mall">${ artist }</div>
						        </div>
						    </div>
						</div>
			      	</a>
	      		</div>
	      	</div>
   <div class="go_buy"><a onClick='deposit(${lot.id})' style="width:100%; border-radius:10px;">确认支付</a></div>
   </c:if>
  
 	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
	</div>
	</div>
	</div>
</div>
</body>
</html>