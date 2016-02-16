<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <meta name="format-detection" content="telephone=no">
    <title>店铺详情</title>
    <link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
    <link href="/Art/mall/css/shop.css" rel="stylesheet" type="text/css" >
    <link href="/Art/mall/css/artworkInfo.css" rel="stylesheet" type="text/css">
    <script src="/Art/mall/js/jquery-2.1.4.js"></script> 
    <script src="/Art/mall/js/public.js"></script>
    <script src="/Art/mall/js/shopInfo.js"></script>
</head>

<body>
<!--页面加载 开始-->
  <div id="preloader">
    <div id="status">
      <p class="center-text"><span>拼命加载中···</span></p>
    </div>
  </div>
<!--页面加载 结束--> 
<div class="mobile">
        <div class="header">
            <a class="new-a-back" href="javascript:history.back();">
                <span>
                    <img src="/Art/mall/images/iconfont-fanhui.png"></span>
            </a>
            <h2 id='headTitle'>${shop.name }</h2>
            <input class='form-control' id='shop_id' name='shop_id' value="${shop.id }" type='hidden'/>
            <div class="header_right shaixuan">
                <a href="/Art/mall/jsp/artist/shopList">
                    <img src="/Art/mall/images/iconfont-shouye.png"></a>
            </div>
        </div>
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
			<c:when test="${shop.is_customized == 1 }">
		        <div class="toAddGoods">
		         	<a onClick='connect(${shop.artist.user.userid})' style="width:50%; border-radius:10px;">联系艺术家</a>
		            <a href="/Art/mall/jsp/buy/confirmCustomOrder?shop_id=${shop.id }" style="width:50%; border-radius:10px;">我要定制</a>
		        </div>
	        </c:when>
	        <c:otherwise>
	        	 <div class="toAddGoods">
		         	<a onClick='connect(${shop.artist.user.userid})' style="width:100%; border-radius:10px;">联系艺术家</a>
		        </div>
	        </c:otherwise>
        </c:choose>
        <div class="view w">
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
        </div>
<!-- gotop 开始 -->
	<div class="gotop backtop" style="display:none;"></div>
	<!-- gotop 结束 -->
	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>
</body>
</html>