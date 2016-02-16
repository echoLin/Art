<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	var id=$("select").attr("id");
	$("select option[value="+id+"]").attr("selected",true);
})
</script>
</head>
<script>
function modify_shopIsCustomized(){
    var new_isCustomized=$("select option:selected").val();
    var shop_id=$("select").parent().attr("id");
    $.post(
    			"/Art/mall/artist/shop/shop_isCustomized.json",
    			{
    				new_isCustomized:new_isCustomized,
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
      <h2>是否开通定制服务</h2> 
      <div class="header_right shaixuan" style="color:white" onclick="modify_shopIsCustomized()">保存</div>
    </div>
  </header>
    <div class="user_nav_list w" style="background-color:#f5f5f5" id="${shop.id }">
      <select style="width: 97%;height: 30px;margin-top: 10px;" id="${shop.is_customized }">
         <option value="-1">否</option>
         <option value="1">是</option>
      </select>
    </div>
</div>
</body>
</html>