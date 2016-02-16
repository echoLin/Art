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
<div class="ui-tab-content" id='itemList'>
	<c:if test="${not empty artistList }">
	<c:forEach var="artist" items="${artistList }">
	<a onClick=artistInfo(${artist.id})>
		<div class="baoliao_content">
		    <div class="bl_img">
		    	<img src="${artist.user.avatar }" />
		    </div>
		    <div class="bl_right">
		        <div class="bl_title"><span class="bl_type" style="background-color:#00bb9c;">${artist.user.username }</span>${artist.real_name }</div>
		        <div class="bl_note">${artist.introduction}</div>
		    </div>
		</div> 
	</a>
	</c:forEach>
	</c:if>

</div>
<div class="bl_more" id='moreBtn'><a onClick=loadMoreArtist()>加载更多</a></div>
</body>
</html>