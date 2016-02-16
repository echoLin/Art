<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>送拍</title>

<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="/Art/mall/css/shop_register.css">
<link rel="stylesheet" type="text/css" href="/Art/mall/css/login.css">

<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>
<script src="/Art/mall/layer/layer.js"></script>

<script>
$(window).load(function() {
  $("#status").fadeOut();
  $("#preloader").delay(350).fadeOut("slow");
});

function applyLot(e){
	var start_time=$("input[name='start_time']").val();
	var end_time=$("input[name='end_time']").val();
	var price=$("input[name='price']").val();
	var add_price=$("input[name='add_price']").val();
	var artwork_id=$(e).attr("id");
	var shop_id=$(".main").attr("id");
	if(start_time==""||end_time==""||price==""||add_price=="")
		alert("信息填写不完整");
	else{
		$.post(
				'/Art/mall/artist/shop/goods/toLot.json',
				{
					start:start_time,
					end:end_time,
					price:price,
					add_price:add_price,
					artwork_id:artwork_id
				},
				function(data){
					alert(data.data);
					if(data.errno==0)
						window.location.href="/Art/mall/jsp/artist/shop/goods/goodsList?shop_id="+shop_id+"";
				});
	}
}
	
	function updateLot(e){
		var start_time=$("input[name='start_time']").val();
		var end_time=$("input[name='end_time']").val();
		var price=$("input[name='price']").val();
		var add_price=$("input[name='add_price']").val();
		var lot_id=$(e).attr("id");
		var shop_id=$(".main").attr("id");
		if(start_time==""||end_time==""||price==""||add_price=="")
			alert("信息填写不完整");
		else{
			$.post(
					'/Art/mall/artist/shop/goods/updateLot.json',
					{
						start:start_time,
						end:end_time,
						price:price,
						add_price:add_price,
						lot_id:lot_id
					},
					function(data){
						alert(data.data);
						if(data.errno==0)
							window.location.href="/Art/mall/jsp/artist/shop/goods/lotList?shop_id="+shop_id+"&is_passed=0";
					});
		}
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
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>
      <c:if test="${type==0 }">申请拍卖</c:if>
      <c:if test="${type==1 }">修改申请</c:if></h2>
      <div class="header_right shaixuan"></div>
    </div>
  </header>
  <!--header 结束-->
  <c:if test="${type==0 }">
   <div class="w main" id="${shop_id }">
    <form id="frm_register" method="post" action="">
      <div class="item item-username item_type">
       <div class="shop_type">开始时间</div>
        <input type="datetime-local" name="start_time" style="width:75%">
      </div>
       <div class="item item-username item_type">
       <div class="shop_type">结束时间</div>
        <input type="datetime-local" name="end_time" style="width:75%">
      </div>
      <div class="item item-username item_type">
       <div class="shop_type">起拍价格</div>
        <input type="text" name="price" style="width:75%">
      </div>
      <div class="item item-username item_type">
       <div class="shop_type">每次加价</div>
        <input type="text" name="add_price" style="width:75%">
      </div>
      <div class="ui-btn-wrap"><a class="ui-btn-lg ui-btn-primary" onclick="applyLot(this)" id=${artwork_id }>申请拍卖</a> </div>
    </form>
  </div>
  </c:if>
  <c:if test="${type==1 }">
   <div class="w main" id="${lot.artwork.shop.id }">
    <form id="frm_register" method="post" action="">
      <div class="item item-username item_type">
       <div class="shop_type">开始时间</div>
        <input type="datetime-local" name="start_time" value="${start_time }" style="width:75%">
      </div>
       <div class="item item-username item_type">
       <div class="shop_type">结束时间</div>
        <input type="datetime-local" name="end_time" value="${end_time }" style="width:75%">
      </div>
      <div class="item item-username item_type">
       <div class="shop_type">起拍价格</div>
        <input type="text" name="price" value="${lot.price }" style="width:75%">
      </div>
      <div class="item item-username item_type">
       <div class="shop_type">每次加价</div>
        <input type="text" name="add_price" value="${lot.add_price }" style="width:75%">
      </div>
      <div class="ui-btn-wrap"><a class="ui-btn-lg ui-btn-primary" onclick="updateLot(this)" id=${lot.id }>提交修改</a> </div>
    </form>
  </div>
  </c:if>
 
  </div>
</body>
</html>