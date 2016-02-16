<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>店铺设置</title>

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
  function modify_shopname(){
    var new_name=$("input[name='new_name']").val();
    var shop_id=$("input[name='new_name']").attr("id");
    if(new_name=="")
    	alert("店铺名称不能为空");
    else{
    	$.post(
    			"/Art/mall/artist/shop/shop_name.json",
    			{
    				new_name:new_name,
    				shop_id:shop_id
    			},
    			function(data){
    				if(data.errno==0)
    					window.location.href="/Art/mall/jsp/artist/shop/shopInfo?id="+data.data+"";
    				else if(data.errno==2)
    					window.location.href=data.data;
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
      <h2>店铺名称</h2> 
      <div class="header_right shaixuan" style="color:white" onclick="modify_shopname()">保存</div>
    </div>
  </header>
    <div class="user_nav_list w" style="background-color:#f5f5f5">
    	<p>给自己起个喜欢的名字，做一朵不一样的烟火</p>
      <input type="text" value="${shop.name }" name="new_name" id="${shop.id }">
    </div>
</div>
</body>
</html>