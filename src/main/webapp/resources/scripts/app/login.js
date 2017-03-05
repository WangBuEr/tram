$(function() {
	$('input').iCheck({
		checkboxClass : 'icheckbox_square-blue',
		radioClass : 'iradio_square-blue',
		increaseArea : '20%' // optional
	});
	$("#loginBtn").bind("click",function(){
		login();
	});
	$("body").keydown(function(e) {
        if(e.which == "13") {//keyCode=13是回车键
        	$("#loginBtn").click();
        }
    });
});

function login(){
	var loginName = $("input[name='loginName']").val();
	if($.trim(loginName) == ''){
		notie.alert(2,"用户名不能为空！",2);
		return false;
	}
	var password = $("input[name='password']").val();
	if($.trim(password) == ''){
		notie.alert(2,"密码不能为空！",2);
		return false;
	}
	var param = $("form").serializeObject();
	param.rememberMe = $("input[name='rememberMe']").is(':checked')?1:0;
	jsonAjax(appPath + "/login",param,function(data){
		window.location.href = appPath + "/index";
	},function(data){
		notie.alert(3,data.message,2);
	});
}