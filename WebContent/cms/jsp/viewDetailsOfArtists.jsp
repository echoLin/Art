<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="/Art/cms/css/viewDetailsOfArtist.css" />
<title>艺术家详情</title>
</head>
<body class="main page">
  
    <table>
       <tr>
          <td class="listName">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
          <td class="listContent">${ artist.real_name }</td>
       </tr>
       <tr>
          <td class="listName">艺术方向：</td>
          <td class="listContent">${ artist.art_direction }</td>
       </tr>
       <tr>
          <td class="listName">教育程度：</td>
          <td class="listContent">${ artist.education }</td>
       </tr>
       <tr>
          <td class="listName">个人简介：</td>
          <td class="listContent">${ artist.introduction }</td>
       </tr>
     </table>



</body>
</html>