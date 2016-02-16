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
<link href="/Art/mall/css/owl.carousel.css" rel="stylesheet">
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/owl.carousel.min.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script>
function news(id){
	var url = '/Art/mall/jsp/news?id='+id;
	window.location.href = url;
}
function newsHref(url){
	window.open(url);
}
</script>
<title>艺术资讯列表</title>
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
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">艺术资讯</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
	<!-- header 结束 -->
	<!-- content 开始 -->
	<div id="content">
		<c:if test="${not empty blockList }">
		<c:forEach var="block" items="${ blockList}">
		<div class="top w">
			<!-- 首页轮播 start-->
			<c:if test="${block.id == 1 }">
	   	    <div class="m_banner" id="owl">
	   	    	<c:if test="${not empty list[block.id-1] }">
	   	    	<c:forEach var="article" items="${list[block.id-1] }">
	   	    	<c:if test="${article.type == 1 }">
	            <a onClick="news(${article.id})" class="item"><img src="${article.head_url }"></a>
	            </c:if>
	            <c:if test="${article.type == 2 }">
	            <c:set var="url" value="'${article.content }'"/>
	            	<a onClick="newsHref(${url})" class="item"><img src="${article.head_url }"></a>
	            </c:if>
	            </c:forEach>
	            </c:if>
	        </div>
	        </c:if>
	        <!-- 首页轮播 end -->
	        <!-- 资讯列表 start -->
	        <c:if test="${block.id != 1 }">
	        <c:if test="${not empty list[block.id-1] }">
	        <div class="m_baoliao w">
	  			<div class="baoliao_title"><span>${block.name }</span><em></em></div>
	    		<div class="baoliao_list">
	    			<!-- 模块下的内容 start -->
	    			<c:forEach var="article" items="${list[block.id-1] }">
	    			<c:if test="${article.type == 1 }">
	    			<a onClick="news(${article.id})">
	        			<div class="baoliao_content">
	           				<div class="bl_img"><img src="${article.head_url }" /></div>
	            			<div class="bl_right">
	                			<div class="bl_title">${article.title }</div>
	                			<div class="bl_note">${article.summary }</div>
	            			</div>
	        			</div> 
	       			 </a>
	       			 </c:if>
	       			 <c:if test="${article.type == 2 }">
	       			 <c:set var="url" value="'${article.content }'"/>
	       			 <a onClick="newsHref(${url})">
	        			<div class="baoliao_content">
	           				<div class="bl_img"><img src="${article.head_url }" /></div>
	            			<div class="bl_right">
	                			<div class="bl_title">${article.title }</div>
	                			<div class="bl_note">${article.summary }</div>
	            			</div>
	        			</div> 
	       			 </a>
	       			 </c:if>
	       			 <!-- 模块下的内容 end -->
	       			 </c:forEach>
	    		</div>
	   			<!-- <div class="bl_more"><a onClick="newsList()">查看更多</a></div> -->
	  		</div>
	  		</c:if>
	  		</c:if>
	  		<!-- 资讯列表 end -->
		</div>
		</c:forEach>
		</c:if>
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