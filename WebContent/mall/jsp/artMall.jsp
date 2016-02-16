<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="We Plus" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>艺术品商城</title>
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/artMall.css" rel="stylesheet" type="text/css" />
<script src="/Art/mall/js/jquery-2.1.4.js"></script>
<script src="/Art/mall/js/public.js"></script>
<script src="/Art/mall/js/artMall/artMall.js"></script>
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
			<span><img src="../images/iconfont-fanhui.png"></span>
		</a>
		<div style="text-align:center; padding-top:10px; color:#FFFFFF; font-size:20px;">艺术商城</div>
		<div class="header_right shaixuan"><img src="/Art/mall/jsp/images/iconfont-shaixuan.png"></div>
		<!-- <div class="head_right" style="top:13px;">
			<a href="/Art/mall/index" style="color:#FFFFFF; font-size:14px;">返回首页</a>
		</div> -->
	</div>
	<!-- header 结束 -->
	 <!--  <div class="search w">
        <form action="" method="get">
            <input name="" type="text" class="search_input" placeholder="请输入关键字"><input name="" type="button" class="search_submit" value="搜索">
        </form>
      </div> -->

  <div class="baoliao w">
  	<div class="ui-tab">
  		<div id="ulbox">
       </div>
      
      <div id = 'content'>
      	<!-- load content -->
      </div>
  </div>
  <!--筛选-->
  
  <div class="shaixuan_box" style="width:70%;">
	<div class="shaixuan_mall">
    	<h1>分类筛选</h1>
        <div class="shaixun_item">
            <a onClick=addCategory(this,0) class="current" id="a_0">全部分类</a>
            <c:if test="${not empty categoryList }">
            <c:forEach var="category" items="${categoryList }">
            <c:set var="aid" value="'a_${category.id }'"/>
            <a onClick=addCategory(this,${category.id}) id=${aid }>${ category.name}</a>
            </c:forEach>
            </c:if>
    	</div>
    	<h1>排序筛选</h1>
    	<div class="shaixun_item">
            <a onClick=sort(false) id='sort_time'>按时间</a>
            <a onClick=sort(true) class="current" id='sort_hot'>按热度</a>
    	</div>
    	<h1>商铺定制</h1>
    	<div class="shaixun_item">
    		<a onClick=custom(0) class="current" id='cus_no'>随便</a>
            <a onClick=custom(-1) id='cus_false'>否</a>
            <a onClick=custom(1)  id='cus_true'>是</a>
    	</div>
    	<h1>拍卖排序</h1>
    	<div class="shaixun_item">
    		<a onClick=bidTime(0) class="current" id='time_no'>随便</a>
            <a onClick=bidTime(1) id='time_now'>正在竞拍</a>
            <a onClick=bidTime(2)  id='time_future'>将来竞拍</a>
    	</div>
        <p><a href="#" class="shaixuan_colos">关闭</a></p>
    </div>
  </div>
 	<!-- footer 开始 -->
	<div class="copyright">Copyright ©2015 We Plus 版权所有</div>
	<!-- footer 结束 -->
</div>
</body>
</html>