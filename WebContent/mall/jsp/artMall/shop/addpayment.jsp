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
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.css" />

<script>
        $(window).load(function() {
            $("#status").fadeOut();
            $("#preloader").delay(350).fadeOut("slow");
        })
</script>
<script>
  function add_payment(){
	
	  
	    var payment_content=$("input[name='content']").val();
	    var payment_price=$("input[name='price']").val();
	    
		var order_id=${order_id};
		var shop_id=${shop_id};
		var backpage="/Art/mall/jsp/artMall/shop/customization?order_id=";
		backpage=backpage+order_id+"&shop_id="+shop_id;
	    
	    
	    if(payment_content==null||payment_price==null){
	      alert("填写内容不能为空");
	    }else{
	    	
	    	$.post(
	    			"/Art//mall/jsp/artist/shop/shoporder/add_payment.json",
	    			{
	    				mark:payment_content,
	    				price:payment_price,
	    				order_id:order_id,
	    				shop_id:shop_id
	    			},
	    			function(data){
	    				if(data.errno==0)
	    					window.location.href="/Art/mall/index";
	    				else
	    					alert(data.data);
	    	});
	    	alert("订单修改成功");
	    }
      	
    	
  }
</script>

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
		<a class="new-a-back" href="/Art/mall/jsp/artMall/shop/customization?order_id=${order_id}&shop_id=${shop_id}">
			<span><img src="/Art/mall/images/iconfont-fanhui.png"></span>
		</a>
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">艺术定制</div>
		<div class="head_right" style="top:8px;">
			<a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png" width="30"></a>
		</div>
	</div>
	<!-- header 结束 -->
	
	<!-- content 开始 -->

	
	<div id="content" style="padding:5%;background-color:#f5f5f5;">
		
		
		<div style="padding-top:10px">
			<label style="padding:0px;">定制阶段交稿内容:</label>
			<input class='form-control' id='content' name='content' type='text'>
		</div>

		<div id='price_div' style="padding-top:10px">
			<label style="padding:0px;">阶段价格:</label> 
			<input class='form-control' id='price' name='price' type='text' >
		</div>
		<!-- 作品头像 开始-->
	
		<div style="padding-top:10px;">
			<button type='button' class='btn btn-warning' onClick=add_payment()>保存</button>
		</div>
	</div>
	
	

	<!-- content 结束 -->
</div>
</body>
</html>