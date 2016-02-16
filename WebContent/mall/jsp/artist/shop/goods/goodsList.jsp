<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>商品管理</title>
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/goods.css" rel="stylesheet" type="text/css">

<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>
<script src="/Art/mall/layer/layer.js"></script>
<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
	var type=$("div#type").attr("data");
	$("#ui_jumpType li.ui_type").each(function(){
		if(type==$(this).attr("data"))
			$(this).addClass("current");
		else
			$(this).removeClass("current");
	});
	$("div.alert_toSale").click(function(){
		var artwork_id=$(this).attr("id");
		layer.confirm('您确定将该非卖品上架？', {
		    btn: ['确定','取消'] //按钮
		}, function(){
			$.post(
				"/Art/mall/artist/shop/goods/changeType.json",
				{
					artwork_id:artwork_id,
					type:2
				},
				function(data){
					if(data.errno==0){
					   layer.msg("该商品已上架", {icon: 1});
					   location.reload();
					}
					else
						layer.msg("该商品上架失败", {icon: 1});
				});
		});
	});
	
	$("div.alert_toNotSale").click(function(){
		var artwork_id=$(this).attr("id");
		layer.confirm('您确定将该商品下架？', {
		    btn: ['确定','取消'], //按钮
		    top:50
		}, function(){
			$.post(
				"/Art/mall/artist/shop/goods/changeType.json",
				{
					artwork_id:artwork_id,
					type:1
				},
				function(data){
					if(data.errno==0){
					   layer.msg("该商品已下架", {icon: 1});
					   location.reload();
					}
					else
					   layer.msg("该商品下架失败", {icon: 1});
				});
		});
	});
	
	$("div.alert_toLot").click(function(){
		var artwork_id=$(this).attr("id");
		window.location.href="/Art/mall/jsp/artist/shop/goods/lot_apply?artwork_id="+artwork_id+"";
	});
})
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
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>商品管理</h2>
      <div class="header_right shaixuan"><a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png"></a></div>
    </div>
  </header>
  <!--header 结束-->
  <div class="baoliao w" id="type" data="${type }">
  	<div class="ui-tab">
		<ul class="ui-tab-nav" id="ui_jumpType">
            <li data="0" class="ui_type"><a href="/Art/mall/jsp/artist/shop/goods/goodsList?shop_id=${shop.id }">非拍卖品</a></li>
            <li data="1" class="ui_type"><a href="/Art/mall/jsp/artist/shop/goods/goodsList?shop_id=${shop.id }&type=1">非卖品</a></li>
            <li data="2" class="ui_type"><a href="/Art/mall/jsp/artist/shop/goods/goodsList?shop_id=${shop.id }&type=2" >成品</a></li>
            <li data="4" class="ui_type"><a href="/Art/mall/jsp/artist/shop/goods/lotList?shop_id=${shop.id }&is_passed=1" >拍卖品</a></li>
      </ul>
      <div class="ui-tab-content">
        <c:forEach var="artwork" items="${list }">
        <c:choose>
        <c:when test="${artwork.type==1 }">
        <a href="/Art/mall/jsp/artMall/artworkInfo?artist=1&id=${artwork.id }">
            <div class="baoliao_content">
                <div class="bl_img"><img src="${artwork.head_url }" /></div>
                <div class="bl_right">
                    <div class="bl_title">${artwork.name }</div>
                    <div class="bl_title">[非卖品]</div>
                    <div class="bl_note">${artwork.category.name }</div>
                    <div class="bl_tag">
                        <div class="bl_price"></div>
                        <div class="bl_oprice"></div>
                        <div class="bl_time bl_button alert_toLot" id="${artwork.id }">送拍</div>
                        <div class="bl_mall bl_button alert_toSale" id="${artwork.id }">上架</div>
                    </div>
                </div>
            </div> 
            </a>
        </c:when>
        <c:when test="${artwork.type==2 }">
        <a href="/Art/mall/jsp/artMall/artworkInfo?artist=1&id=${artwork.id }">
            <div class="baoliao_content">
                <div class="bl_img"><img src="${artwork.head_url }" /></div>
                <div class="bl_right">
                    <div class="bl_title">${artwork.name }</div>
                    <div class="bl_title">[成品]</div>
                    <div class="bl_note">类型：${artwork.category.name }</div>
                    <div class="bl_tag">
                        <div class="bl_price">价格:<span class="lot_price">${artwork.price }</span></div>
                        <div class="bl_oprice"></div>
                        <div class="bl_time bl_button alert_toLot" id="${artwork.id }">送拍</div>
                        <div class="bl_mall bl_button alert_toNotSale" id="${artwork.id }">下架</div>
                    </div>
                </div>
            </div> 
            </a>
        </c:when>
        <c:when test="${artwork.type==3 }"></c:when>
        </c:choose>
        </c:forEach>
      </div>
    </div>
  </div>
</div>
</body>
</html>