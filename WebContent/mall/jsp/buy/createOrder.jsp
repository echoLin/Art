<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="We Plus" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>确认订单</title>
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/artMall.css" rel="stylesheet" type="text/css" />
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script>
function createOrder(){
	var artwork_id = $('#artwork_id').val();
	var address_id = $('#address_id').val();
	$.ajax({
		url:'/Art/createOrder.json',
		type:'POST',
		data:{
			artwork_id:artwork_id,
			address_id:address_id
		},
		success:function(data){
			if(data.errno == 2){
				window.location.href = data.data;
			}else if(data.errno == 1){
				alert(data.data);
			}else{
				window.location.href='/Art/mall/jsp/buy/pay?payment_id='+data.data;
			}
		}
	});
}
function change(id){
	document.getElementById('address_id').val = id;
	document.getElementById('mainAddress').innerHTML = document.getElementById(id).innerHTML;
	document.getElementById('address').style.display='';
	document.getElementById('otherAddress').style.display='none';
}
function otherAddress(){
	document.getElementById('address').style.display='none';
	document.getElementById('otherAddress').style.display='';
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
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">订单确认</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
  <div class="baoliao w">
  	<div class="ui-tab">
      <div id = 'content'>
      	
      	<c:if test="${not empty artwork }">
      	 <div class="m_baoliao w">
	  		<div class="baoliao_title"><span>艺术品信息</span><em></em></div>
	  		<input class='form-control' id='artwork_id' name='artwork_id' value="${artwork.id }" type='hidden'/>
	      		<div class="ui-tab-content" id='itemList'>
			      	<a onClick='artworkInfo(${artwork.id})'>
				      	<div class="baoliao_content">
						    <div class="bl_img"><img src="${artwork.head_url }" /></div>
						    <div class="bl_right">
						        <div class="bl_title"><span class="bl_type" style="background-color:#53bf1e;">${ artwork.category.name}</span>${ artwork.name}</div>
						        <div class="bl_tag">
						            <div class="bl_price">价格：</div>
						            <c:set var="price" value="￥${artwork.price }"/>
						            <div class="bl_price">${ price}</div>
						            <c:set var="createYear" value="创作年份：${artwork.create_year }"/>
						            <div class="bl_time">${ createYear}</div>
						            <c:set var="artist" value="艺术家：${artwork.shop.artist.real_name }"/>
						            <div class="bl_mall">${ artist }</div>
						        </div>
						    </div>
						</div>
			      	</a>
	      		</div>
	      	</div>
      	</c:if>
      	
      	<c:choose>
      	<c:when test="${not empty address }">
      	 <div class="m_baoliao w" id='address' style="display:''">
	  		<div class="baoliao_title"><span>当前地址</span><em></em></div>
	  		<input class='form-control' id='address_id' name='address_id' value="${address.id }" type='hidden'/>
	      		<div class="ui-tab-content">
			      	<a><div class="baoliao_content">
						    <div class="bl_img"><img src="/Art/mall/images/address.png" /></div>
						    <div class="bl_right" id='mainAddress'>
						    	<div class="bl_title">${address.receiver_name}</div>
							        <c:set var="main" value="${address.province } ${address.city } ${address.district }"/>
							         <div class="bl_note">${main }</div>
							         <div class="bl_note">${address.detailDescription }</div>
							        <div class="bl_tag">
							            <div class="bl_price">手机：</div>
							            <div class="bl_price">${address.receiver_telephone }</div>
							            <c:set var="postalcode" value="邮编：${address.postalcode }"/>
							            <div class="bl_time">${ postalcode}</div>
							        </div>
						        </div>
						    </div>
					</div></a>
			      	<c:if test="${not empty addressList }">
			      	<div class="bl_more" id='moreBtn'><a onClick=otherAddress()>其他地址</a></div>
			      	</c:if>
	      		</div>
	      	</div>
      	</c:when>
      	<c:otherwise>
      	<div class="bl_more" id='moreBtn'><a onClick=addAddress()>添加地址</a></div>
      	</c:otherwise>
      	</c:choose>
      	
      	<c:if test="${not empty addressList }">
      	<div class="m_baoliao w" id='otherAddress' style="display:none">
	  		<div class="baoliao_title"><span>其他地址</span><em></em></div>
      			<div class="ui-tab-content">
   					<c:forEach var='address' items="${addressList }">
				      	<a onClick="change(${address.id})">
					      	<div class="baoliao_content">
							    <div class="bl_img"><img src="/Art/mall/images/unaddress.png" /></div>
							    <div class="bl_right"  id='${address.id }'>
							        <div class="bl_title">${address.receiver_name}</div>
							        <c:set var="main" value="${address.province } ${address.city } ${address.district }"/>
							         <div class="bl_note">${main }</div>
							         <div class="bl_note">${address.detailDescription }</div>
							        <div class="bl_tag">
							            <div class="bl_price">手机：</div>
							            <div class="bl_price">${address.receiver_telephone }</div>
							            <c:set var="postalcode" value="邮编：${address.postalcode }"/>
							            <div class="bl_time">${ postalcode}</div>
							        </div>
							    </div>
							</div>
				      	</a>
			      	</c:forEach>
			      	</div>
			 </div>
			 </c:if>
		</div>
     </div>
   <div class="go_buy"><a onClick='createOrder()' style="width:100%; border-radius:10px;">确认</a></div>
  
 	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>
</body>
</html>