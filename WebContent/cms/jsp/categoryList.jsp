<%@page language="java" import="java.util.*,cn.edu.xmu.entity.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>categoryList</title>
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
                                <th>类别名称</th>
		            			<th>状态</th>
		            			<th class='actions'>操作</th>
		            		</tr>
		            	</thead>
		            	<tbody>
		            	<c:if test="${not empty list }">
		            		<c:forEach var="category" items="${list }">
		            		<tr class='active'>		            		
		            			<td>${ category.name }</td>
		            			<td>启用</td>
		            			<td class='action'>
				                    <a>
				                  		<button class='btn btn-danger' onClick=deleteCategory(${category.id})>
				                    	<i class='icon-remove'>停用</i>
				                    	</button>
				                  	</a>
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
		            	<button class='btn btn-primary' onClick=addCategory() style="float:right">
				        <i class='icon-ok'>添加</i>
				        </button>
		          

 
		        </div>
		</div>
</body> 
