<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="author" content="m.178hui.com">
    <meta name="applicable-device" content="mobile">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>订单详情</title>
    <meta name="author" content="We Plus">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css">
    <link href="/Art/mall/css/frozen.css" rel="stylesheet" type="text/css">
    <link href="/Art/mall/css/orderrdetail.css" rel="stylesheet" type="text/css">
    <link href="/Art/mall/css/owl.carousel.css" rel="stylesheet">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script src="/Art/mall/js/owl.carousel.min.js"></script>
    <script src="/Art/mall/js/public.js"></script>
    
  
    
</head>
<body>

<div class="mobile">
    <!--页面加载 开始-->
    <div id="preloader" style="display: none;">
        <div id="status" style="display: none;">
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
            <h2>订单详情</h2>
            <div class="head_right" style="top:13px;">
                <a href="/Art/mall/index" style="color:#FFFFFF; font-size:14px;">返回首页</a>
            </div>
        </div>
    </header>
    <!--header 结束-->


	<c:if test="${not empty order }">

    <div class="view w">
        <div class="bl_view_img"><img src="${order.artwork.head_url} "></div>
        <div class="bl_view_title">
            <span class="bl_type">${order.artwork.category.name }</span>
            <span class="bl_type" style="background-color:#53bf1e;">${order.artwork.shop.artist.real_name }</span>
            <span class="bl_type" style="background-color:#00bb9c;">一口价</span>
            ${order.artwork.name }
        </div>
        <div class="bl_view_tag">

            <div class="bl_view_price">￥${order.artwork.price }</div>
            <div class="bl_view_oprice">￥138.00</div>
        </div>

        <div class="bl_view_tag">
            <div class="bl_view_user">订单号：0130092${order.id}</div>
        </div>

        <div class="bl_view_tag">
        
            <div class="bl_view_user">艺术家：${order.artwork.shop.artist.real_name }</div>
                     
            <div class="bl_view_time">收藏人数：20人     </div>
            
        </div>

        <div class="bl_view_tag">
            
            <c:if test="${not empty Type_title}">
            <div class="bl_view_user">类型：${Type_title }</div>
            </c:if>
            
            <div class="bl_view_time">创作年份：${order.artwork.create_year }</div>
   
        </div>

		<div class="bl_view_tag">
            <div class="bl_view_user">快递单号：${order.tracking_number}</div>
        </div>

        <div class="bl_view_tag">
            <div class="bl_view_user">时间：${order.time}</div>
        </div>


		<c:if test="${not empty button_edit_price }">
		
		${button_edit_price }
		
		</c:if>
		
		<c:if test="${not empty button_set_payments }">
		
		${button_set_payments }
		
		</c:if>
		
		<c:if test="${not empty button_edit_express }">
		
		${button_edit_express }
		
		</c:if>


        <div id="detail" style="padding:10px;font-size: 12px;color: #666666;line-height: 23px">
            	简介：<br/>
            ${order.artwork.content }
        </div>

    </div>


	</c:if>
	
    <!-- gotop 开始 -->
    <div class="gotop backtop" style="display: block;"></div>
    <!-- gotop 结束 -->
    <!-- footer 开始 -->
    <div class="copyright">Copyright ©2015 We Plus 版权所有</div>
    <!-- footer 结束 -->
</div>

</body>
</html>