<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>艺术家作品列表</title>
</head>
<body>
<c:choose>
<c:when test="${not empty artworkList }">
<div class="ui-tab-content" id="itemList">
	<c:forEach var="artwork" items="${artworkList }">
	<a onClick=artworkInfo(${artwork.id})>
		<div class="baoliao_content">
		    <div class="bl_img"><img src="${artwork.head_url }" /></div>
		    <div class="bl_right">
		        <div class="bl_title">
		        <span class="bl_type">
		        <c:choose>
		        	<c:when test="${artwork.type == 1 }">非卖品</c:when>
		        	<c:when test="${artwork.type == 2 }">成品</c:when>
		        	<c:when test="${artwork.type == 3 }">订制品</c:when>
		        	<c:when test="${artwork.type == 4 }">拍卖品</c:when>
		        </c:choose>
		        </span>
		        <span class="bl_type" style="background-color:#53bf1e;">${ artwork.category.name}</span>
		        ${ artwork.name}
		        </div>
		        <div class="bl_tag">
		        	<c:if test="${artwork.type==2}">
		            <div class="bl_price">价格：</div>
		            <c:set var="price" value="￥${artwork.price }"/>
		            <div class="bl_price">${ price}</div>
		            </c:if>
		            <c:set var="createYear" value="创作年份：${artwork.create_year }"/>
		            <div class="bl_time">${ createYear}</div>
		            <c:set var="artist" value="艺术家：${artwork.shop.artist.real_name }"/>
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
<div class="bl_more"><a>您还没有收藏的店铺哦~</a></div>
</c:otherwise>
</c:choose>
</body>
</html>