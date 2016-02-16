<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>艺术家店铺列表</title>
</head>
<body>
<c:choose>
<c:when test="${not empty shopList }">
	<div class="ui-tab-content" id="itemList">
		<c:forEach var="shop" items="${shopList }">
		<a onClick=shopInfo(${shop.id})>
			<div class="baoliao_content">
			    <div class="bl_img"><img src="${shop.head_url }" /></div>
			    <div class="bl_right">
			        <div class="bl_title">${shop.name }</div>
			        <div class="bl_note">${shop.introduction}</div>
			        <div class="bl_tag">
			           <%--  <div class="bl_price">Ta的店:</div>
			            <div class="bl_price">${shop.name }</div> --%>
			            <div class="bl_time">${shop.time }</div>
			            <div class="bl_mall">${shop.category.name }</div>
			        </div>
			    </div>
			</div> 
		</a>
		</c:forEach>
	</div>
	<div class="bl_more" id="moreBtn"><a onClick=loadMore()>加载更多</a></div>
</c:when>
<c:otherwise>
<div class="bl_more"><a>您还没有收藏的店铺哦~</a></div>
</c:otherwise>
</c:choose>
</body>
</html>