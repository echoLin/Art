<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class='no-js' lang='en'>
  <head>
    <meta charset='utf-8'>
    <meta content='IE=edge,chrome=1' http-equiv='X-UA-Compatible'>
    <title>艺术品定制网站后台管理系统</title>
    <meta content='art_cms_dashboard' name='echo'>
    <link href="/Art/cms/css/application-a07755f5.css" rel="stylesheet" type="text/css" />
    <link href="/Art/cms/css/dashboard.css" rel="stylesheet" type="text/css" />
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
  	<script type="text/javascript">
    $(document).ready(function() {
      $('.summernote').summernote({
        height: 300,
        minHeight:null,
        maxHeight:null,
        focus:true
      });
    });
  </script>
    
  </head>
  <body class='main page'>
    <!-- Navbar -->
    <div class='navbar navbar-default' id='navbar'>
      <a class='navbar-brand' href='#'>
        <i class='icon-beer'></i>
        Art-后台管理系统
      </a>
      <ul class='nav navbar-nav pull-right'>
        <li class='dropdown'>
          <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
            <i class='icon-envelope'></i>
            消息
            <span class='badge'>0</span>
            <b class='caret'></b>
          </a>
          <ul class='dropdown-menu'>
            <li>
              <a href='#'>
              	<button id="model" type="button" data-model="test" style="background-color:transparent;border:0">
              	查看消息
              	</button>
              </a>
             </li>
             <li class='divider'></li>
             <li>
              <a href='#'>
              	<button id="model" type="button" data-model="test" style="background-color:transparent;border:0">
              	发送消息
              	</button>
              </a>
            </li>
          </ul>
        </li>
        <li>
          <a href='#'>
            <i class='icon-cog'></i>
            <button id="message" type="button" data-model="test" style="background-color:transparent;border:0" onClick=showModifyPasswordDiv()>
            修改密码
            </button>
          </a>
        </li>
        <li class='dropdown user'>
          <a class='dropdown-toggle' data-toggle='dropdown' href='#'>
            <i class='icon-user'></i>
            	<strong>
				 	${user.realname }
            	</strong>
            <b class='caret'></b>
          </a>
          <ul class='dropdown-menu'>
            <li>
              <a href='#'>Edit Profile</a>
            </li>
            <li class='divider'></li>
            <li>
              <a href="/Art/cmsLogout">注销</a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
    <!-- Navbar end -->
    <div id='wrapper'>
      <!-- Sidebar -->
      <section id='sidebar'>
        <i class='icon-align-justify icon-large' id='toggle'></i>
        <ul id='dock'>
          <li class='active launcher'>
            <i class='icon-dashboard'></i>
            <a><button id="model" type="button" data-model="dashboard" style="background-color:transparent;border:0">首页</button></a>
          </li>
          <c:if test="${not empty authList }">
          <c:forEach var="auth" items="${authList }">
          		<li class='launcher'>
            		<i class='icon-file-text-alt'></i>
           			 <a>
           			 <button id="model" type="button" data-model="${auth.role.english }" style="background-color:transparent;border:0">
            			${auth.role.description}
            		</button>
            		</a>
            </li>
          </c:forEach>
          </c:if>
        </ul>
        <div data-toggle='tooltip' id='beaker' title='Made by wePluse'></div>
      </section>
      <!-- Sidebar end-->
      <!-- Tools -->
      <section id='tools'>
        <ul class='breadcrumb' id='breadcrumb'>
          <li class='title'>首页</li>
        </ul>
      </section>
      <!-- Tools end-->
      <div id='content'>
      	<div class="summernote">hello Summernote</div>
      </div>
    </div>
    <!-- modify possword -->
    <div id="modify_password" class='modify' style="display:none">
    	<div class="wrapper">
    		<div class="row">
    			<div class='col-lg-12'>
    				<div class='brand text-center'>
    						<div class='logo-icon'>
    							<i class='icon-beer'></i>
    						</div>
    					<h1>
    						Artwork_CMS
    					</h1>
    				</div>
    			</div>
    			<div class='row'>
    				<div class='col-lg-12'>
    					<form id="cmsModifyPassword_form">
    						<fieldset class='text-center'>
    							<legend>Modify your password</legend>
    							<div class='form-froup'>
    								<input class='form-control' placeholder="Please enter your current password" type='password' id='current_password' name='current_password'/>
    							</div>
    							<br>
    							<div class='form-froup'>
    								<input class='form-control' placeholder="Please enter your new password" type='password' id='new_password' name='new_password'/>
    							</div>
    							<br>
    							<div class='form-froup'>
    								<input class='form-control' placeholder="Please enter your new password again" type='password' id='new_password_sed' name='new_password_sed'/>
    							</div>
    							<br>
    							<div class='text-center'>
    								<input class="btn btn-default" type="button" value="Sign in" onClick="cmsModifyPassword()"/>
    								
    							</div>
    							<br>
    						</fieldset>
    					</form>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <!-- Footer
    <div id="fonter" class="text-center">
    	<div class="wrapper">
    		<p>Designed and built with all the love in the world by We Plus</p>
    		<div class="crew"></div>
    	</div>
    	<div class="copyrights">
    		<p>©Nova Studio&nbsp;2015.All rights reserved.</p>
    	</div>
    </div> 
     -->
     <!-- Javascripts -->
  </body>

  
</html>
