$(function() {
	//进度条
	$("#step").step().goStep(1);
	//操作
	$("#operation button").bind(
			"click",
			function() {
				//验证表单
				$("#customerBasic").data('bootstrapValidator').validate();
				$("#customerShare").data('bootstrapValidator').validate();
				$("#customerurgent").data('bootstrapValidator').validate();
				if(!$("#customerBasic").data('bootstrapValidator').isValid()
						||!$("#customerShare").data('bootstrapValidator').isValid()
						||!$("#customerurgent").data('bootstrapValidator').isValid()){
					return false;
				}
				blockUI();
				if($(this).attr("id") == "saveBtn"){
					$("#operation").data("operation","save");
				}else{
					$("#operation").data("operation","next");
				}
				//判断是否已经上传文件或者已有上载的文件
				if($("input[name='idCardFaceImg']").val() == "" && $("#idCardFaceImg").fileinput("getFileStack").length == 0){
					unblockUI();
					notie.alert(2,"请上传身份证正面照片",2);
					return;
				}
				if($("input[name='idCardSideImg']").val() == "" && $("#idCardSideImg").fileinput("getFileStack").length == 0){
					unblockUI();
					notie.alert(2,"请上传身份证反面照片",2);
					return;
				}
				if($("input[name='shareIdCardFaceImg']").val() == "" && $("#shareIdCardFaceImg").fileinput("getFileStack").length == 0){
					unblockUI();
					notie.alert(2,"请上传共偿人身份证正面照片",2);
					return;
				}
				if($("input[name='shareIdCardSideImg']").val() == "" && $("#shareIdCardSideImg").fileinput("getFileStack").length == 0){
					unblockUI();
					notie.alert(2,"请上传共偿人身份证反面照片",2);
					return;
				}
				//上传视频或者照片
				if($("#idCardFaceImg").fileinput("getFileStack").length > 0
						|| $("#idCardSideImg").fileinput("getFileStack").length > 0
						|| $("#shareIdCardFaceImg").fileinput("getFileStack").length > 0
						|| $("#shareIdCardSideImg").fileinput("getFileStack").length > 0){
					if($("#idCardFaceImg").fileinput("getFileStack").length > 0){
						$("#idCardFaceImg").fileinput("upload");
					}
					if($("#idCardSideImg").fileinput("getFileStack").length > 0){
						$("#idCardSideImg").fileinput("upload");
					}
					if($("#shareIdCardFaceImg").fileinput("getFileStack").length > 0){
						$("#shareIdCardFaceImg").fileinput("upload");
					}
					if($("#shareIdCardSideImg").fileinput("getFileStack").length > 0){
						$("#shareIdCardSideImg").fileinput("upload");
					}
				}else{
					saveData();
				}
				
			}
	);
	//初始化单选框
	$('input').iCheck({
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '50%' // optional
	});
	
	initValidator();
});

/**
 * 初始化表单验证
 * @returns
 */
