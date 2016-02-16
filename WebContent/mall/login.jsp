<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="m.178hui.com" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>登录</title>
<link href="/Art/mall/frozenui/css/frozen.css" rel="stylesheet" type="text/css">
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/login.css" rel="stylesheet" type="text/css">
<script src="/Art/mall/js/jquery-1.8.3.min.js"></script>
<script src="/Art/mall/layer/layer.js"></script>
<script>
$(window).load(function() {
	$("#status").fadeOut();
	$("#preloader").delay(350).fadeOut("slow");
})
</script>
</head>
<script type="text/javascript">
	function login(){
	  	var username = $.trim($("#username").val());
		var password = $.trim($("#password").val());
		if(username == ''){
			layer.tips('请输入用户名/手机号码','#username', {tips: 1});
			return false;
		}else if(password == ''){
			layer.tips('请输入登录密码','#password', {tips: 1});
			return false;
		}
		else{
			$.post(
					"/Art/mall/login.json",
					{
						nameORtel:username,
						password:password
					},
					function(data){
						if(data.type!=0)
							alert(data.info);
						else
							window.location.href="/Art/mall/index";
					});
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
    <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
      <h2>艺术品网站·登录</h2>
      </div>
  </header>
  <!--header 结束-->
  
  <div class="w main">
  	<form id="frm_login" method="get" action="">
        <div class="item item-username">
          <input id="username" class="txt-input txt-username" type="text" placeholder="请输入用户名/手机号" value="" name="username">
          <b class="input-close" style="display: none;"></b> </div>
        <div class="item item-password">
          <input id="password" class="txt-input txt-password ciphertext" type="password" placeholder="请输入密码" name="password" style="display: inline;">
          <input id="ptext" class="txt-input txt-password plaintext" type="text" placeholder="请输入密码" style="display: none;" name="ptext">
          <b class="tp-btn btn-off"></b>
        </div>
        <div class="item item-login-option">
        	<!--<div class="aoutlogin">
                <label class="ui-checkbox ui-checkbox-s">
                    <input type="checkbox" name="checkbox" checked/>一个月内免登录
                </label>
            </div>-->
            <span class="retrieve-password"> <a class="" href="getpwd_email.html"> 找回密码</a> </span>
        </div>
        <div class="ui-btn-wrap"> <a class="ui-btn-lg ui-btn-primary" onclick="login()" >用户登录</a> </div>
        <div class="ui-btn-wrap"> <a class="ui-btn-lg ui-btn-danger" href="/Art/mall/jsp/user/register">没有账号？立即注册</a> </div>
    <!--<div class="item item-login-other">
          <dl>
            <dt>其它登录方式</dt>
            <dd> <a class="qq" href="#"> <span><img alt="" src="images/login_qq.png" width="40" height="40"></span> </a> </dd>
          </dl>
        </div>-->
      </form>
  </div>
	
  <!--<div class="m_user w">
  	<a href="login.html">登录</a>
    <a href="register.html">注册</a>
    <a href="#">返回顶部</a>
  </div>
  <div class="footer w">
  	<a href="#"><div class="ico_img"><img src="images/178hui-app.png"></div><span style="color:#00bb9c">客户端</span></a>
    <a href="index.html"><div class="ico_img"><img src="images/178hui-shouji.png"></div><span style="color:#eb4f38">触摸版</span></a>
    <a href="#"><div class="ico_img"><img src="images/178hui-diannao.png"></div><span>电脑版</span></a>
  </div>
  <div class="copyright">Copyright © 2012-2015 一起惠返利网 m.178hui.com 版权所有</div>-->
</div>
</body>
</html>
    <script type="text/javascript" >
    $(function() {
		$(".input-close").hide();
		displayPwd();
		displayClearBtn();
		setTimeout(displayClearBtn, 200 ); //延迟显示,应对浏览器记住密码
	});	

	//是否显示清除按钮
	function displayClearBtn(){
		if(document.getElementById("username").value != ''){
			$("#username").siblings(".input-close").show();
		}
		if(document.getElementById("password").value != ''){
			$(".ciphertext").siblings(".input-close").show();
		}
		if($("#codeLevel").val()!="" && $("#codeLevel").val()!='0'){
			if($("#validateCode").val()!=""){
				$("#validateCode").siblings(".input-close").show();
			}
		}
	}

	//清除input内容
    $('.input-close').click(function(e){  
		$(e.target).parent().find(":input").val("");
		$(e.target).hide();
		$($(e.target).parent().find(":input")).each(function(i){
			if(this.id=="ptext" || this.id=="password"){
				$("#password").val('');
				$("#ptext").val('');
			}
         });
    });  
	
	//设置password字段的值	
	$('.txt-password').bind('input',function(){
		$('#password').val($(this).val());
	});
	
	//显隐密码切换
	function displayPwd(){
    	$(".tp-btn").toggle(
          function(){
            $(this).addClass("btn-on");
			var textInput = $(this).siblings(".plaintext");
    		var pwdInput = $(this).siblings(".ciphertext");
			pwdInput.hide();
			textInput.val(pwdInput.val()).show().focusEnd();
          },
          function(){
		  	$(this).removeClass("btn-on");
		  	var textInput = $(this).siblings(".plaintext ");
    		var pwdInput = $(this).siblings(".ciphertext");
            textInput.hide();
			pwdInput.val(textInput.val()).show().focusEnd();
          }
    	);
	}

	//监控用户输入
	$(":input").bind('input propertychange', function() {
		if($(this).val()!=""){
			$(this).siblings(".input-close").show();
		}else{
			$(this).siblings(".input-close").hide();
		}
    });
</script> 