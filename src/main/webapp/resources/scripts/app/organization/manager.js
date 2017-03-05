$(function(){
	drawOrgTreeTable();
	$("#addBtn").bind("click",function(){
		showOrgInfoModal();
	});
	
	$("#cleanOrgBtn").bind("click",function(){
		$("#parentOrgName").attr("readonly",false).val("").attr("readonly",true);
	    $("#pid").attr("readonly",false).val("").attr("readonly",true);
	});
	$("#addOrUpdateOrgBtn").bind("click",function(){
		$("#orgInfoForm").data('bootstrapValidator').validate();
		if(!$("#orgInfoForm").data('bootstrapValidator').isValid()){
			return false;
		}
		$("#orgInfoModal").modal('hide');
		blockUI();
		jsonAjax(appPath +"/organization/addOrUpdate",
				$("#orgInfoForm").serializeObject(),function(data){
			unblockUI();
			drawOrgTreeTable();
		});
	});
	
//	初始化部门信息对话框属性
	$("#orgInfoModal").modal({backdrop: 'static', keyboard: false,show:false});
	$("#selectOrgBtn").bind("click",function(){
		if($("#orgTree").is(":hidden")){
			$("#orgTree").show().width($("#selectOrgBtn").parent().parent().width());
			$("body").bind("mousedown", onBodyDown);
		}else{
			$("#orgTree").fadeOut("fast");
		}
	});
});
function initOrgInfoFormValidator(){
	if($('#orgInfoForm').data('bootstrapValidator')){
		$('#orgInfoForm').data('bootstrapValidator').destroy();
	}
	$('#orgInfoForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	name: {
                validators: {
                    notEmpty: {
                        message: '部门名称不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 64,
                        message: '部门名称为1~64位'
                    }
                }
            },
            seq: {
            	validators: {
            		notEmpty: {
            			message: '部门排序不能为空'
            		},
            		integer: {
            			message: '部门排序必须为数字'
            		}
            	}
            }
        }
    });
}
/**
 * 渲染部门树列表
 */
function drawOrgTreeTable(){
	blockUI();
	jsonAjax(appPath + "/organization/queryAll",null,function(data){
		
		var htmlArr = new Array();
		htmlArr.push('<tr>');
		htmlArr.push('<td>部门名称</td>');
		htmlArr.push('<td>排序</td>');
		htmlArr.push('<td>创建时间</td>');
		htmlArr.push('<td>操作</td>');
		htmlArr.push('</tr>');
		$(data).each(function(i,org){
//			部门树需要
			org.text = org.name;
			htmlArr.push('<tr class="treegrid-'+org.id+'">');
			commonJoindHtml(org,htmlArr);
			if(org.subOrgList && org.subOrgList.length > 0){
//				部门树需要
				org.nodes = org.subOrgList;
				drawSubOrg(org,org.subOrgList,htmlArr);
			}
		});
		$("#orgListTreeTable").find("tbody").html(htmlArr.join(""));
		$('#orgListTreeTable').treegrid({
	        expanderExpandedClass: 'glyphicon glyphicon-minus',
	        expanderCollapsedClass: 'glyphicon glyphicon-plus'
	    });
		//初始化部门树
		$('#orgTree').treeview({color: "#428bca",data:data,onNodeSelected: function(event, data) {
		    $("#parentOrgName").attr("readonly",false).val(data.name).attr("readonly",true);
		    $("#pid").attr("readonly",false).val(data.id).attr("readonly",true);
		    $("#orgTree").fadeOut("fast");
		}});
		unblockUI();
	});
}

function drawSubOrg(parentOrg,subOrgList,htmlArr){
	$.each(subOrgList,function(i,org){
		org.text = org.name;
		htmlArr.push('<tr class="treegrid-'+org.id+' treegrid-parent-'+parentOrg.id+'">');
		commonJoindHtml(org,htmlArr);
		if(org.subOrgList && org.subOrgList.length > 0){
			drawSubOrg(org,org.subOrgList,htmlArr);
			org.nodes = org.subOrgList;
		}
	});
}
function commonJoindHtml(org,htmlArr){
	htmlArr.push('<td style="text-align:left;">'+org.name+'</td>');
	htmlArr.push('<td>'+org.seq+'</td>');
	var createTime = new Date(org.createTime);
	htmlArr.push('<td>'+createTime.format("yyyy-MM-dd hh:mm:ss")+'</td>');
	htmlArr.push('<td>');
		htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-warning glyphicon-class" ');
			htmlArr.push('data-toggle="modal" onclick="showOrgInfoModal('+org.id+')">');
			htmlArr.push('修改');
			htmlArr.push('<span class="glyphicon glyphicon-pencil"></span> ');
		htmlArr.push('</button>');
		htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-danger glyphicon-class" ');
			htmlArr.push('data-toggle="modal" onclick="showDelModal('+org.id+')" >');
			htmlArr.push('删除');
			htmlArr.push('<span class="glyphicon glyphicon-trash"></span> ');
		htmlArr.push('</button>');
	htmlArr.push('</td>');
	htmlArr.push('</tr>');
}
function showOrgInfoModal(orgId){
	$("#id").val("");
	$("#name").val("");
	$("#seq").val(0);
	$("#parentOrgName").attr("readonly",false).val("").attr("readonly",true);
    $("#pid").attr("readonly",false).val("").attr("readonly",true);
    initOrgInfoFormValidator();
	if(orgId == null || orgId == undefined){
		$("#orgInfoModalTitle").text("新增");
	}else{
		$("#orgInfoModalTitle").text("编辑");
		jsonAjax(appPath + "/organization/"+orgId,null,function(org){
			$("#id").val(org.id);
			$("#name").val(org.name);
			$("#seq").val(org.seq);
			if(org.parentOrg){
				$("#parentOrgName").attr("readonly",false).val(org.parentOrg.name).attr("readonly",true);
			    $("#pid").attr("readonly",false).val(org.parentOrg.id).attr("readonly",true);
			}
		},function(){
			notie(3,"获取部门信息失败！",2);
		},"get");
	}
	$("#orgInfoModal").modal("show");
}

function onBodyDown(event) {
	if (!(event.target.id == "cleanOrgBtn" 
			|| event.target.id == "selectOrgBtn" 
			|| event.target.id == "orgTree" 
			|| $(event.target).parents("#orgTree").length>0)) {
		$("#orgTree").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
}

function showDelModal(orgId){
	$("#delModal").data("orgId",orgId).modal("show");
	$("#delBtn").unbind("click").bind("click",function(){
		$("#delModal").modal("hide");
		blockUI();
		var orgId = $("#delModal").data("orgId");
		jsonAjax(appPath + "/organization/" + orgId,null,function(){
			unblockUI();
			drawOrgTreeTable();
		},function(){
			unblockUI();
			notie.alert(3,"删除失败",2);
		},"delete");
	});
}