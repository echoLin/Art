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
<link href="/Art/mall/css/news.css" rel="stylesheet" type="text/css" />
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script>
</script>
<title>艺术资讯内容</title>
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
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">${article.block.name }</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
	<!-- header 结束 -->
	<!-- content 开始 -->
	<div id="content" style="padding:10px;">
		<div class="news_view w">
			<h1>${ article.title}</h1>
		</div>
		<div class="news_tags">
			<span>时间：${article.up_time}</span>
			<span>来源：${article.block.name }</span>
			<span>作者：${article.editor.realname }</span>
		</div>
		<div class="news_content">
        	<span style="text-align:center; width:100%; float:left;">
        		<img src="${article.head_url }" />
        	</span>
            ${article.content }
		</div>                  
	</div>
	<!-- content 结束 -->
	<!-- gotop 开始 -->
	<div class="gotop backtop" style="display:none;"></div>
	<!-- gotop 结束 -->
	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>

</body>
</html>