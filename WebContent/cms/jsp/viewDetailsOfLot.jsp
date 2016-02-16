<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="/Art/cms/css/viewDetailsOfArtist.css" />
<title>拍卖品详情</title>
</head>
<body class="main page">
  
    <table>
       <tr>
          <td class="listName">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</td>
          <td class="listContent">${ lot.artwork.name }</td>
       </tr>
       <tr>
          <td class="listName">类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
          <td class="listContent">${ lot.artwork.category.name }</td>
       </tr>
       <tr>
          <td class="listName">作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者：</td>
          <td class="listContent">${ lot.artwork.shop.artist.real_name }</td>
       </tr>
       <tr>
          <td class="listName">起拍时间：</td>
          <td class="listContent">${ lot.start_time }</td>
       </tr>
       <tr>
          <td class="listName">结束时间：</td>
          <td class="listContent">${ lot.end_time }</td>
       </tr>
       <tr>
          <td class="listName">详&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情：</td>
          <td class="listContent">${ lot.artwork.content }</td>
       </tr>
     </table>



</body>
</html>