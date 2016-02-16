<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收藏艺术家</title>
</head>
<body>
<c:choose>
<c:when test="${not empty favoriteList }">
	<div class="ui-tab-content" id='itemList'>
		<c:forEach var="favorite" items="${favoriteList }">
		<a onClick=artistInfo(${favorite.artist.id})>
			<div class="baoliao_content">
			    <div class="bl_img">
			    	<img src="${favorite.artist.user.avatar }" />
			    </div>
			    <div class="bl_right">
			        <div class="bl_title"><span class="bl_type" style="background-color:#00bb9c;">${favorite.artist.user.username }</span>${favorite.artist.real_name }</div>
			        <div class="bl_note">${favorite.artist.introduction}</div>
			    </div>
			</div> 
		</a>
		</c:forEach>
	</div>
	<div class="bl_more" id='moreBtn'><a onClick=loadMore()>加载更多</a></div>
</c:when>
<c:otherwise>
<div class="bl_more"><a>您还没有收藏的艺术家哦~</a></div>
</c:otherwise>
</c:choose>
</body>
</html>