<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>订单管理</title>

<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/user.css" rel="stylesheet" type="text/css">
<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>
<script src="/Art/mall/layer/layer.js"></script>

<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
})
</script>
</head>
<script>
  function modify_pirce(){
	
	
    var new_orderpirce=$("input[name='new_price']").val();
    
	var orderid=${id};
	var shop_id=${shop_id};
	var backpage="/Art/mall/jsp/artist/shop/shoporder/orderdetail?id=";
	backpage=backpage+orderid+"&shop_id="+shop_id;
    
    var usernameReg=!!new_orderpirce.match(/^([.]*[0-9]*)+$/);
    
    if(usernameReg==false){
      alert("价格格式错误");
      $("div.user_nav_list p").text("价格只能由小数点和数字组成");
      $("div.user_nav_list p").css("color","red");
    }else{
    	
    	$.post(
    			"/Art/mall/jsp/artist/shop/shoporder/modify_price.json",
    			{
    				new_price:new_orderpirce,
    				id:orderid,
    				shop_id:shop_id
    			},
    			function(data){
    				if(data.errno==0)
    					window.location.href=backpage;
    				else
    					alert(data.data);
    	});
    	alert("订单修改成功");
    }
  }
</script>
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
    <div class="header"> 
    <a class="new-a-back" href="javascript:history.back();">
     <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>订单议价修改</h2> 
      <div class="header_right shaixuan" style="color:white" onclick="modify_pirce()">保存</div>
    </div>
  </header>
    <div class="user_nav_list w" style="background-color:#f5f5f5">
    	<p>请根据和客户议价的结果，对订单价格做合理调整！ </p>
      <input type="text" value="${value }" name="new_price">
    </div>
</div>
</body>
</html>