<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>audit</title>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script src="/Art/cms/js/audit.js" type="text/javascript"></script>
</head>
<body>

	<!-- content top -->
	<section id='tools'>
		<ul class='breadcrumb' id='breadcrumb'>
			<li class='title'>资讯审核</li>
			<li><a ><button id="nonAudit" type="button"
						style="background-color: transparent; border: 0" onClick=nonAudit()>待审核</button></a></li>
			<li><a ><button id="needModify" type="button"
						style="background-color: transparent; border: 0" onClick=needModify();>需修改</button></a></li>
			<li><a ><button id="auditedPassed" type="button"
						style="background-color: transparent; border: 0" onCLick=auditedPassed()>审核通过</button></a></li>
			<li><a ><button id="auditedFailed" type="button"
						style="background-color: transparent; border: 0" onClick=auditedFailed()>审核未通过</button></a></li>
			<li><a ><button id="preBlock" type="button"
						style="background-color: transparent; border: 0" onClick=preBlock()>版面编排</button></a></li>
		
		</ul>
	</section>
	<!-- content top end-->

	<!-- content  -->
	<div id='content'>
	
	</div>
	<!-- content end-->
</body>
</html>
