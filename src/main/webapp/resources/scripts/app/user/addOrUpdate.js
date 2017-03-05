$(function(){
	//初始化部门树
	initOrgTree();
	initHeadImageUploader(headImage);
	initRoleList();
	initValidator();
	$("#saveBtn").bind("click",function(){
		$("#userInfoForm").data('bootstrapValidator').validate();
		if(!$("#userInfoForm").data('bootstrapValidator').isValid()){
			return false;
		}
		if($("#organizationId")[0] != undefined && ($("#organizationId").val() == null || $("#organizationId").val() == "")){
			notie.alert(2,"请选择用户部门",2);
			return false;
		}
		var userRoleList = $('#roleList').multiselect('getSelected').val();
		if($('#roleList')[0] != undefined && (userRoleList == null || userRoleList.length == 0)){
			notie.alert(2,"请选择用户角色",2);
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
        	loginName: {
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 19,
                        message: '姓名必须1~19位之间'
                    },
                    remote:{
                   	 url: path + '/user/verifyLoginNameOnly',
                        type: 'POST',
                        data: function(validator, $field, value) {
                       	    return {
                       	        userId: $("#id").val(),
                       	        loginName: $("#loginName").val()
                       	    };
                        },
                        delay: 2000,
                        message:"登录名已存在"
                   }
                }
            },
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
            userType: {
            	validators: {
            		notEmpty: {
            			message: '用户类型不能为空'
            		}
            	}
            },
            status: {
            	validators: {
            		notEmpty: {
            			message: '用户状态不能为空'
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
/**
 * 初始化部门树
 * @returns
 */
function initOrgTree(){
	jsonAjax(appPath + "/organization/queryAll",null,function(orgList){
		$(orgList).each(function(i,org){
			org.text = org.name;
			if(org.subOrgList && org.subOrgList.length > 0){
				org.nodes = org.subOrgList;
				setOrgTest(org.subOrgList);
			}
		});
		//初始化资源树
		$('#userInfoOrgTree').treeview({
			showIcon:false,
			color: "#428bca",
			data:orgList,onNodeSelected: function(event, data) {
			    $("#userInfoOrgName").attr("readonly",false).val(data.name).attr("readonly",true);
			    $("#organizationId").attr("readonly",false).val(data.id).attr("readonly",true);
			    $("#userInfoOrgTree").fadeOut("fast");
		}});
	});
	
	$("#userInfoSelectOrgBtn").bind("click",function(){
		if($("#userInfoOrgTree").is(":hidden")){
			$("#userInfoOrgTree").show().width($("#userInfoSelectOrgBtn").parent().parent().width());
			$("body").bind("mousedown", onBodyDown);
		}else{
			$("#userInfoOrgTree").fadeOut("fast");
		}
	});
	$("#userInfoCleanOrgBtn").bind("click",function(){
		$("#userInfoOrgName").attr("readonly",false).val("").attr("readonly",true);
		$("#organizationId").attr("readonly",false).val("").attr("readonly",true);
	});
	
}

function setOrgTest(orgList){
	$(orgList).each(function(i,org){
		org.text = org.name;
		if(org.subOrgList && org.subOrgList.length > 0){
			setOrgTest(org.subOrgList);
			org.nodes = org.subOrgList
		}
	});
}
function onBodyDown(event) {
	if (!(event.target.id == "userInfoSelectOrgBtn" 
			|| event.target.id == "userInfoSelectOrgBtn" 
			|| event.target.id == "userInfoOrgTree"
			|| $(event.target).parents("#userInfoOrgTree").length>0)) {
		$("#searchOrgTree").fadeOut("fast");
		$("#userInfoOrgTree").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
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
	}).on('fileuploaderror', function(event, data, msg) {
		notie.confirm('头像上传失败，是否继续', '是', '否', function() {
			saveOrUpdate();
		}, function() {
		})
	});
}

function initRoleList(){
	$.ajax({
		url : appPath + "/role/query",
		method : "post",
		data : {start:0,length:2147483647},
		dataType : "json",
		async : true,
		cache : false,
		traditional: true,
		success : function(data){
			$(data.data).each(function(i,role){
				$("#roleList").append("<option value='"+role.id+"'>"+role.name + "("+ role.description +")</option>");
			});
			$('#roleList').multiselect({
				nonSelectedText : "请选择用户角色",
				numberDisplayed : 3,
				nSelectedText : "个角色",
				allSelectedText : "全部角色",
				buttonWidth:"100%"
			});
			var userRoleArr = new Array();
			$(userRoleList).each(function(i,role){
				userRoleArr.push(role.id);
			});
			$('#roleList').multiselect('select', userRoleArr);
		},
		error:function(){
			notie.alert(3,"获取角色信息失败",2);
		}
	});
}

function saveOrUpdate(){
	var user = $("#userInfoForm").serializeObject();
	var userRoleList = new Array();
	$($('#roleList').multiselect('getSelected').val()).each(function(i,v){
		userRoleList.push({id:v});
	});
	user.roleList = userRoleList;
	jsonAjax(appPath + "/user/addOrUpdate",{
		paramJson : JSON.stringify(user)
	},function(data){
		unblockUI();
		$.pjax.reload('.content-wrapper', {
			fragment : ".content-wrapper",
			cache : false,
			url : path + "/user/manager"
		});
	});
}