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
<div class="ui-tab-content" id="itemList">
	<c:if test="${not empty artworkList }">
	<c:forEach var="artwork" items="${artworkList }">
	<a onClick=artworkInfo(${artwork.id})>
		<div class="baoliao_content">
		    <div class="bl_img"><img src="${artwork.head_url }" /></div>
		    <div class="bl_right">
		        <div class="bl_title"><span class="bl_type" style="background-color:#53bf1e;">${ artwork.category.name}</span>${ artwork.name}</div>
		        <div class="bl_tag">
		            <div class="bl_price">价格：</div>
		            <c:set var="price" value="￥${artwork.price }"/>
		            <div class="bl_price">${ price}</div>
		            <c:set var="createYear" value="创作年份：${artwork.create_year }"/>
		            <div class="bl_time">${ createYear}</div>
		            <c:set var="artist" value="艺术家：${artwork.shop.artist.real_name }"/>
		            <div class="bl_mall">${ artist }</div>
		        </div>
		    </div>
		</div> 
	</a>
	</c:forEach>
	</c:if>
</div>
<div class="bl_more" id="moreBtn"><a onClick=loadMoreArtwork()>加载更多</a></div>
</body>
</html>