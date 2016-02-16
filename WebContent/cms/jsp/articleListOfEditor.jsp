<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>articleListOfEditor</title>
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
		            			<th>标题</th>
		            			<th>模块</th>
		            			<th>主编</th>
		            			<th>费用</th>
		            			<th>上线时间</th>
		            			<th>下线时间</th>
		     					<th>创建时间</th>
		            			<th class='actions'>操作</th>
		            		</tr>
		            	</thead>
		            	<tbody>
		            	<c:if test="${not empty list }">
		            		<c:forEach var="article" items="${list }">
		            		<tr class='active'>
		            			<td>${ article.title }</td>
		            			<td>${ article.block.name }</td>
		            			<td>${ article.chief_editor.realname }</td>
		            			<td>${ article.price }</td>
		            			<td>${ article.up_time }</td>
		            			<td>${ article.down_time }</td>
		            			<td>${ article.time }</td>
		            			<td class='action'>
		            				<c:if test="${article.status == 1 || article.status == 3 }">
			            			<a>
			            				<button class='btn btn-warning' onClick=editArticle(${article.id})>
				                    	<i class='icon-pencil'>编辑</i>
				                    	</button>
				                  	</a>
				                  	</c:if>
				                  	<a>
				                  		<button class='btn btn-success' onClick=previewArticle(${article.id})>
				                    	<i class='icon-eye-open'>预览</i>
				                    	</button>
				                  	</a>
				                  	<c:if test="${article.status == 1 }">
				                 	 <a>
				                 	 	<button class='btn btn-info' onClick=submitArticle(${article.id})>
				                    	<i class='icon-share'>提交</i>
				                    	</button>
				                  	</a>
				                  	</c:if>
				                  	<c:if test="${article.status == 1 }">
				                  	<a>
				                  		<button class='btn btn-danger' onClick=deleteArticle(${article.id})>
				                    	<i class='icon-trash'>删除</i>
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
		                <a onClick=frontPage()>上一页</a>
		              </li>
		              <li class='active'>
		                <a>${page }</a>
		              </li>
		              <li>
		                <a>/</a>
		              </li>
		              <li class='active'>
		              	<a id="pageNum">${pageNum }</a>
		              </li>
		              <li>
		                <a onClick=nextPage()>下一页</a>
		              </li>
		            </ul>
		        </div>
		</div>
</body>