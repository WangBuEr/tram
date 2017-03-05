$(function(){
	initHeadImageUploader(headImage);
	initValidator();
	$("#saveBtn").bind("click",function(){
		$("#userInfoForm").data('bootstrapValidator').validate();
		if(!$("#userInfoForm").data('bootstrapValidator').isValid()){
			return false;
		}
		blockUI();
		if($("#headImage").fileinput("getFileStack").length == 0){
			saveOrUpdate();
		}else{
			$("#headImage").fileinput("upload");
		}
		
	});
});
/**
 * 初始化表单验证
 * @returns
 */
function initValidator(){
	$('#userInfoForm').bootstrapValidator({
		excluded:[],
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
                        message: '姓名必须1~94位之间'
                    }
                }
            },
            password: {
            	validators: {
            		stringLength: {
            			min: 6,
            			max: 12,
            			message: '密码必须6~12位之间'
            		}
            	}
            },
            sex: {
            	validators: {
            		notEmpty: {
                        message: '性别不能为空'
                    }
            	}
            },
            age: {
            	validators: {
            		notEmpty: {
            			message: '性别不能为空'
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
}

function initHeadImageUploader(headImage){
	var opt = {
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
			initialCaption : "请上传头像照片",//文本框初始话value,
			uploadExtraData : {
				token : uploadToken
			},
			showUploadedThumbs:false,
			autoReplace:true,
			initialPreviewAsData:true,
			overwriteInitial:true,
			validateInitialCount:true,
			layoutTemplates : {
				actionUpload : '',
				actionDelete : ''
			}
	};
	if(headImage != null && headImage != ""){
		opt.initialPreview=headImage;
	}
	$("#headImage").fileinput(opt).on('fileuploaded', function(event, data, previewId, index) {
		$("input[name='headImage']").val(data.response.key);
	}).on('filebatchuploadcomplete', function(event, files, extra) {
		saveOrUpdate();
	});
}


function saveOrUpdate(){
	var user = $("#userInfoForm").serializeObject();
	jsonAjax(appPath + "/user/update",user,function(data){
		unblockUI();
		notie.alert(1,"修改成功",2);
	});
}