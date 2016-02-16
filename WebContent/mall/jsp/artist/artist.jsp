<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>艺术家主页</title>

<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/user.css" rel="stylesheet" type="text/css">
<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>
<script src="/Art/mall/layer/layer.js"></script>

<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
});
</script>
<script type="text/javascript">
$(document).ready(function(){
	$(".login_out").click(function(){
		layer.confirm('您确定要退出吗？',  {skin: 'layui-layer-molv',offset: '30%'}, function(index){
			layer.close(index);
			layer.msg('拜拜！欢迎下次光临！', {shift: 6, time: 1500},function(){
				window.location='/Art/mall/logout';
			});
		});
	});
});
function toAvatar(){
	window.location.href='/Art/mall/jsp/user/avatar';
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
      <h2>艺术家主页</h2>
      <div class="header_right shaixuan"><a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png"></a></div>
    </div>
  </header>
  <!--header 结束-->

	<div class="user_top w">
    	<div class="user_logo"><div class="img">
	    	<c:if test="${not empty artist.user.avatar }">
	    		<img src="${artist.user.avatar }">
	    	</c:if>
	    	<c:if test="${empty artist.user.avatar }">
	    		<img src="/Art/mall/images/user_logo.jpg">
	    	</c:if>
    	</div></div>
        <div class="user_info">
        	<div class="user_name">${artist.real_name }</div>
        </div>
    </div>
    <div class="user_nav_list w">
    	<ul>
            <li>
            	<a href="#">
                    <div class="u_nav_name">真实姓名</div>
                    <div class="nt_icon"></div>
                    <div class="u_money u_shop"><i>${artist.real_name }</i></div>
              </a>
            </li>
            <li>
            	<a href="#">
                    <div class="u_nav_name">艺术领域</div>
                    <div class="nt_icon"></div>
                    <div class="u_money u_shop"><i>${artist.art_direction }</i></div>
              </a>
            </li>
            <li>
            	<a href="#">
                    <div class="u_nav_name">教育经历</div>
                    <div class="nt_icon"></div>
                    <div class="u_money u_shop"><i>${artist.education }</i></div>
              </a>
            </li>
            <li>
            	<a href="#">
                    <div class="u_nav_name">个人简介</div>
                    <div class="nt_icon"></div>
                    <div class="u_money u_shop"><i>${artist.introduction }</i></div>
              </a>
            </li>
            <li>
            	<a href="#">
                    <div class="u_nav_name">申请时间</div>
                    <div class="nt_icon"></div>
                    <div class="u_money u_shop"><i>${artist.apply_time }</i></div>
              </a>
            </li>
        </ul>
    </div>
 <!-- <div class="login_out w"><a><span><img src="/Art/mall/images/iconfont-tuichu.png"></span><i>安全退出</i></a></div>-->
</div>
</body>
</html>