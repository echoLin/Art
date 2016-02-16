<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>竞拍列表</title>
</head>
<body>
<div class="ui-tab-content" id="itemList">
	<c:if test="${not empty lotList }">
	<c:forEach var="lot" items="${lotList }">
	<a onClick=lotInfo(${lot.id})>
		<div class="baoliao_content">
		    <div class="bl_img"><img src="${lot.artwork.head_url }" /></div>
		    <div class="bl_right">
		        <div class="bl_title">
		        <span class="bl_type">
		        	<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set> 
		        	<c:choose>
					<c:when test="${nowDate-lot.start_time.time >= 0 && nowDate-lot.end_time.time <=0}"> 
					正在进行 
					</c:when>
					<c:otherwise>
					即将开始
					</c:otherwise>
					</c:choose>
		        </span>
		        <span class="bl_type" style="background-color:#53bf1e;">${ lot.artwork.category.name}</span>
		        ${ lot.artwork.name}</div>
		        <div class="bl_tag">
		            <div class="bl_price">起拍价：</div>
		            <c:set var="price" value="￥${lot.price }"/>
		            <div class="bl_price">${ price}</div>
		            <c:set var="createYear" value="创作年份：${lot.artwork.create_year }"/>
		            <div class="bl_time">${ createYear}</div>
		            <c:set var="artist" value="艺术家：${lot.artwork.shop.artist.real_name }"/>
		            <div class="bl_mall">${ artist }</div>
		        </div>
		    </div>
		</div> 
	</a>
	</c:forEach>
	</c:if>
</div>
<div class="bl_more" id="moreBtn"><a onClick=loadMoreLot()>加载更多</a></div>
</body>
</html>