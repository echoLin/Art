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
  function modify_psd(){
    var old_psd=$("input[name='old_psd']").val();
    var new_psd=$("input[name='new_psd']").val();
    var new_psd2=$("input[name='new_psd2']").val();
    if(old_psd==""||new_psd==""||new_psd2=="")
      alert("输入不完整");
    else if(new_psd.length<6||new_psd.length>20)
      alert("密码需在6-20位之间");
    else if(new_psd!=new_psd2)
      alert("输入密码不一致");
    else{
    	$.post(
    			"/Art/mall/modify_psd.json",
    			{
    				old_psd:old_psd,
    				new_psd:new_psd
    			},
    			function(data){
    				alert(data.info);
    				if(data.type==0)
    					window.location.href="/Art/mall/jsp/user/user";
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
      <h2>密码</h2> 
      <div class="header_right shaixuan" style="color:white" onclick="modify_psd()">保存</div>
    </div>
  </header>
     <div class="user_nav_list w">
      <ul style="margin-right:10px;">
      <li><input type="password" placeholder="现在的密码" name="old_psd"></li>
      <li><input type="password" placeholder="新的密码" name="new_psd"></li>
      <li><input type="password" placeholder="确认新的密码" name="new_psd2"></li>    
      </ul>
    </div>
</div>
</body>
</html>