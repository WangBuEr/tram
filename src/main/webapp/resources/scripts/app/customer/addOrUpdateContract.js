$(function() {
	$("#step").step().goStep(3);
	$('#operation button').bind(
			"click",
			function() {
				$("#customerContract").data('bootstrapValidator').validate();
				if(!$("#customerContract").data('bootstrapValidator').isValid()){
					return false;
				}
				blockUI();
				if($(this).attr("id") == "saveBtn"){
					$("#operation").data("operation","save");
				}else if($(this).attr("id") == "upingBtn"){
					$("#operation").data("operation","uping");
				}
				//判断是否已经上传文件或者已有上载的文件
				if($("input[name='contractImg']").val() == "" && $("#contractImg").fileinput("getFileStack").length == 0){
					unblockUI();
					notie.alert(2,"请上传合同照片",2);
					return;
				}
				if($("input[name='contractVideo']").val() == "" && $("#contractVideo").fileinput("getFileStack").length == 0){
					unblockUI();
					notie.alert(2,"请上传合同视频",2);
					return;
				}
				//上传视频或者照片
				if($("#contractImg").fileinput("getFileStack").length > 0
						|| $("#contractVideo").fileinput("getFileStack").length > 0){
					if($("#contractImg").fileinput("getFileStack").length > 0){
						$("#contractImg").fileinput("upload");
					}
					if($("#contractVideo").fileinput("getFileStack").length > 0){
						$("#contractVideo").fileinput("upload");
					}
				}else{
					saveData();
				}
				
			}
	);
	
	initValidator();
});

/**
 * 初始化表单验证
 * @returns
 */
function initValidator(){
	$('#customerContract').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	contractNumber: {
                validators: {
                    notEmpty: {
                        message: '合同号不能为空'
                    },
                    stringLength: {
                        min: 18,
                        max: 18,
                        message: '合同号必须为18位'
                    }
                }
            }
        }
    });
}
$("#contractImg").fileinput({
	  uploadUrl : "http://upload.qiniu.com/", //上传图片的url
	  deleteUrl:path + "/image/delete",
	  allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
	  allowedFileTypes: ['image'],
	  allowedPreviewTypes: ['image'], 
	  showRemove:true, 
	  showUpload : false,
	  language : 'zh',
	  initialCaption: "请上传合同照片",//文本框初始话value
	  uploadExtraData : {
		token : uploadToken
	  },
	  showUploadedThumbs:false,
	  autoReplace:false,
	  initialPreview:imageInitialPreview,
	  initialPreviewShowDelete:true,
	  initialPreviewConfig:imageInitialPreviewConfig,
	  overwriteInitial:false,
	  validateInitialCount:true,
	  layoutTemplates : {
		  actionUpload : ''
	  }
}).on('fileuploaded', function(event, data, previewId, index) {
	var images =  $("input[name='contractImg']").val();
	if(images){
		$("input[name='contractImg']").val(images + ","+data.response.key);
	}else{
		$("input[name='contractImg']").val(data.response.key);
	}
}).on('filebatchuploadcomplete', function(event, files, extra) {
	if($("#contractVideo").fileinput("getFileStack").length == 0
			&& $("#contractImg").fileinput("getFileStack").length == 0){
		saveData();
	}
}).on('filedeleted', function(event, key) {
    var arr = $("input[name='contractImg']").val().split(",");
    arr.removeByValue(key);
    $("input[name='contractImg']").val(arr.join(","));
});
$("#contractVideo").fileinput({
	  uploadUrl : "http://upload.qiniu.com/", //上传图片的url
	  deleteUrl:path + "/image/delete",
	  allowedFileExtensions : [ 'mp4' ],
	  allowedFileTypes: ['video', 'flash'],
	  showUpload : false,
	  overwriteInitial : false,
	  language : 'zh',
	  initialCaption: "请上传合同视频",//文本框初始话value
	  uploadExtraData : {
		token : uploadToken
	  },
	  showUploadedThumbs:false,
	  autoReplace:false,
	  initialPreview:videoInitialPreview,
	  initialPreviewShowDelete:true,
	  initialPreviewConfig:videoInitialPreviewConfig,
	  overwriteInitial:false,
	  validateInitialCount:true,
	  layoutTemplates : {
		  actionUpload : ''
	  }
}).on('fileuploaded', function(event, data, previewId, index) {
	var videos =  $("input[name='contractVideo']").val();
	if(videos){
		$("input[name='contractVideo']").val(videos + ","+data.response.key);
	}else{
		$("input[name='contractVideo']").val(data.response.key);
	}
	
}).on('filebatchuploadcomplete', function(event, files, extra) {
	if($("#contractVideo").fileinput("getFileStack").length == 0
			&& $("#contractImg").fileinput("getFileStack").length == 0){
		saveData();
	}
}).on('filedeleted', function(event, key) {
    var arr = $("input[name='contractVideo']").val().split(",");
    arr.removeByValue(key);
    $("input[name='contractVideo']").val(arr.join(","));
});
function saveData(){
	var customer = $("#customerContract").serializeObject();
	var imgArr = $("input[name='contractImg']").val().split(",");
	var videoArr =  $("input[name='contractVideo']").val().split(",");
    if($("#operation").data("operation") == "uping"){
    	customer.status = 1;
	}
	customer.contractImageList = new Array();
	for(var i = 0; i < imgArr.length; i++){
		customer.contractImageList.push({url:imgArr[i],type:6});
	}
	customer.contractVideoList = new Array();
	for(var i = 0; i < videoArr.length; i++){
		customer.contractVideoList.push({url:videoArr[i],type:0});
	}
	jsonAjax(path + "/uping/upinCustomergContract", {
		paramJson : JSON.stringify(customer)
	}, function(data) {
		unblockUI();
		$.pjax.reload('.content-wrapper', {
			fragment : ".content-wrapper",
			cache : false,
			url : path + "/uping/search"
		});
	});
}