function initValidator(){
	$('#customerBasic').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 32,
                        message: '姓名必须2~32位之间'
                    }
                }
            },
            cardNumber: {
                validators: {
                    notEmpty: {
                        message: '身份证号码不能为空'
                    },
                    stringLength: {
                    	 min: 18,
                         max: 18,
                         message: '身份证号码必须为18位'
                    },
                    remote:{
                    	 url: path + '/customer/validate/cardNumber',
                         type: 'POST',
                         data: function(validator, $field, value) {
                        	    return {
                        	        customerId: $("#id").val(),
                        	        cardNumber: $("#cardNumber").val()
                        	    };
                         },
                         delay: 2000,
                         message:"身份证号已存在"
                    }
                }
            },
            phone: {
            	validators: {
            		notEmpty: {
            			message: '联系电话不能为空'
            		},
            		integer: {
                        message: '手机号必须全部为数字',
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }
            	}
            },
            carModels: {
            	validators: {
            		notEmpty: {
            			message: '车型不能为空'
            		},
            		stringLength: {
            			min: 1,
            			max: 255,
            			message: '车型必须2~255位之间'
            		}
            	}
            },
            carPrice: {
            	validators: {
            		notEmpty: {
            			message: '车价不能为空'
            		},
            		numeric: {
            			message: '车价必须为数字'
            		}
            	}
            }
        }
    });
	
	
	$('#customerShare').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    },
                    stringLength: {
                        min: 2,
                        max: 32,
                        message: '姓名必须2~32位之间'
                    }
                }
            },
            phone: {
            	validators: {
            		notEmpty: {
            			message: '联系电话不能为空'
            		},
            		integer: {
                        message: '手机号必须全部为数字',
                        thousandsSeparator: '',
                        decimalSeparator: '.'
                    }
            	}
            }
        }
    });
	
	$('#customerurgent').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields: {
			nameOne: {
				validators: {
					stringLength: {
						min: 2,
						max: 32,
						message: '姓名必须2~32位之间'
					}
				}
			},
			phoneOne: {
				validators: {
					integer: {
						message: '手机号必须全部为数字',
						thousandsSeparator: '',
						decimalSeparator: '.'
					}
				}
			},
			nameTwo: {
				validators: {
					stringLength: {
						min: 2,
						max: 32,
						message: '姓名必须2~32位之间'
					}
				}
			},
			phoneTwo: {
				validators: {
					integer: {
						message: '手机号必须全部为数字',
						thousandsSeparator: '',
						decimalSeparator: '.'
					}
				}
			}
		}
	});
}




//初始化文件上传
$("#idCardFaceImg").fileinput({
	uploadUrl : "http://upload.qiniu.com/", //上传图片的url
	allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
	allowedFileTypes : [ 'image' ],
	showUpload : false,
	showRemove : false,
	minFileCount : 1,
	maxFileCount : 1,
	layoutTemplates : {
		actions : ''
	},
	language : 'zh',
	initialCaption : "请上传身份证正面照片",//文本框初始话value,
	uploadExtraData : {
		token : uploadToken
	},
	showUploadedThumbs:false,
	autoReplace:true,
	initialPreview:idCardFaceImgInitialPreview,
	initialPreviewAsData:true,
	overwriteInitial:true,
	validateInitialCount:true,
	layoutTemplates : {
		actionUpload : '',
		actionDelete : ''
	}
}).on('fileuploaded', function(event, data, previewId, index) {
	$("input[name='idCardFaceImg']").val(data.response.key);
}).on('filebatchuploadcomplete', function(event, files, extra) {
	if($("#idCardFaceImg").fileinput("getFileStack").length == 0
			&& $("#idCardSideImg").fileinput("getFileStack").length == 0
			&& $("#shareIdCardFaceImg").fileinput("getFileStack").length == 0
			&& $("#shareIdCardSideImg").fileinput("getFileStack").length == 0){
		saveData();
	}
});
$("#idCardSideImg").fileinput({
	uploadUrl : "http://upload.qiniu.com/", //上传图片的url
	allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
	allowedFileTypes : [ 'image' ],
	showUpload : false,
	showRemove : false,
	minFileCount : 1,
	maxFileCount : 1,
	layoutTemplates : {
		actions : ''
	},
	language : 'zh',
	initialCaption : "请上传身份证反面照片",//文本框初始话value,
	uploadExtraData : {
		token : uploadToken
	},
	showUploadedThumbs:false,
	autoReplace:true,
	initialPreview:idCardSideImgInitialPreview,
	initialPreviewAsData:true,
	overwriteInitial:true,
	validateInitialCount:true,
	layoutTemplates : {
		actionUpload : '',
		actionDelete : ''
	}
}).on('fileuploaded', function(event, data, previewId, index) {
	$("input[name='idCardSideImg']").val(data.response.key);
}).on('filebatchuploadcomplete', function(event, files, extra) {
	if($("#idCardFaceImg").fileinput("getFileStack").length == 0
			&& $("#idCardSideImg").fileinput("getFileStack").length == 0
			&& $("#shareIdCardFaceImg").fileinput("getFileStack").length == 0
			&& $("#shareIdCardSideImg").fileinput("getFileStack").length == 0){
		saveData();
	}
});

