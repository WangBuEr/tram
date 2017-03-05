$(function(){
	drawResTreeTable();
	$("#addBtn").bind("click",function(){
		showResInfoModal();
	});
	
	$("#cleanParentResBtn").bind("click",function(){
		$("#parentResName").attr("readonly",false).val("").attr("readonly",true);
	    $("#pid").attr("readonly",false).val("").attr("readonly",true);
	});
	$("#addOrUpdateResBtn").bind("click",function(){
		$("#resInfoForm").data('bootstrapValidator').validate();
		if(!$("#resInfoForm").data('bootstrapValidator').isValid()){
			return false;
		}
		$("#resInfoModal").modal('hide');
		blockUI();
		jsonAjax(appPath +"/resource/addOrUpdate",
				$("#resInfoForm").serializeObject(),function(data){
			unblockUI();
			drawResTreeTable();
		});
	});
	
//	初始化资源信息对话框属性
	$("#resInfoModal").modal({backdrop: 'static', keyboard: false,show:false});
//	父资源选择组件初始化
	$("#selectParentResBtn").bind("click",function(){
		if($("#resTree").is(":hidden")){
			$("#resTree").show().width($("#selectParentResBtn").parent().parent().width());
			$("body").bind("mousedown", onBodyDown);
		}else{
			$("#resTree").fadeOut("fast");
		}
	});
});
function initResInfoFormValidator(){
	if($('#resInfoForm').data('bootstrapValidator')){
		$('#resInfoForm').data('bootstrapValidator').destroy();
	}
	$('#resInfoForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	name: {
                validators: {
                    notEmpty: {
                        message: '资源名称不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 64,
                        message: '资源名称为1~64位'
                    }
                }
            },
            url: {
            	validators: {
            		notEmpty: {
            			message: '资源路径不能为空'
            		},
            		stringLength: {
            			min: 1,
            			max: 64,
            			message: '资源路径为1~100位'
            		}
            	}
            },
            resourceType: {
            	validators: {
            		notEmpty: {
            			message: '资源类型不能为空'
            		}
            	}
            },
            openMode: {
            	validators: {
            		notEmpty: {
            			message: '资源打开方式不能为空'
            		}
            	}
            },
            status: {
            	validators: {
            		notEmpty: {
            			message: '资源状态不能为空'
            		}
            	}
            },
            seq: {
            	validators: {
            		notEmpty: {
            			message: '资源排序不能为空'
            		},
            		integer: {
            			message: '资源排序必须为数字'
            		}
            	}
            }
        }
    });
}
/**
 * 渲染资源树列表
 */
function drawResTreeTable(){
	blockUI();
	jsonAjax(appPath + "/resource/queryAll",null,function(data){
		
		var htmlArr = new Array();
		htmlArr.push('<tr>');
		htmlArr.push('<td>资源名称</td>');
		htmlArr.push('<td>资源路径</td>');
		htmlArr.push('<td>打开方式</td>');
		htmlArr.push('<td>排序</td>');
		htmlArr.push('<td>图标</td>');
		htmlArr.push('<td>资源类型</td>');
		htmlArr.push('<td>状态</td>');
		htmlArr.push('<td>创建时间</td>');
		htmlArr.push('<td>操作</td>');
		htmlArr.push('</tr>');
		$(data).each(function(i,res){
//			部门树需要
			res.text = res.name;
			htmlArr.push('<tr class="treegrid-'+res.id+'">');
			commonJoindHtml(res,htmlArr);
			if(res.subResList && res.subResList.length > 0){
//				部门树需要
				res.nodes = res.subResList;
				drawSubRes(res,res.subResList,htmlArr);
			}
		});
		$("#resListTreeTable").find("tbody").html(htmlArr.join(""));
		$('#resListTreeTable').treegrid({
	        expanderExpandedClass: 'glyphicon glyphicon-minus',
	        expanderCollapsedClass: 'glyphicon glyphicon-plus'
	    });
		//初始化资源树
		$('#resTree').treeview({color: "#428bca",data:data,onNodeSelected: function(event, data) {
		    $("#parentResName").attr("readonly",false).val(data.name).attr("readonly",true);
		    $("#pid").attr("readonly",false).val(data.id).attr("readonly",true);
		    $("#resTree").fadeOut("fast");
		}});
		unblockUI();
	});
}

