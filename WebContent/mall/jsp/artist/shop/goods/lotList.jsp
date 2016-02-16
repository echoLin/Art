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
	allLot();
	var is_passed=$("div#pass").attr("data");
	$("#ui_jumpPass li.ui_pass").each(function(){
		if(is_passed==$(this).attr("data"))
			$(this).addClass("current");
		else
			$(this).removeClass("current");
	});
	
	$("div.alert_toNotSale").click(function(){
		var lot_id=$(this).attr("id");
		layer.confirm('您确定将该商品下架？', {
		    btn: ['确定','取消'], //按钮
		    top:50
		}, function(){
			$.post(
				"/Art/mall/artist/shop/goods/lotChangeType.json",
				{
					lot_id:lot_id,
					type:1,
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
	
	$("div.alert_toCancelApply").click(function(){
		var lot_id=$(this).attr("id");
		layer.confirm('您确定取消拍卖申请？', {
		    btn: ['确定','取消'], //按钮
		    top:50
		}, function(){
			$.post(
				"/Art/mall/artist/shop/goods/lotChangeType.json",
				{
					lot_id:lot_id,
					type:2,
				},
				function(data){
					if(data.errno==0){
					   layer.msg("拍卖申请已取消", {icon: 1});
					   location.reload();
					}
					else
					   layer.msg("拍卖申请取消失败", {icon: 1});
				});
		});
	});
})

function modifyLotApply(e){
	var lot_id=$(e).attr("id");
	window.location.href="/Art/mall/jsp/artist/shop/goods/lot_apply?lot_id="+lot_id+"";
}
function allLot(){
	$("a.loted").show();
	$("s.willLot").show();
	$("a.loting").show();
	
	$("ul#ui_jumplot li#loting").removeClass("current");
	$("ul#ui_jumplot li#willLot").removeClass("current");
	$("ul#ui_jumplot li#loted").removeClass("current");
	$("ul#ui_jumplot li#all").addClass("current");
}
function loting(){
	$("a.loted").hide();
	$("a.willLot").hide();
	$("a.loting").show();
	
	$("ul#ui_jumplot li#loted").removeClass("current");
	$("ul#ui_jumplot li#willLot").removeClass("current");
	$("ul#ui_jumplot li#all").removeClass("current");
	$("ul#ui_jumplot li#loting").addClass("current");
}
function loted(){
	$("a.loted").show();
	$("a.willLot").hide();
	$("a.loting").hide();
	
	$("ul#ui_jumplot li#loting").removeClass("current");
	$("ul#ui_jumplot li#willLot").removeClass("current");
	$("ul#ui_jumplot li#all").removeClass("current");
	$("ul#ui_jumplot li#loted").addClass("current");
}
function willLot(){
	$("a.loted").hide();
	$("a.willLot").show();
	$("a.loting").hide();
	
	$("ul#ui_jumplot li#loting").removeClass("current");
	$("ul#ui_jumplot li#loted").removeClass("current");
	$("ul#ui_jumplot li#all").removeClass("current");
	$("ul#ui_jumplot li#willLot").addClass("current");
}


</script>
<script type="text/javascript">
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
  <div class="baoliao w" id="pass" data="${is_passed }">
  	<div class="ui-tab">
		<ul class="ui-tab-nav">
            <li data="0" class="ui_type"><a href="/Art/mall/jsp/artist/shop/goods/goodsList?shop_id=${shop.id }">非拍卖品</a></li>
            <li data="1" class="ui_type"><a href="/Art/mall/jsp/artist/shop/goods/goodsList?shop_id=${shop.id }&type=1">非卖品</a></li>
            <li data="2" class="ui_type"><a href="/Art/mall/jsp/artist/shop/goods/goodsList?shop_id=${shop.id }&type=2" >成品</a></li>
            <li data="4" class="ui_type current"><a href="/Art/mall/jsp/artist/shop/goods/lotList?shop_id=${shop.id }&is_passed=1" >拍卖品</a></li>
      </ul>
      <ul class="ui-tab-nav" id="ui_jumpPass"> 
            <li data="0" class="ui_pass"><a href="/Art/mall/jsp/artist/shop/goods/lotList?shop_id=${shop.id }&is_passed=0">待审核</a></li>
            <li data="1" class="ui_pass"><a href="/Art/mall/jsp/artist/shop/goods/lotList?shop_id=${shop.id }&is_passed=1" >审核通过</a></li>
            <li data="-1" class="ui_pass"><a href="/Art/mall/jsp/artist/shop/goods/lotList?shop_id=${shop.id }&is_passed=-1">审核未通过</a></li>
      </ul>
     <c:if test="${is_passed==1 }">
      <ul class="ui-tab-nav" id="ui_jumplot">
            <li id="loting" class="ui_lot"><a onclick="loting()">正在拍卖</a></li>
            <li id="willLot" class="ui_lot"><a onclick="willLot()">即将拍卖</a></li>
            <li id="loted" class="ui_lot"><a onclick="loted()">已结束拍卖</a></li>
            <li id="all" class="ui_lot"><a onclick="allLot()">所有拍卖</a></li>
      </ul>
      </c:if>
      <div class="ui-tab-content">
      <c:forEach var="lot" items="${list }">
        <c:if test="${lot.is_passed==0 }">
         <a href="#">
            <div class="baoliao_content">
                <div class="bl_img"><img src="${lot.artwork.head_url }" /></div>
                <div class="bl_right">
                    <div class="bl_title">${lot.artwork.name }</div>
                    <div class="bl_note">类型：${lot.artwork.category.name }</div>
                    <div class="bl_note lot_time">开始时间:${lot.start_time }</div>
                    <div class="bl_note lot_time">结束时间:${lot.end_time }</div>                   
                    <div class="bl_tag">
                        <div class="bl_price">起拍价:<span class="lot_price">${lot.price }</span></div>
                        <div class="bl_price" style="margin-left:10px;">一次加价:<span class="lot_price">${lot.add_price }</span></div>
                        <div class="bl_time"></div>
                        <div class="bl_mall"></div>
                    </div>
                    <div class="bl_tag">
                        <div class="bl_price"></div>
                        <div class="bl_price"></div>
                        <div class="bl_mall bl_button" onclick="modifyLotApply(this)" id="${lot.id }">修改申请</div>
                        <div class="bl_time bl_button alert_toCancelApply" id="${lot.id }" style="width:100px;">取消申请</div>
                        <div class="bl_mall bl_button alert_toNotSale" id="${lot.id }">下架</div>
                    </div>
                </div>
            </div> 
            </a>
        </c:if>
        <c:if test="${lot.is_passed==1 }">
        <c:choose>
        <c:when test="${lot.start_time > current }">
        <a href="#" class="willLot">
            <div class="baoliao_content">
                <div class="bl_img"><img src="${lot.artwork.head_url }" /></div>
                <div class="bl_right">
                    <div class="bl_title">${lot.artwork.name }</div>
                    <div class="bl_note">类型：${lot.artwork.category.name }</div>
                    <div class="bl_note">即将拍卖...</div>
                    <div class="bl_note lot_time">开始时间:${lot.start_time }</div>
                    <div class="bl_note lot_time">结束时间:${lot.end_time }</div>                 
                    <div class="bl_tag">
                        <div class="bl_price">起拍价:<span class="lot_price">${lot.price }</span></div>
                        <div class="bl_price" style="margin-left:10px;">一次加价:<span class="lot_price">${lot.add_price }</span></div>
                        <div class="bl_time"></div>
                        <div class="bl_mall"></div>
                    </div>
                </div>
            </div> 
            </a>
        </c:when>
        <c:when test="${lot.end_time <current }">
        <a href="#" class="loted">
            <div class="baoliao_content">
                <div class="bl_img"><img src="${lot.artwork.head_url }" /></div>
                <div class="bl_right">
                    <div class="bl_title">${lot.artwork.name }</div>
                    <div class="bl_note">类型：${lot.artwork.category.name }</div>
                    <div class="bl_note">拍卖已结束...</div>
                    <div class="bl_note lot_time">开始时间:${lot.start_time }</div>
                    <div class="bl_note lot_time">结束时间:${lot.end_time }</div> 
                    <div class="bl_note lot_time">成交价格:${lot.now_price }</div>                  
                    <div class="bl_tag">
                        <div class="bl_price">起拍价:<span class="lot_price">${lot.price }</span></div>
                        <div class="bl_price" style="margin-left:10px;">一次加价:<span class="lot_price">${lot.add_price }</span></div>
                        <div class="bl_time"></div>
                        <div class="bl_mall"></div>
                    </div>
                </div>
            </div> 
            </a>
        </c:when>
        <c:otherwise>
        <a href="#" class="loting">
            <div class="baoliao_content">
                <div class="bl_img"><img src="${lot.artwork.head_url }" /></div>
                <div class="bl_right">
                    <div class="bl_title">${lot.artwork.name }</div>
                    <div class="bl_note">类型：${lot.artwork.category.name }</div>
                    <div class="bl_note">正在拍卖...</div>
                    <div class="bl_note lot_time">开始时间:${lot.start_time }</div>
                    <div class="bl_note lot_time">结束时间:${lot.end_time }</div> 
                    <div class="bl_note lot_time">当前价格:<span class="lot_price">${lot.now_price }</span></div>                  
                    <div class="bl_tag">
                        <div class="bl_price">起拍价:<span class="lot_price">${lot.price }</span></div>
                        <div class="bl_price" style="margin-left:10px;">一次加价:<span class="lot_price">${lot.add_price }</span></div>
                        <div class="bl_time"></div>
                        <div class="bl_mall"></div>
                    </div>
                </div>
            </div> 
            </a>
        </c:otherwise>
        </c:choose>
        </c:if>
        <c:if test="${lot.is_passed==-1 }">
        <a href="#">
            <div class="baoliao_content">
                <div class="bl_img"><img src="${lot.artwork.head_url }" /></div>
                <div class="bl_right">
                    <div class="bl_title">${lot.artwork.name }</div>
                    <div class="bl_note">类型：${lot.artwork.category.name }</div>
                    <div class="bl_note lot_time">开始时间:${lot.start_time }</div>
                    <div class="bl_note lot_time">结束时间:${lot.end_time }</div>                   
                    <div class="bl_tag">
                        <div class="bl_price">起拍价:<span class="lot_price">${lot.price }</span></div>
                        <div class="bl_price" style="margin-left:10px;">一次加价:<span class="lot_price">${lot.add_price }</span></div>
                        <div class="bl_time"></div>
                        <div class="bl_mall"></div>
                    </div>
                    <div class="bl_tag">
                        <div class="bl_price"></div>
                        <div class="bl_price"></div>
                        <div class="bl_time bl_button" onclick="modifyLotApply(this)" id="${lot.id }" style="width:100px;">修改申请</div>
                        <div class="bl_mall bl_button alert_toNotSale" id="${lot.id }">下架</div>
                    </div>
                </div>
            </div> 
            </a>
        </c:if>
      </c:forEach>
            
      </div>
    </div>
  </div>
</div>
</body>
</html>