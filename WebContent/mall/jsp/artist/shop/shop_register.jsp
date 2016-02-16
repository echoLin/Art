<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>店铺注册</title>

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

$(document).ready(function(){
	$.ajax({
		async:false,//同步异步的关键参数
		url:"/Art/getCategoryList.json",
		type:"POST",
		data:{},
		success:function(data){
			if(checkData(data)){
				var html = "";
				for(var i = 0; i<data.data.length; i++){
					html+="<option value='"+data.data[i].id+"'>"+data.data[i].name+"</option>";
				}
				document.getElementById("select_type").innerHTML = html;
			}
		}
	});
});

function shop_register(){
	var name=$("input[name='shop_name']").val();
	var introduction=$("textarea#shop_desc").val();
	var category_id=$("#select_type option:selected").val();
	var is_customized=$("#select_customized option:selected").val();
	$.post(
		"/Art//mall/artist/shop/shop_register.json",
		{
			name:name,
			introduction:introduction,
			category_id:category_id,
			is_customized:is_customized
		},
		function(data){
			if(checkData(data)){
				//alert(data.data);
				if(data.errno==0)
				    window.location.href="/Art/mall/jsp/artist/shop/myshop?id="+data.data+"";
				else
					alert(data.data);
			}
		});

}

function checkData(data){
	if(data.errno == 2){
		window.location.href = data.Data;
	}else if(data.errno == 1){
		alert(data.data);
		return false;
	}else{
		return true;
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
      <h2>店铺注册</h2>
      <div class="header_right shaixuan"><a href="index.html"><img src="/Art/mall/images/iconfont-shouye.png"></a></div>
    </div>
  </header>
  <!--header 结束-->
  <div class="w main">
    <form id="frm_register" method="post" action="">
      <div class="item item-username">
        <input class="txt-input txt-username" type="text" placeholder="店铺名称" value="" name="shop_name"></div>
      <div class="item item-username">
        <textarea id="shop_desc" class="txt-input txt-username" placeholder="店铺介绍"></textarea>
      </div>
      <div class="item item-username item_type">
       <div class="shop_type">店铺所属类型</div>
        <select id="select_type">
       </select>
      </div>
       <div class="item item-username item_type">
       <div class="shop_type">开通定制服务</div>
       <select id="select_customized">
         <option value="1">是</option>
         <option value="-1">否</option>
       </select>
      </div>
      <div class="ui-btn-wrap"><a class="ui-btn-lg ui-btn-primary" onclick="shop_register()">店铺注册</a> </div>
    </form>
  </div>
  </div>
</body>
</html>