function drawSubRes(parentRes,subResList,htmlArr){
	$.each(subResList,function(i,res){
		res.text = res.name;
		htmlArr.push('<tr class="treegrid-'+res.id+' treegrid-parent-'+parentRes.id+'">');
		commonJoindHtml(res,htmlArr);
		if(res.subResList && res.subResList.length > 0){
			drawSubRes(res,res.subResList,htmlArr);
			res.nodes = res.subResList;
		}
	});
}
function commonJoindHtml(res,htmlArr){
	htmlArr.push('<td style="text-align:left;">'+res.name+'</td>');
	htmlArr.push('<td>'+res.url+'</td>');
	htmlArr.push('<td>'+(res.openMode == null ? '' : res.openMode)+'</td>');
	htmlArr.push('<td>'+res.seq+'</td>');
	htmlArr.push('<td>'+res.icon+'</td>');
	if(res.resourceType == 0){
		htmlArr.push('<td>菜单</td>');
	}else{
		htmlArr.push('<td>按钮</td>');
	}
	if(res.status == 0){
		htmlArr.push('<td>正常</td>');
	}else{
		htmlArr.push('<td>禁用</td>');
	}
	var createTime = new Date(res.createTime);
	htmlArr.push('<td>'+createTime.format("yyyy-MM-dd hh:mm:ss")+'</td>');
	htmlArr.push('<td>');
		htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-warning glyphicon-class" ');
			htmlArr.push('data-toggle="modal" onclick="showResInfoModal('+res.id+')">');
			htmlArr.push('修改');
			htmlArr.push('<span class="glyphicon glyphicon-pencil"></span> ');
		htmlArr.push('</button>');
		htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-danger glyphicon-class" ');
			htmlArr.push('data-toggle="modal" onclick="showDelModal('+res.id+')" >');
			htmlArr.push('删除');
			htmlArr.push('<span class="glyphicon glyphicon-trash"></span> ');
		htmlArr.push('</button>');
	htmlArr.push('</td>');
	htmlArr.push('</tr>');
}
function showResInfoModal(resId){
	$("#resInfoModal input").val("");
	$("#resInfoModal select").val("");
	$('#resInfoModal select').each(function(i,select){
		$(select).find("option").eq(0).attr('selected','selected');
	});
	$("#parentResName").attr("readonly",false).val("").attr("readonly",true);
    $("#pid").attr("readonly",false).val("").attr("readonly",true);
    initResInfoFormValidator();
	if(resId == null || resId == undefined){
		$("#resInfoModalTitle").text("新增");
	}else{
		$("#resInfoModalTitle").text("编辑");
		jsonAjax(appPath + "/resource/"+resId,null,function(res){
			for(var pro in res){
				$("#" + pro).val(res[pro]);
			}
			if(res.parentResource){
				$("#parentResName").attr("readonly",false).val(res.parentResource.name).attr("readonly",true);
			    $("#pid").attr("readonly",false).val(res.parentResource.id).attr("readonly",true);
			}
		},function(){
			notie(3,"获取资源信息失败！",2);
		},"get");
	}
	$("#resInfoModal").modal("show");
}

function onBodyDown(event) {
	if (!(event.target.id == "cleanParentResBtn" 
			|| event.target.id == "selectParentResBtn" 
			|| event.target.id == "resTree" 
			|| $(event.target).parents("#resTree").length>0)) {
		$("#resTree").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
}

function showDelModal(resId){
	$("#delModal").data("resId",resId).modal("show");
	$("#delBtn").unbind("click").bind("click",function(){
		$("#delModal").modal("hide");
		blockUI();
		var resId = $("#delModal").data("resId");
		jsonAjax(appPath + "/resource/" + resId,null,function(){
			unblockUI();
			drawResTreeTable();
		},function(){
			unblockUI();
			notie.alert(3,"删除失败",2);
		},"delete");
	});
}