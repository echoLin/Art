<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>addressInfo</title>

<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/addressInfo.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="/Art/mall/css/mobile-select-area.css">
<link rel="stylesheet" type="text/css" href="/Art/mall/css/dialog.css">

<script type="text/javascript" src="/Art/mall/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/Art/mall/layer/layer.js"></script>
<script type="text/javascript" src="/Art/mall/js/dialog.js"></script>
<script type="text/javascript" src="/Art/mall/js/mobile-select-area.js"></script>
<script type="text/javascript" src="/Art/mall/js/require.js"></script>
<script type="text/javascript" src="/Art/mall/js/zepto.js"></script>
<script type="text/javascript" src="/Art/mall/js/address.js"></script>

<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
});
</script>

</head>

<body>
<div class="mobile" style="background-color:#f5f5f5">
	<!--页面加载 开始-->
  <div id="preloader">
    <div id="status">
      <p class="center-text"><span>拼命加载中···</span></p>
    </div>
  </div>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <header>
    <div class="header"> <a class="new-a-back" href="/Art/mall/jsp/user/address"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>收货信息</h2>
      <c:if test = "${ not empty address }">
         <div class="header_right shaixuan" style="color:white" onclick="updateAddress(${ address.id })">更新</div>
      </c:if>
      <c:if test = "${ empty address }">
      <div class="header_right shaixuan" style="color:white" onclick="postAddress()">提交</div></c:if>
    </div>
  </header>
  <!--header 结束-->
  
     <form id="frm_address" class="address_form">
        <div class="item">
          <span>收货人姓名：</span>
          <input id="receiver_name" type="text" placeholder="必填" value="${ address.receiver_name}" name="receiver_name">
          <p id="validateReceiverName">真实姓名不能为空</p></div>
        <div class="item">
          <span>手机号码：</span>
          <input id="receiver_telephone" type="text" placeholder="必填" value="${ address.receiver_telephone }" name="receiver_telephone" >
          <p id="validateReceiverTelephone">手机号码不能为空</p></div>      
          
        <div class="item">
          <span>省/市/区(县)：</span>
          <input type="text" id="txt_area" placeholder="必填" value="${ address.province } ${ address.city} ${ address.district}" name="addressPCD"/>
		  <!-- <input type="hidden" id="hd_area" value=""/>  -->
		  <script type="text/javascript">
		     var selectArea = new MobileSelectArea();
		     //selectArea.init({trigger:$('#txt_area'),value:$('#hd_area').val(),data:'/Art/json/data.json'});
		     selectArea.init({trigger:$('#txt_area'),data:'/Art/json/data.json'});
		  </script>
		  <p id="validateAddressPCD">省/市/区(县)不能为空</p>
	    </div>
	    
        <div class="item">
          <span>详细地址：</span>
          <input id="detailDescription" type="text" placeholder="必填" value="${ address.detailDescription }" name="detailDescription"> 
          <p id="validateDetailDescription">详细地址不能为空</p></div>        
        
        <div class="item">
          <span>邮政编码：</span>
          <input id="postalcode" type="text" placeholder="必填" value="${ address.postalcode }" name="postalcode">
          <p id="validatePostalcode">邮政编码不能为空</p></div>    

      </form>
       
</div>
</body>
</html>