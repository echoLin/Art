<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<link href="/Art/bootstrap/css/bootstrap-fileinput.min.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/bootstrap/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
<!-- some CSS styling changes and overrides -->
<style>
.kv-avatar .file-preview-frame,.kv-avatar .file-preview-frame:hover {
    margin: 0;
    padding: 0;
    border: none;
    box-shadow: none;
    text-align: center;
}
.kv-avatar .file-input {
    display: table-cell;
    max-width: 220px;
}
</style>
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/Art/mall/js/fileinput.js"></script>
<script type="text/javascript" src="/Art/bootstrap/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="/Art/mall/js/uploadArtwork.js"></script>
<link rel="stylesheet" href="/Art/mall/css/summernote.css"/>
<script type="text/javascript" src="/Art/mall/js/summernote.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.css" />
<title>上传作品</title>
</head>
<body>
<div class="mobile">
	<!--页面加载 开始-->
  <div id="preloader">
    <div id="status">
      <p class="center-text"><span>拼命加载中···</span></p>
    </div>
  </div>
  <!--页面加载 结束--> 
    <!-- header 开始 -->
    <div class="header" id="header">
		<a class="new-a-back" href="javascript:history.back();">
			<span><img src="/Art/mall/images/iconfont-fanhui.png"></span>
		</a>
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">上传作品</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
	<!-- header 结束 -->
	<!-- content 开始 -->
	<c:if test="${artwork_id!=0 }">
	<div id="content" style="padding:5%;background-color:#f5f5f5;">
		<input class='form-control' id='artwork_id' name='artwork_id' value="${artwork_id }" type='hidden'/>
		<input class='form-control' id='artwork_head_url' name='artwork_head_url' value="0" type='hidden'/>
		<input class='form-control' id='shop_id' name='shop_id' value="${shop_id }" type='hidden'/>
		<div style="padding-top:10px">
			<select class="selectpicker" id="typeList" data-style="btn-primary" data-width="100%">
				<option value="0">作品类型</option>
				<c:if test="${artwork.type==1 }"><option value="1" selected="selected">非卖品</option></c:if><option value="1">非卖品</option>
				<c:if test="${artwork.type==1 }"><option value="2" selected="selected">成品</option></c:if><option value="2">成品</option>
			</select>
		</div>
		<div style="padding-top:10px">
			<select class="selectpicker" id="categoryList" data-style="btn-info" data-width="100%">
			</select>
		</div>
		<div style="padding-top:10px">
			<label style="padding:0px;">作品名称:</label>
			<input class='form-control' id='name' name='name' placeholder='${artwork.name }' type='text'>
		</div>
		<div style="padding-top:10px">
			<label style="padding:0px;">创作时间:</label> 
			<input class='form-control' id='create_time' type='date' value="${artwork.create_time }">
		</div>
		<div id='price_div' style="padding-top:10px">
			<label style="padding:0px;">价格:</label> 
			<input class='form-control' id='price' type='number' value="${artwork.price }">
		</div>
		<!-- 作品头像 开始-->
		<div style="padding-top:10px">
			<div id="kv-avatar-errors" class="center-block" style="width:100%;display:none"></div>
			<form class="text-center" method="post" enctype="multipart/form-data">
			    <div class="kv-avatar center-block" style="width:200px">
			        <input id="avatar" name="file_data" type="file" class="file-loading">
			    </div>
			</form>
		</div>
		<!-- 作品头像 结束 -->
		<!-- 介绍 开始 -->
		<div id="editPanel" style="padding-top:10px;">
			<div class="summernote" id='summernote'>hello world</div>
		</div>
		<!-- 介绍 结束 -->
		<div style="padding-top:10px;">
			<button type='button' class='btn btn-warning' onClick=saveArtwork()>保存</button>
		</div>
	</div>
	</c:if>
	
	<c:if test="${artwork_id==0 }">
	<div id="content" style="padding:5%;background-color:#f5f5f5;">
		<input class='form-control' id='artwork_id' name='artwork_id' value="${artwork_id }" type='hidden'/>
		<input class='form-control' id='artwork_head_url' name='artwork_head_url' value="0" type='hidden'/>
		<input class='form-control' id='shop_id' name='shop_id' value="${shop_id }" type='hidden'/>
		<div style="padding-top:10px">
			<select class="selectpicker" id="typeList" data-style="btn-primary" data-width="100%">
				<option value="0">作品类型</option>
				<option value="1">非卖品</option>
				<option value="2">成品</option>
			</select>
		</div>
		<div style="padding-top:10px">
			<select class="selectpicker" id="categoryList" data-style="btn-info" data-width="100%">
			</select>
		</div>
		<div style="padding-top:10px">
			<label style="padding:0px;">作品名称:</label>
			<input class='form-control' id='name' name='name' placeholder='作品名称' type='text'>
		</div>
		<div style="padding-top:10px">
			<label style="padding:0px;">创作时间:</label> 
			<input class='form-control' id='create_time' type='date'>
		</div>
		<div id='price_div' style="padding-top:10px">
			<label style="padding:0px;">价格:</label> 
			<input class='form-control' id='price' type='number'>
		</div>
		<!-- 作品头像 开始-->
		<div style="padding-top:10px">
			<div id="kv-avatar-errors" class="center-block" style="width:100%;display:none"></div>
			<form class="text-center" method="post" enctype="multipart/form-data">
			    <div class="kv-avatar center-block" style="width:200px">
			        <input id="avatar" name="file_data" type="file" class="file-loading">
			    </div>
			</form>
		</div>
		<!-- 作品头像 结束 -->
		<!-- 介绍 开始 -->
		<div id="editPanel" style="padding-top:10px;">
			<div class="summernote" id='summernote'>hello world</div>
		</div>
		<!-- 介绍 结束 -->
		<div style="padding-top:10px;">
			<button type='button' class='btn btn-warning' onClick=saveArtwork()>保存</button>
		</div>
	</div>
	</c:if>
	<!-- content 结束 -->
</div>
</body>
</html>