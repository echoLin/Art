<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class='no-js' lang='en'>
  <head>
    <meta charset='utf-8'>
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <title>艺术品定制网站后台管理系统</title>
    <meta content='art_cms_dashboard' name='echo'>
    <link href="/Art/bootstrap/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
    <link href="/Art/bootstrap/css/bootstrap-fileinput.min.css" rel="stylesheet" type="text/css" />
    <link href="/Art/cms/css/application-a07755f5.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.css" />
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.css" />
    <link href="img/favicon.ico" rel="icon" type="image/ico" />
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
  	<script type="text/javascript" src="/Art/bootstrap/js/bootstrap.js"></script>
  	<script type="text/javascript" src="/Art/bootstrap/js/bootstrap-select.min.js"></script>
  	<script type="text/javascript" src="/Art/bootstrap/js/bootstrap-fileinput.js"></script>
  	<!-- summer note -->
	<link rel="stylesheet" href="/Art/cms/css/summernote.css"/>
	<script type="text/javascript" src="/Art/cms/js/summernote.js"></script>
	<script type="text/javascript" src="/Art/cms/js/edit/mySummernote.js"></script>
  </head>
  <body class='main page'>
    <!-- top -->
    <div class='navbar navbar-default' id='navbar'>
      <a class='navbar-brand' href='#'>
        <i class='icon-beer'></i>
        Art-后台管理系统
      </a>
      <ul class='nav navbar-nav pull-right'>
        <li class='dropdown user'>
          <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
            <i class='icon-user'></i>
            	<strong>
				 	${admin.realname }
            	</strong>
            <b class='caret'></b>
          </a>
        </li>
      </ul>
    </div>
    <!-- top end -->
    
    	<!-- content  -->
	<div id='content' style="background-color:#bdc3c7; left:20px">
		<div class='panel panel-default' id='summernotePanel' style="display:''">
			<div class='panel-heading'>
				<i class='icon-beer icon-large'></i> 资讯编辑
				<c:if test="${not empty article_id }">
					<input class='form-control' id='article_id' name='article_id' type='hidden' value="${article_id }"/>
					<input class='form-control' id='article_url' name='article_url' type='hidden' value=""/>
				</c:if>
				<c:if test="${empty article_id }">
					<input class='form-control' id='article_id' name='article_id' type='hidden' value="0"/>
				</c:if>
				<div id="headDiv" style="display:none"></div>
				<div class='panel-tools'>
					<div class='btn-group' id='editGrp'>
						<a class='btn' data-toggle='toolbar-tooltip' href='#'
							title='Building'>
							  <button id="draftBtn" type="button" data-model="draftBtn" style="background-color:transparent;border:0">保存到草稿箱</button>
						</a>
						<a class='btn' data-toggle='toolbar-tooltip' href='#'
							title='Building'>
						<button id="previewBtn" type="button" data-model="previewBtn" style="background-color:transparent;border:0">预览</button>
						</a>
						<a class='btn' data-toggle='toolbar-tooltip' href='#'
							title='Building'>
							 <button id="submitBtn" type="button" data-model="submitBtn" style="background-color:transparent;border:0" >提交审核</button>
						</a>
						<a class='btn' data-toggle='toolbar-tooltip' href='#'
							title='Building'> 
							 <button id="notSaveBtn" type="button" data-model="notSaveBtn" style="background-color:transparent;border:0">不保存</button>
						</a>
					</div>
				</div>
			</div>

			<div class='panel-body filters' style="padding:5px">
			<div class='panel-heading'>
					<select class="selectpicker" id="type" data-style="btn-info" data-width="12%">
						<option value="0">文章类型</option>
						<option value="1">图+文/视频</option>
						<option value="2">图+链接</option>
					</select>
					<select class="selectpicker" id="charge" data-style="btn-primary" data-width="12%">
						<option value="0">是否收费</option>
						<option value="1">收费</option>
						<option value="2">不收费</option>
					</select>
					<select class="selectpicker" id="block" data-style="btn-warning" data-width="12%">
						<option value="0">模块</option>
						<c:if test="${not empty blockList }">
						<c:forEach var="block" items="${blockList }">
							<option value="${block.id}">${block.name }</option>
						</c:forEach>
						</c:if>
					</select>
				<div class="btn-group default" style="padding-right:10px">
					<span>上线时间：</span>
					<input id='update' type='datetime'/>
				</div>
				<div class="btn-group default" style="padding-right:10px">
					<span>下线时间：</span>
					<input id='downdate' type='datetime'/>
				</div>
				
				<div style="padding-top:10px">
					<input class='form-control' id='title' name='title' placeholder='标题' type='text'>
				</div>
				<div style="padding-top:10px">
					<input class='form-control' id='ref_url' name='summary' placeholder='跳转链接' type='text'>
				</div>
 				<div style="padding-top:10px">
					<input class='form-control' id='summary' name='summary' placeholder='摘要' type='text'>
				</div>
				<div style="padding-top:10px">
					<input id="input-id" type="file" class='file-preview-image' data-preview-file-type="text"/>
				</div>
			</div><!-- end of headin -->
			
			<!-- <div class='row' style="left:30px">
            </div> -->
			</div>
			<!-- edit Panel display none-->
		 		<div id="editPanel" style="padding-left:20px; padding-right:20px">
					<div class="summernote" id='summernote'>hello world</div>
				</div>
			<!-- edit Panel end -->
		</div>
	</div>
    <!-- content end -->
    
  </body>
</html>
