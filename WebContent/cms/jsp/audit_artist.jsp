<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>audit_artist</title>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet"/>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script src="/Art/cms/js/audit_artist.js" type="text/javascript"></script>
</head>
<body>
<!-- content top -->
	<section id='tools'>
		<ul class='breadcrumb' id='breadcrumb'>
			<li class='title'>艺术家审核</li>
			<li><a ><button id="nonAudit" type="button"
						style="background-color: transparent; border: 0">待审核</button></a></li>
			<li><a ><button id="auditedPassed" type="button"
						style="background-color: transparent; border: 0">审核通过</button></a></li>
			<li><a ><button id="auditedFailed" type="button"
						style="background-color: transparent; border: 0">审核未通过</button></a></li>
		
		</ul>
	</section>
	<!-- content top end-->

	<!-- content  -->
	<div id='content'>
		
	</div>
	<!-- content end-->
</body>
</html>