<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>edit</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>
<script type="text/javascript" src="/Art/cms/js/edit/edit.js"></script>	
</head>
<body>

	<!-- content top -->
	<section id='tools'>
		<ul class='breadcrumb' id='breadcrumb'>
			<li class='title'>资讯编辑</li>
			<li><a ><button id="draft" type="button"
						style="background-color: transparent; border: 0; color:#1ABC9C" onClick=draft()>草稿箱</button></a></li>
			<li><a ><button id="nonAudit" type="button"
						style="background-color: transparent; border: 0" onClick=nonAudit()>未审核</button></a></li>
			<li><a ><button id="modify" type="button"
						style="background-color: transparent; border: 0" onClick=modify()>待修改</button></a></li>
			<li><a ><button id="auditedPassed" type="button"
						style="background-color: transparent; border: 0" onClick=auditedPassed()>审核通过</button></a></li>
			<li><a ><button id="auditedFailed" type="button"
						style="background-color: transparent; border: 0" onClick=auditedFailed()>审核未通过</button></a></li>
			<li><a ><button id="add" type="button"
						style="background-color: transparent; border: 0" onClick=add()>添加资讯</button></a></li>
		
		</ul>
	</section>
	<!-- content top end-->

	<!-- content  -->
	<div id='content'>
	
	</div>
	<!-- content end-->
</body>
</html>
