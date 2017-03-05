$(function() {
	$("#step").step().goStep(2);
	$('#operation button').bind(
			"click",
			function() {
				$("#customerLoan").data('bootstrapValidator').validate();
				if(!$("#customerLoan").data('bootstrapValidator').isValid()){
					return false;
				}
				blockUI();
				if($(this).attr("id") == "upBtn"){
					$("#operation").data("operation","up");
				}else if($(this).attr("id") == "saveBtn"){
					$("#operation").data("operation","save");
				}else{
					$("#operation").data("operation","next");
				}
				
				//判断是否已经上传文件或者已有上载的文件
				if($("input[name='bankCardImg']").val() == "" && $("#bankCardImg").fileinput("getFileStack").length == 0){
					unblockUI();
					notie.alert(2,"请上传银行卡照片",2);
					return;
				}
				if($("input[name='holdBankCardImg']").val() == "" && $("#holdBankCardImg").fileinput("getFileStack").length == 0){
					notie.alert(2,"请上传手持银行卡照片",2);
					return;
				}
				//上传视频或者照片
				if($("#bankCardImg").fileinput("getFileStack").length > 0
						|| $("#holdBankCardImg").fileinput("getFileStack").length > 0){
					if($("#bankCardImg").fileinput("getFileStack").length > 0){
						$("#bankCardImg").fileinput("upload");
					}
					if($("#holdBankCardImg").fileinput("getFileStack").length > 0){
						$("#holdBankCardImg").fileinput("upload");
					}
				}else{
					saveData();
				}
				
			}
	);
	
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
	$('#customerLoan').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	serialNumber: {
                validators: {
                    notEmpty: {
                        message: '签约流水号不能为空'
                    },
                    stringLength: {
                        min: 18,
                        max: 18,
                        message: '签约流水号必须为18位'
                    }
                }
            },
            amount: {
            	validators: {
            		notEmpty: {
            			message: '贷款金额不能为空'
            		},
            		numeric: {
            			message: '贷款金额必须为数字'
            		}
            	}
            },
            bankCardNumber: {
                validators: {
                	notEmpty: {
                        message: '银行账号不能为空'
                    },
                    stringLength: {
                    	 min: 18,
                         max: 21,
                         message: '银行账号为18~21位'
                    },
                    numeric: {
            			message: '银行账号必须为数字'
            		}
                }
            },
            bankBranch: {
            	validators: {
            		notEmpty: {
            			message: '开户行支行不能为空'
            		},
            		stringLength: {
                   	 	min: 2,
                        max: 50,
                        message: '开户行支行为2~50位'
                   },
            	}
            },
            bankAccount: {
            	validators: {
            		notEmpty: {
            			message: '开户行不能为空'
            		}
            	}
            }
        }
    });
}
$("#bankCardImg").fileinput({
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
	initialCaption : "请上传银行卡照片",//文本框初始话value
	uploadExtraData : {
		token : uploadToken
	},
	showUploadedThumbs:false,
	autoReplace:true,
	initialPreview:bankCardImgInitialPreview,
	initialPreviewAsData:true,
	overwriteInitial:true,
	validateInitialCount:true,
	layoutTemplates : {
		actionUpload : '',
		actionDelete : ''
	}
}).on('fileuploaded', function(event, data, previewId, index) {
	$("input[name='bankCardImg']").val(data.response.key);
}).on('filebatchuploadcomplete', function(event, files, extra) {
	if($("#holdBankCardImg").fileinput("getFileStack").length == 0
			&& $("#bankCardImg").fileinput("getFileStack").length == 0){
		saveData();
	}
});
$("#holdBankCardImg").fileinput({
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
	initialCaption : "请上传手持银行卡照片",//文本框初始话value
	uploadExtraData : {
		token : uploadToken
	},
	showUploadedThumbs:false,
	autoReplace:true,
	initialPreview:holdBankCardImgInitialPreview,
	initialPreviewAsData:true,
	overwriteInitial:true,
	validateInitialCount:true,
	layoutTemplates : {
		actionUpload : '',
		actionDelete : ''
	}
}).on('fileuploaded', function(event, data, previewId, index) {
	$("input[name='holdBankCardImg']").val(data.response.key);
}).on('filebatchuploadcomplete', function(event, files, extra) {
	if($("#holdBankCardImg").fileinput("getFileStack").length == 0
			&& $("#bankCardImg").fileinput("getFileStack").length == 0){
		saveData();
	}
});



function saveData(){
	var customer = $("#customerLoan").serializeObject();
	customer.bankCardImg = {url:$("input[name='bankCardImg']").val(),type:4};
	customer.holdBankCardImg = {url:$("input[name='holdBankCardImg']").val(),type:5};
	jsonAjax(path + "/uping/upinCustomergLoan", {
		paramJson : JSON.stringify(customer)
	}, function(data) {
		unblockUI();
		var operation = $("#operation").data("operation");
		if(operation == "next"){
			$.pjax.reload('.content-wrapper', {
				fragment : ".content-wrapper",
				cache : false,
				url : path + "/customer/addOrUpdateContract?customerId=" + customerId
			});
		}else if(operation == "save"){
			$.pjax.reload('.content-wrapper', {
				fragment : ".content-wrapper",
				cache : false,
				url : path + "/uping/search"
			});
		}else{
			$.pjax.reload('.content-wrapper', {
				fragment : ".content-wrapper",
				cache : false,
				url : path + "/customer/addOrUpdateBasic?customerId=" + customerId
			});
		}
	});
}