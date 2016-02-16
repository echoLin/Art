<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="We Plus" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/index.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/artMall.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/shopList.css" rel="stylesheet" type="text/css"/>
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script>
/*$(document).ready(function(){
	$.ajax({
		async:false,//同步异步的关键参数
		url:"/Art/mall/shop/getShopListByArtist.json",
		type:"POST",
		data:{},
		success:function(data){
			if(checkData(data)){
				var html = "";
				if(data.data.length == 0){
					html += "<p>没有店铺</p>";
				}else{
					html += "<div class='ui-tab-content'>";
					for(var i = 0; i<data.data.length; i++){
						html +="<a onClick=shop("+data.data[i].id+")><div class='baoliao_content'><div class='bl_img'><img src='/Art/images/avatar/1.png' /></div><div class='bl_right'><div class='bl_title'>"+data.data[i].name+"</div><div class='bl_note'>"+data.data[i].introduction+"</div><div class='bl_tag'><div class='bl_price'>类别:</div><div class='bl_price'>"+data.data[i].category.name+"</div><div class='bl_time'>"+data.data[i].time+"</div><div class='bl_mall'>时间：</div></div></div></div> </a>";
					}
					html+="</div>";
				}
				document.getElementById("content").innerHTML = html;
			}
		}
	});
});*/
/*function shop(id){
	var url = '/Art/mall/jsp/artist/shop/myshop?id='+id;
	window.location.href = url;
}*/
function register(){
	window.location.href = '/Art/mall/jsp/artist/shop/shop_register';
}
/*function checkData(data){
	if(data.errno == 2){
		window.location.href = data.Data;
	}else if(data.errno == 1){
		alert(data.data);
		return false;
	}else{
		return true;
	}
}*/
</script>
<title>艺术家的店铺列表</title>
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
	<!-- header 开始 -->
    <div class="header" id="header">
		<a class="new-a-back" href="javascript:history.back();">
			<span><img src="../images/iconfont-fanhui.png"></span>
		</a>
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">店铺列表</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
	<!-- header 结束 -->
	<!-- content 开始 -->
	<div id="content">
	</div>
	<!-- content 结束 -->
	<div class="bl_more"><a onClick='register()'>申请店铺</a></div>
	  <div class="baoliao w">
  	<div class="ui-tab">
      <div class="ui-tab-content">
        <c:forEach var="shop" items="${list }">
            <a href="/Art/mall/jsp/artist/shop/myshop?id=${shop.id }">
            <div class="baoliao_content">
                <div class="bl_img"><img src="${shop.head_url }" /></div>
                <div class="bl_right">
                    <div class="bl_title">${shop.name }</div>
                    <div class="bl_note">${shop.introduction }</div>
                    <div class="bl_tag">
                        <div class="bl_price">类型：${shop.category.name }</div>
                        <div class="bl_time">${shop.time }</div>
                    </div>
                </div>
            </div> 
            </a>
        </c:forEach>
      </div>
    </div>
  </div>
	<!-- gotop 开始 -->
	<div class="gotop backtop" style="display:none;"></div>
	<!-- gotop 结束 -->
	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>
</body>

</html>