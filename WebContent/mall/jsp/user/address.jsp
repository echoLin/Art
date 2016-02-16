<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>address</title>

<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/address.css" rel="stylesheet" type="text/css"  />
<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>
<script src="/Art/mall/layer/layer.js"></script>
<script src="/Art/mall/js/address.js"></script>


<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
});
</script>

</head>

<body>
<div class="mobile" style="background-color:#f5f5f5">
	<!--页面加载 开始-->
  <div id="preloader">
    <div id="status">
      <p class="center-text"><span>拼命加载中···</span></p>
    </div>
  </div>
  <!--页面加载 结束--> 
  <!--header 开始-->
  <header>
    <div class="header"> <a class="new-a-back" href="/Art/mall/jsp/user/user"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>收货地址</h2>
      <div class="header_right shaixuan" style="color:white" >
         <a href="/Art/mall/jsp/user/addressInfo?tag=0&id=0">添加</a>                     
      </div>
    </div>
  </header>
  <!--header 结束-->

  <!-- 显示默认地址start -->
    <c:if test="${not empty list}">
      <c:forEach var="address" items="${list}">   
           <c:if  test="${ user.address.id == address.id }">     
             <div class="address_list" >  
               <div class="first_row">
                 <div class="first_row_left"> ${ address.receiver_name }</div>
                 <div class="first_row_right">${ address.receiver_telephone }</div>
               </div>
      
               <div class="second_row">
                 <div>${ address.province }  ${ address.city } ${ address.district }</div>
                 <div>${ address.detailDescription }</div>
               </div>
      
               <div class="third_row">
          
                  <div class="default">
                    <input  id = "modifyStatus" type="checkbox" class="default_img" checked = true onclick = "modifyStatus(${ address.id })"/>默认
                  </div>
                               
                 <div class="edit">
                   <img src="/Art/mall/images/dingdan.png" class="img" onclick = "editAddress(${ address.id })" >
                   <span >编辑</span>
                 </div>
                 
                 <div class="delete">
                    <img  src="/Art/mall/images/u_close.png" class="img" onclick = "deleteAddress(${ address.id })">
                    <span>删除</span>
                 </div>      
               </div>
             </div>
          </c:if> 
      </c:forEach>
    </c:if>
    <!-- 显示默认地址 end -->
    
    <!-- 显示非默认地址start -->
    <c:if test="${not empty list}">
      <c:forEach var="address" items="${list}">  
           <c:if  test="${ user.address.id != address.id }">     
             <div class="address_list" >  
               <div class="first_row">
                 <div class="first_row_left"> ${ address.receiver_name }</div>
                 <div class="first_row_right">${ address.receiver_telephone }</div>
               </div>
      
               <div class="second_row">
                 <div>${ address.province }  ${ address.city } ${ address.district }</div>
                 <div>${ address.detailDescription }</div>
               </div>
      
               <div class="third_row">
          
                  <div class="default">
                    <input  id = "modifyStatus" type="checkbox" class="default_img" onclick = "modifyStatus(${ address.id })"/>默认
                  </div>
                               
                 <div class="edit">
                   <img src="/Art/mall/images/dingdan.png" class="img" onclick = "editAddress(${ address.id })" >
                   <span >编辑</span>
                 </div>
                 
                 <div class="delete">
                    <img  src="/Art/mall/images/u_close.png" class="img" onclick = "deleteAddress(${ address.id })">
                    <span>删除</span>
                 </div>      
               </div>
             </div>
          </c:if> 
      </c:forEach>
    </c:if>
   <!-- 显示非默认地址end --> 
</div>
</body>
</html>