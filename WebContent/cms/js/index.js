$(document).ready(function(){
	$.ajax({
		url:"/Art/cmsGetAuthByAdmin.json",
		type:"POST",
		data:{},
		success:function(data){
			if(checkData(data)){
				var size = data.data.length;
				if(size > 0){
					var html = " <li class='active launcher'><i class='icon-dashboard'></i><a><button id='dashboard' type='button' data-model='dashboard' style='background-color:transparent;border:0;' onClick=loadContent(this)>首页</button></a></li><li></li>";
					for(var i = 0; i<size; i++){
						html += "<li class='launcher'><i class='icon-file-text-alt'></i><a><button id='"+ data.data[i].role.english +"' type='button' data-model='"+ data.data[i].role.english +"' style='background-color:transparent;border:0;' onClick=loadContent(this)>"+data.data[i].role.description+"</button></a></li><li></li>";
					}
					document.getElementById("dock").innerHTML = html;
				}
			}
		}
	});
});

function loadContent(e){
	  		var url = "./jsp/"+e.id+".jsp";
	  		$('#right').load(url);
}

function showModifyPasswordDiv(){
	document.getElementById("right").style.zindex="-1";
	document.getElementById("modify_password").style.display="";
}

function hideModifyPasswordDiv(){
	document.getElementById("right").style.zindex="1";
	document.getElementById("modify_password").style.display="none";
}

function validator_password(current_password,new_password,new_password_sed){
	if(current_password == null || current_password == ''){
		alert("请输入现在的密码");
		return false;
	}
	if(new_password == null || new_password == ''){
		alert("请输入新的密码");
		return false;
	}
	if(current_password == new_password){
		alert("旧密码与新密码不能相同");
		return false;
	}
	if(new_password != new_password_sed){
		alert("两次输入的新密码不同");
		return false;
	}
	return true;
}

function cmsModifyPassword(){
	var current_password = $('#current_password').val();
	var new_password = $('#new_password').val();
	var new_password_sed = $('#new_password_sed').val();
	if(validator_password(current_password,new_password,new_password_sed)){
		$.post(
				"/Art/cmsModifyPwd.json",
				{
					'current_password':current_password,
					'new_password':new_password
				},
				function(data){
					if(checkData(data)){
						alert('修改密码成功');
						hideModifyPasswordDiv();
					}
				});
	}
}

function checkData(data){
	if(data.Errno == 2){
		window.location.href = data.Data;
	}else if(data.Errno == 1){
		alert(data.Data);
		return false;
	}else{
		return true;
	}
}