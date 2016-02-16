<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>充值金额</title>

<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/user.css" rel="stylesheet" type="text/css">
<link href="/Art/mall/css/money.css" rel="stylesheet" type="text/css">
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
  function commit(){
    var recharge = $("#recharge").val();
    var rechargeReg = !!recharge.match( /[1-9]\d*.\d*|0.\d*[1-9]\d*/);
    if(rechargeReg == false){
      $("p").text("请输入大于零的充值金额");
      $("p").css("color","red");
    }
    else{
   	$.post(
    			"/Art/mall/recharge.json",
    			{
    				recharge:recharge
    			},
    			function(data){
    				if(data.errno==0)
    					window.location.href="/Art/mall/jsp/user/money";
    				else
    					alert(data.data);
    			});
 

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
    <div class="header"> <a class="new-a-back" href="/Art/mall/jsp/user/user"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>充值金额</h2> 
    </div>
  </header>
    <div class="user_nav_list w" style="background-color:#f5f5f5">
    	<input id = "recharge"class = "my_input" type="text" placeholder="请输入金额" value="" name="money">
    	<button class = "my_money_btn" onclick = "commit()">确定</button>
    	<p></p>
    </div>
</div>
</body>
</html>