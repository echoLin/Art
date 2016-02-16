<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>订单发货</title>

<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/user.css" rel="stylesheet" type="text/css">
<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>
<script src="/Art/mall/layer/layer.js"></script>

<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
})
</script>
</head>

<script>
  function modify_express(){
	  
	
	var orderid=${id};
	var shop_id=${shop_id};
	var backpage="/Art/mall/jsp/artist/shop/shoporder/orderdetail?id=";
	backpage=backpage+orderid+"&shop_id="+shop_id;
	
	
    var new_express_company = $("input[name='new_express_company']").val();
    var new_tracking_number = $("input[name='new_tracking_number']").val();

    
    var expresscompanyReg=!!new_express_company.match(/^([a-z]*)+$/); 
    var trackingnumberReg=!!new_tracking_number.match(/^([0-9]*)+$/);

   
    if(expresscompanyReg==false){
        alert("请输入有效的快递公司名称");
      }
      if(trackingnumberReg==false){
        alert("快递单格式错误，快递单号只能有数字组成");
      }
      
      if(expresscompanyReg==true && trackingnumberReg==true){
      	
      	$.post(
      			"/Art/mall/jsp/artist/shop/shoporder/modify_express.json",
      			{
      				express_company:new_express_company,
      				tracking_number:new_tracking_number,
      				id:orderid,
      				shop_id:shop_id
      			},
      			function(data){
      				if(data.errno==0)
      					window.location.href=backpage;
      				else
      					alert(data.data);
      	});
      	alert("发货单填写成功。");
      }
    
    
  }
</script>
<body>
<div class="mobile">
	<!--页面加载 开始-->
  <div id="preloader">
    <div id="status">
      <p class="center-text"><span>拼命加载中···</span></p>
    </div>
  </div>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <header>
    <div class="header"> 
    <a class="new-a-back" href="javascript:history.back();">
     <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>订单议价修改</h2> 
      <div class="header_right shaixuan" style="color:white" onclick="modify_express()">保存</div>
    </div>
  </header>
    <div class="user_nav_list w" style="background-color:#f5f5f5">
    	<p>请填写您所寄货的快递公司 ：如中通快递</p>
        <input type="text" value="zhongtongkuaidi" name="new_express_company">
        
      	<p>请填写您所寄货的快递单号 </p>
        <input type="text" value="368998630864" name="new_tracking_number">
    </div>
</div>
</body>
</html>