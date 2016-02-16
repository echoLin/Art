<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="author" content="m.178hui.com" />
    <meta name="applicable-device" content="mobile" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <title>定制时间轴</title>
    <link rel="stylesheet" type="text/css" href="/Art/mall/css/normalize.css" />
	<link href='http://fonts.useso.com/css?family=Dosis:300,400,500,600,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="/Art/mall/css/base.css">
    <link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
    <link href="/Art/mall/css/order.css" rel="stylesheet" type="text/css">
    <script src="/Art/mall/js/jquery-1.8.3.min.js"></script>

    <script>
        $(window).load(function() {
            $("#status").fadeOut();
            $("#preloader").delay(350).fadeOut("slow");
        })
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".login_out").click(function(){
                layer.confirm('您确定要退出吗？',  {skin: 'layui-layer-molv',offset: '30%'}, function(index){
                    layer.close(index);
                    layer.msg('拜拜！欢迎下次光临！', {shift: 6, time: 1500},function(){
                        window.location='';
                    });
                });
            });
        });
    </script>
    <script>
  function modify_payment(){
	
	  
	  alert("怕不怕！");
      	
    	
  }
</script>

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

    <!--header 开始-->
    <header>
        <div class="header" style="background:#FFD700"> 
        
        <a class="new-a-back" href="javascript:history.back();"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
        <h2>定制阶段时间轴</h2>
           
		<div class="header_right shaixuan" style="color:white; margin-top: 3px;font-size: 16;" ><a href="/Art/mall/jsp/artMall/shop/addpayment?order_id=${order_id }&shop_id=${shop_id}">添加</a></div>             
        
        </div>
    </header>
    <!--header 结束-->
    
    <div class="htmleaf-container" >
	

	<div class="container">

			<c:if test="${not empty paymentList }">
			
			<c:forEach var="payment" items="${paymentList }">

			<div id="timeline">
				<div class="timeline-item">
					<div class="timeline-icon">
						<img src="/Art/mall/images/star.svg" alt="">
					</div>
					
								
					
					<div class="timeline-content  ">
					
					
						<h2>支付单号：${payment.id}</h2>
						<p>
						
						<table style="width:100%">
							<tr>
  							<td>交稿内容：${payment.remark}</td>
							</tr>
							<tr>
  							<td>艺术商店：${payment.order.shop.name }</td>
							</tr>
							<tr>
  							<td>价格：${ payment.price}</td>
							</tr>
							<tr>
							<td>订单号：${payment.order.id }</td>
							</tr>
							
						</table>
	
 
							
						</p>
						
						
						
					</div>
					
					
				</div>

			</div>
			
			</c:forEach>
			
			</c:if>
	

	</div>



</div>
</body>
</html>


