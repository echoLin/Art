<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<link href="/Art/bootstrap/css/bootstrap-fileinput.min.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
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
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/Art/mall/js/fileinput.js"></script>
<title>上传店铺头像</title>
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
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">上传店铺头像</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
	<!-- header 结束 -->
	<!-- content 开始 -->
	<div id="content" style="padding:20%;background-color:#f5f5f5;">
	<div id="kv-avatar-errors" class="center-block" style="width:100%;display:none"></div>
	<form class="text-center" method="post" enctype="multipart/form-data" id="${shop_id }">
	    <div class="kv-avatar center-block" style="width:200px">
	        <input id="avatar" name="avatar" type="file" class="file-loading">
	    </div>
	    <!-- include other inputs if needed and include a form submit (save) button -->
	</form>
	</div>
	</div>
	<!-- content 结束 -->
<!-- your server code `avatar_upload.php` will receive `$_FILES['avatar']` on form submission -->
 
<!-- the fileinput plugin initialization -->
<script>
var shop_id=$("form").attr("id");
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
});
var btnCust = '<button type="button" class="btn btn-default" title="Add picture tags" ' + 
    'onclick="alert(\'Call your custom code here.\')">' +
    '<i class="glyphicon glyphicon-tag"></i>' +
    '</button>'; 
$("#avatar").fileinput({
	uploadUrl:'/Art/mall/artist/shop/shop_avatar.json?shop_id='+shop_id+'',
    overwriteInitial: true,
    maxFileSize: 3000,
    showClose: false,
    showCaption: false,
    browseLabel: '',
    removeLabel: '',
    browseIcon: '<i class="glyphicon glyphicon-folder-open"></i>',
    removeIcon: '<i class="glyphicon glyphicon-remove"></i>',
    removeTitle: 'Cancel or reset changes',
    elErrorContainer: '#kv-avatar-errors',
    msgErrorClass: 'alert alert-block alert-danger',
    defaultPreviewContent: '<img src="/Art/images/avatar/default_avatar_male.jpg" alt="Your Avatar" style="width:160px">',
    layoutTemplates: {main2: '{preview} ' +  btnCust + ' {remove} {upload} {browse}'},
    allowedFileExtensions: ["jpg", "png", "gif"]
});
</script>
</body>
</html>