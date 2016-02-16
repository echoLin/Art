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
  function modify_username(){
    var new_username=$("input[name='new_username']").val();
    var usernameReg=!!new_username.match(/^([\u4E00-\uFA29]*[a-z]*[A-Z]*[0-9]*)+$/);
    if(usernameReg==false||new_username.length<3||new_username.length>10){
      $("div.user_nav_list p").text("昵称只能包括数字和字母，且只能在3-10位之间");
      $("div.user_nav_list p").css("color","red");
    }
    else{
    	$.post(
    			"/Art/mall/modify_username.json",
    			{
    				new_name:new_username
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
      <h2>昵称</h2> 
      <div class="header_right shaixuan" style="color:white" onclick="modify_username()">保存</div>
    </div>
  </header>
    <div class="user_nav_list w" style="background-color:#f5f5f5">
    	<p>给自己起个喜欢的名字，做一朵不一样的烟火</p>
      <input type="text" value="${user.username }" name="new_username">
    </div>
</div>
</body>
</html>