$("#shareIdCardFaceImg").fileinput({
	uploadUrl : "http://upload.qiniu.com/", //上传图片的url
	allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
	allowedFileTypes : [ 'image' ],
	showUpload : false,
	showRemove : false,
	minFileCount : 1,
	maxFileCount : 1,
	layoutTemplates : {
		actions : ''
	},
	language : 'zh',
	initialCaption : "请上传共偿人身份证正面照片",//文本框初始话value
	uploadExtraData : {
		token : uploadToken
	},
	showUploadedThumbs:false,
	autoReplace:true,
	initialPreview:shareIdCardFaceImgInitialPreview,
	initialPreviewAsData:true,
	overwriteInitial:true,
	validateInitialCount:true,
	layoutTemplates : {
		actionUpload : '',
		actionDelete : ''
	}
}).on('fileuploaded', function(event, data, previewId, index) {
	$("input[name='shareIdCardFaceImg']").val(data.response.key);
}).on('filebatchuploadcomplete', function(event, files, extra) {
	if($("#idCardFaceImg").fileinput("getFileStack").length == 0
			&& $("#idCardSideImg").fileinput("getFileStack").length == 0
			&& $("#shareIdCardFaceImg").fileinput("getFileStack").length == 0
			&& $("#shareIdCardSideImg").fileinput("getFileStack").length == 0){
		saveData();
	}
});
$("#shareIdCardSideImg").fileinput({
	uploadUrl : "http://upload.qiniu.com/", //上传图片的url
	allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
	allowedFileTypes : [ 'image' ],
	showUpload : false,
	showRemove : false,
	minFileCount : 1,
	maxFileCount : 1,
	layoutTemplates : {
		actions : ''
	},
	language : 'zh',
	initialCaption : "请上传共偿人身份证反面照片",//文本框初始话value
	uploadExtraData : {
		token : uploadToken
	},
	showUploadedThumbs:false,
	autoReplace:true,
	initialPreview:shareIdCardSideImgInitialPreview,
	initialPreviewAsData:true,
	overwriteInitial:true,
	validateInitialCount:true,
	layoutTemplates : {
		actionUpload : '',
		actionDelete : ''
	}
}).on('fileuploaded', function(event, data, previewId, index) {
	$("input[name='shareIdCardSideImg']").val(data.response.key);
}).on('filebatchuploadcomplete', function(event, files, extra) {
	if($("#idCardFaceImg").fileinput("getFileStack").length == 0
			&& $("#idCardSideImg").fileinput("getFileStack").length == 0
			&& $("#shareIdCardFaceImg").fileinput("getFileStack").length == 0
			&& $("#shareIdCardSideImg").fileinput("getFileStack").length == 0){
		saveData();
	}
});

/**
 * 保存数据
 * @returns
 */
function saveData(){
	var customer = $("#customerBasic").serializeObject();
	delete customer.idCardFaceImg;
	delete customer.idCardSideImg;
	customer.share = $("#customerShare").serializeObject();
	customer.emergencyContactList = new Array();
	if ($("#nameOne").val() || $("#phoneOne").val()) {
		customer.emergencyContactList.push({
			name : $("#nameOne").val(),
			phone : $("#phoneOne").val()
		});
	}
	if ($("#nameTwo").val() || $("#phoneTwo").val()) {
		customer.emergencyContactList.push({
			name : $("#nameTwo").val(),
			phone : $("#phoneTwo").val()
		});
	}
	
	customer.imageList = new Array();
	customer.imageList.push({url:$("input[name='idCardFaceImg']").val(),type:0});
	customer.imageList.push({url:$("input[name='idCardSideImg']").val(),type:1});
	customer.imageList.push({url:$("input[name='shareIdCardFaceImg']").val(),type:2});
	customer.imageList.push({url:$("input[name='shareIdCardSideImg']").val(),type:3});
	jsonAjax(path + "/uping/upinCustomergBasic", {
		paramJson : JSON.stringify(customer)
	}, function(data) {
		unblockUI();
		if($("#operation").data("operation") == "next"){
			$.pjax.reload('.content-wrapper', {
				fragment : ".content-wrapper",
				cache : false,
				url : path + "/customer/addOrUpdateLoan?customerId=" + data.id
			});
		}else{
			$.pjax.reload('.content-wrapper', {
				fragment : ".content-wrapper",
				cache : false,
				url : path + "/uping/search"
			});
		}
	});
}