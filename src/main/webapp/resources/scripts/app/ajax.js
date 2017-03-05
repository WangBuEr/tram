function jsonAjax(url, param, successCallBack, errorCallBack,method) {
	var result = null;
	var ajaxMethod = "post";
	if (method != undefined || method != null) {
		ajaxMethod = method;
	}
	$.ajax({
		url : url,
		method : ajaxMethod,
		data : param,
		dataType : "json",
		async : true,
		cache : false,
		traditional: true,
		success : function(data) {
			if (data.code == "10000") {
				if(successCallBack){
					successCallBack(data.data);
				}else{
					unblockUI();
					notie.alert(1, "操作成功",2);
				}
			} else if (errorCallBack) {
				errorCallBack(data);
			} else {
				var body = null;
				if (data.code == "2000") {
					body = data.message ? data.message : "非法参数！";
				} else if (data.code = "3000") {
					body = data.message ? data.message : "非法操作！";
				}
				unblockUI();
				notie.alert(2, body,3);
			}
		},
		error : function(req, textStatus, errorThrown) {
			unblockUI();
			if(req.status == 500){
				notie.alert(3, '服务器发生错误，请与管理员联系！',3);
			}else if(req.status == 405){
				notie.alert(3, '非法请求！',3);
			}
		}
	});
}