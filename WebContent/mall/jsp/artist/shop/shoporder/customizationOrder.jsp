<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>定制订单</title>
<link href=" /Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/order.css" rel="stylesheet" type="text/css"/>
<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>

<script>
        $(window).load(function() {
            $("#status").fadeOut();
            $("#preloader").delay(350).fadeOut("slow");
        });
        

        
		function fit_screen(){
			
			
	
			if($("#px832kcdw").length >0){
				
				
				var x=document.getElementById("px832kcdw");
				$("#px832kcdw").width($("#px832kcdw").width() - 180);
				
			}
			else{
				alert("不存在！");
			}
	
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
    <div class="header" id="head"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>订单管理</h2>
      <div class="header_right shaixuan"><a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png"></a></div>
    </div>
  </header>
  <!--header 结束-->



    <div class="user_nav_list w">
    	<ul>

            <li>
            	<a href="/Art/mall/jsp/artist/shop/shoporder/orderlist?shop_id=${shop_id }&type=3&status=1&page=1">
                	<div class="u_nav_icon fukuan"></div>
                    <div class="u_nav_name">未首付订单</div>
                    <div class="nt_icon"></div>
              </a>
            </li>



            
            <li>
            	<a href="/Art/mall/jsp/artist/shop/shoporder/orderlist?shop_id=${shop_id }&type=3&status=2&page=1">
                	<div class="u_nav_icon fahuo"></div>
                    <div class="u_nav_name">已首付订单</div>
                    <div class="nt_icon"></div>
              </a>
            </li>
            
            
            <li>
            	<a href="/Art/mall/jsp/artist/shop/shoporder/orderlist?shop_id=${shop_id }&type=3&status=3&page=1">
                	<div class="u_nav_icon fahuo"></div>
                    <div class="u_nav_name">已完成订单</div>
                    <div class="nt_icon"></div>
              </a>
            </li>
            
            
            <li>
            	<a href="/Art/mall/jsp/artist/shop/shoporder/orderlist?shop_id=${shop_id }&type=3&status=5&page=1">
                	<div class="u_nav_icon fahuo"></div>
                    <div class="u_nav_name">已交付订单</div>
                    <div class="nt_icon"></div>
              </a>
            </li>
            
            


        </ul>


        </div>


</div>

</body>
</html>