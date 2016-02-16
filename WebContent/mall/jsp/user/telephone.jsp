<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>个人中心</title>

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
  function modify_tel(){
    var new_tel=$("input[name='new_tel']").val();
    var telReg = !!new_tel.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
    if(telReg==false){
      $("div.user_nav_list p").text("手机号码格式错误");
      $("div.user_nav_list p").css("color","red");
    }
    else{
    	$.post(
    			"/Art/mall/modify_tel.json",
    			{
    				new_tel:new_tel
    			},
    			function(data){
    				if(data.errno==0)
    					window.location.href="/Art/mall/jsp/user/user";
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
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>手机号</h2> 
      <div class="header_right shaixuan" style="color:white" onclick="modify_tel()">保存</div>
    </div>
  </header>
    <div class="user_nav_list w" style="background-color:#f5f5f5">
    	<p>更换手机号</p>
      <input type="text" value="${user.telephone }" name="new_tel">
    </div>
</div>
</body>
</html>