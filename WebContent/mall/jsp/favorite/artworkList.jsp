<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${not empty favoriteList }">
<div class="ui-tab-content" id="itemList">
	<c:forEach var="favorite" items="${favoriteList }">
	<a onClick=artworkInfo(${favorite.artwork.id})>
		<div class="baoliao_content">
		    <div class="bl_img"><img src="${favorite.artwork.head_url }" /></div>
		    <div class="bl_right">
		        <div class="bl_title"><span class="bl_type" style="background-color:#53bf1e;">${ favorite.artwork.category.name}</span>${ artwork.name}</div>
		        <div class="bl_tag">
		        	<c:if test="${favorite.artwork.type==2 || favorite.artwork.type==4 }">
		            <div class="bl_price">价格：</div>
		            <c:set var="price" value="￥${favorite.artwork.price }"/>
		            <div class="bl_price">${ price}</div>
		            </c:if>
		            <c:set var="createYear" value="创作年份：${favorite.artwork.create_year }"/>
		            <div class="bl_time">${ createYear}</div>
		            <c:set var="artist" value="艺术家：${favorite.artwork.shop.artist.real_name }"/>
		            <div class="bl_mall">${ artist }</div>
		        </div>
		    </div>
		</div> 
	</a>
	</c:forEach>
</div>
<div class="bl_more" id="moreBtn"><a onClick=loadMore()>加载更多</a></div>
</c:when>
<c:otherwise>
<div class="bl_more"><a>您还没有收藏的艺术品哦~</a></div>
</c:otherwise>
</c:choose>
</body>
</html>