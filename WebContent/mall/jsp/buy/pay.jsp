<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="We Plus" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>支付</title>
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/artMall.css" rel="stylesheet" type="text/css" />
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script>
function pay(){
	var payment_id = $('#payment_id').val();
	if(payment_id == 0 || payment_id == null){
		window.location.href = '/Art/mall/index';
	}
	$.ajax({
		url:'/Art/pay.json',
		type:'POST',
		data:{
			payment_id:payment_id
		},
		success:function(data){
			if(data.errno == 0){
				window.location.href="/Art/mall/jsp/buy/paySuccess";
			}else if(data.errno == 2){
				window.location.href=data.data;
			}else{
				alert(data.data);
				window.location.href = '/Art/mall/index';
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
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">支付订单</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
  <div class="baoliao w">
  	<div class="ui-tab">
      <div id = 'content'>
      	
      	<c:if test="${not empty payment }">
      	 <div class="m_baoliao w">
	  		<div class="baoliao_title"><span>支付信息</span><em></em></div>
	  		<input class='form-control' id='payment_id' name='payment_id' value="${payment.id }" type='hidden'/>
	      		<div class="ui-tab-content" id='itemList'>
			      	<a onClick='artworkInfo(${payment.order.artwork.id})'>
				      	<div class="baoliao_content">
						    <div class="bl_img"><img src="${payment.order.artwork.head_url }" /></div>
						    <div class="bl_right">
						        <div class="bl_title"><span class="bl_type" style="background-color:#53bf1e;">${ payment.order.artwork.category.name}</span>${ artwork.name}</div>
						        <div class="bl_tag">
						            <div class="bl_price">价格：</div>
						            <c:set var="price" value="￥${payment.price }"/>
						            <div class="bl_price">${ price}</div>
						            <c:set var="createYear" value="创作年份：${payment.order.artwork.create_year }"/>
						            <div class="bl_time">${ createYear}</div>
						            <c:set var="artist" value="艺术家：${payment.order.artwork.shop.artist.real_name }"/>
						            <div class="bl_mall">${ artist }</div>
						        </div>
						    </div>
						</div>
			      	</a>
	      		</div>
	      	</div>
      	</c:if>
   <div class="go_buy"><a onClick='pay()' style="width:100%; border-radius:10px;">确认支付</a></div>
  
 	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>
</body>
</html>