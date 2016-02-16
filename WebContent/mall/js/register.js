function register(){
	
	/*var again=$("input[name='again']").val();
	var usernameReg=!!username.match(/^([\u4E00-\uFA29]*[a-z]*[A-Z]*[0-9]*)+$/);
	var telReg = !!telephone.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
	if(usernameReg==false||username.length<3||username.length>10)
		alert("用户名只能包含数字和字母，且在3-10位之间");
	else if(telReg==false)
		alert("手机号码格式错误");
	else if(password.length<6||password.length>20)
		alert("密码只能在6-20位之间");
	else if(password!=again)
		alert("输入密码不一致");*/
	var flag=true;
	$("#frm_register div.item").each(function(){
		var warning=$(this).find("input").val()==""?"注册信息填写不完整":$(this).find("p").text();
		if($(this).find("input").val()==""||$(this).find("p").css("display")!="none"){
			alert(warning);
			flag=false;
			return false;
		}
	});
	if(flag){
		var username=$("input[name='username']").val();
		var telephone=$("input[name='telephone']").val();
		var password=$("input[name='password']").val();
		
		$.post(
				"/Art/mall/register.json",
				{
					username:username,
					telephone:telephone,
					password:password
				},
				function(data){
					if(data.type==0)
						window.location.href="register_ok.jsp";
					else
						alert(data.info);
				});
	}
	
}
function validateUsername(){
	var username=$("input[name='username']").val();
	var usernameReg=!!username.match(/^([\u4E00-\uFA29]*[a-z]*[A-Z]*[0-9]*)+$/);
	if(usernameReg==false||username.length<3||username.length>10)
		$("p#validateUsername").show();
	else
		$("p#validateUsername").hide();
}
function validateTelephone(){
	var telephone=$("input[name='telephone']").val();
	var telReg = !!telephone.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
	if(telReg==false)
		$("p#validateTelephone").show();
	else
		$("p#validateTelephone").hide();
}
function validatePassword(){
	var password=$("input[name='password']").val();
	if(password.length<6||password.length>20)
		$("p#validatePassword").show();
	else
		$("p#validatePassword").hide();
}
function validatePassword_PwdTwo(){
	var password=$("input[name='password']").val();
	var password_PwdTwo=$("input[name='password_PwdTwo']").val();
	if(password!=password_PwdTwo)
		$("p#validatePassword_PwdTwo").show();
	else
		$("p#validatePassword_PwdTwo").hide();
}