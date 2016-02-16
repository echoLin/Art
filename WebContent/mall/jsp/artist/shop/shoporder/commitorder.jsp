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
  function commitorder(){
	
	var orderid=${id};  
	
	$.post(
    			"/Art/mall/jsp/artist/shop/shoporder/commit_order.json",
    			{
    				id:orderid
    			},
    			function(data){
    				if(data.errno==0)
    					window.location.href="/Art/mall/jsp/artist/shop/shoporder/shoporder.jsp";
    				else
    					alert(data.data);
    });
    
	alert("订单交易成功");

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
      <h2>确认订单</h2> 
      <div class="header_right shaixuan" style="color:white" onclick="commitorder()">确认</div>
    </div>
  </header>
    <div class="user_nav_list w" style="background-color:#f5f5f5">
    	<p>议定价格如下，点击确认可完成交易： </p>
      <input type="text" value="${value }" name="new_price" disabled="true" >
    </div>
</div>
</body>
</html>