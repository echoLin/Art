<%@page language="java" import="java.util.*,cn.edu.xmu.entity.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>lotList</title>
</head>
<body>
<div class='panel panel-default'>
			<div class='panel-heading'>
				<i class='icon-beer icon-large'></i>
			</div>
			<!-- <div class='panel-body filter'></div> -->
				
				<!-- list Panel -->
				<div id='listPanel'>
					<!-- search row -->
		            <!-- search row end -->
		            <!-- table -->
		            <table class='table'>
		            	<thead>
		            		<tr>
                                <th>拍卖品</th>
		            			<th>申请时间</th>
		            			<th>申请人</th>
		            			<th>作品类别</th>
		            			<th class='actions'>操作</th>
		            		</tr>
		            	</thead>
		            	<tbody>
		            	<c:if test="${not empty list }">
		            		<c:forEach var="lot" items="${list }">
		            		<tr class='active'>		            		
		            			<td>${ lot.artwork.name }</td>
		            			<td>${ lot.time }</td>
		            			<td>${ lot.artwork.shop.artist.real_name }</td>
		            			<td>${ lot.artwork.category.name }</td>
		            			<td class='action'>
				                  	<a>
				                  		<button class='btn btn-success' onclick=viewDetailsOfLot(${lot.id})>
				                    	<i class='icon-eye-open'>查看详情</i>
				                    	</button>
				                  	</a>
				                  	<c:if test="${lot.is_passed == 0 }">
				                 	 <a>
				                 	 	<button class='btn btn-primary' onClick=passLot(${lot.id})>
				                    	<i class='icon-ok'>通过</i>
				                    	</button>
				                    </a>
				                    <a>
				                  		<button class='btn btn-danger' onClick=failLot(${lot.id})>
				                    	<i class='icon-remove'>不通过</i>
				                    	</button>
				                  	</a>
				                  	</c:if>
		            			</td>
		            		</tr>
		            		</c:forEach>
		            	</c:if>
		            	</tbody>
		            </table>
		            <!-- table end -->
				</div>
				<!-- list panel end -->
				
				<div class='panel-footer' id='panel-footer'>
		            <ul class='pagination pagination-sm'>
		              <li>
		                <a onclick=frontPage()>上一页</a>
		              </li>
		              <li class='active'>
		                <a>${page} </a>
		              </li>
		              <li>
		                <a>/</a>
		              </li>
		              <li>
		                <a id="pageNum" class='active'>${pageNum} </a>
		              </li>
		              <li>
		                <a onclick=nextPage()>下一页</a>
		              </li>
		            </ul>
		            <!-- 
		            <c:if test="${not empty pageNum}">
		            	<input id="pageNum" type="text" value="${pageNum}" style="display:''"/>
		            </c:if>
		             -->
		        </div>
		</div>
</body> 
