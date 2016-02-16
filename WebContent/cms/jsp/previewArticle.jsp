<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link href="/Art/cms/css/previewArticle.css" rel="stylesheet" type="text/css" />
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script>
//页面加载
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
});
</script>
<title>预览-${article.title}</title>
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
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">预览</div>
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
	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>
</body>
</html>