<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <meta name="format-detection" content="telephone=no">
    <title>我的店铺</title>
    <link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
    <link href="/Art/mall/css/shop.css" rel="stylesheet" type="text/css" >
    <script src="/Art/mall/js/jquery-2.1.4.js"></script> 
    <script src="/Art/mall/js/public.js"></script>
    <script>
    function toUploadArtwork(artwork_id){
    	var shop_id = $('input#shop_id').val();
    	artwork_id = artwork_id == null?0:artwork_id;
    	var url = '/Art/mall/jsp/artist/shop/uploadArtwork?shop_id='+shop_id+'&artwork_id='+artwork_id;
    	window.location.href=url;
    }
    </script>
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
		<div id='content'>
		<div class="shop_top">
            <div class="img">
            <img src="${shop.head_url }">
            </div>
            <div class="shop_info">
            <div class="shop_name">${shop.name }</div>
            <div class="shop_name">简介：${shop.introduction }</div>
            </div>
        </div>

        <div class="toAddGoods">
            <a onClick='toUploadArtwork()'>发布商品</a>
        </div>
        
        <div class="top_w" style="padding-left:0.5%;padding-top:60px;">
            <ul class="func">
                <li style="border-top-style:solid;border-right-style:solid;border-bottom-style:solid;">
                <a href="/Art/mall/jsp/artist/shop/goods/goodsList?shop_id=${shop.id }">
                    <div class="icon"><img src="/Art/mall/images/mall.png"></div>
                    <div class="label"><span>商品管理</span></div>
                </a>
                </li>
                <li style="border-top-style:solid;border-bottom-style:solid;">
                <a href="javascript:void(0);">
                    <div class="icon"><img src="/Art/mall/images/news.png"></div>
                    <div class="label"><span>售后中心</span></div>
                </a>
                </li>
                <li style="border-bottom-style:solid;border-right-style:solid;">
                <a href="/Art/mall/jsp/artist/shop/shoporder/shoporder?shop_id=${shop.id }">
                    <div class="icon"><img src="/Art/mall/images/order.png"></div>
                    <div class="label"><span>订单管理</span></div>
                </a>
                </li>
                <li style="border-bottom-style:solid;">
                <a href="/Art/mall/jsp/artist/shop/shopInfo?id=${shop.id }">
                    <div class="icon"><img src="/Art/mall/images/person.png"></div>
                    <div class="label"><span>店铺设置</span></div>
                </a>
                </li>
            </ul>
        </div>
	    </div>
</div>
<div class="copyright" style="position:fixed;bottom:0px;">Copyright ©2015 We Plus 版权所有</div>
</body>
</html>