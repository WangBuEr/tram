var searchTable = initTable();
$(function() {
	$("#addBtn").bind("click",function(){
		showRoleInfoModal();
	});
	
	$("#addOrUpdateBtn").bind("click",function(){
		$("#roleInfoForm").data('bootstrapValidator').validate();
		if(!$("#roleInfoForm").data('bootstrapValidator').isValid()){
			return false;
		}
		$("#roleInfoModal").modal('hide');
		blockUI();
		jsonAjax(appPath +"/role/addOrUpdate",
				$("#roleInfoForm").serializeObject(),function(data){
			unblockUI();
			searchTable.draw(false);
		});
	});
});
function initTable() {
	return $('#searchTable').DataTable({
		paging : true,
		ordering : false,
		info : true,
		searching : false,
		bLengthChange : false,
		language : {
			paginate : {//分页的样式内容。
				previous : "上一页",
				next : "下一页",
				first : "第一页",
				last : "最后"
			},
			zeroRecords : "对不起，查询不到任何相关数据",
			info : "总共_PAGES_页，显示第_PAGE_页",
			infoEmpty : "没有记录"
		},
		serverSide : true,
		ajax : {
			url : path + "/role/query",
			data : function(data) {
				var searchParam = $("#searchForm").serializeObject();
				$.extend(data, searchParam);
			}
		},
		"createdRow": function (row, data, index ){
			if(data.preStatus != null && data.preStatus == 2){
				$('td', row).css('color','red');
			}
		},
		columns : [
			{
        		data : null,  
                bSortable : false,  
                targets : 0,  
                width:"50px",
                render : function(data, type, row, meta) {  
                    // 显示行号  
                    var startIndex = meta.settings._iDisplayStart;  
                    return startIndex + meta.row + 1;  
                }  
        	},
        	{data:'name'},
        	{data:'seq'},
        	{data:'description'},
        	{
        		data:'status',
        		render : function(data, type, row, meta) {
        			if(data == 0){
        				return "正常";
        			}else{
        				return "禁用";
        			}
        		}
        	},
            {
        		data:'status',
        		render : function(data, type, row, meta) { 
        			var htmlArr = new Array();
	    			htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-info glyphicon-class" ');
						htmlArr.push('data-toggle="modal" onclick="showAuthorizationModal('+row.id+')" >');
						htmlArr.push('授权');
						htmlArr.push('<span class="glyphicon glyphicon-lock"></span> ');
					htmlArr.push('</button>');
    				htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-primary glyphicon-class" ');
    					htmlArr.push('data-toggle="modal" onclick="showRoleInfoModal('+row.id+')" >');
    					htmlArr.push('编辑');
    					htmlArr.push('<span class="glyphicon glyphicon-edit"></span> ');
    				htmlArr.push('</button>');
    				htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-danger glyphicon-class" ');
						htmlArr.push('data-toggle="modal" onclick="showDelModal('+row.id+')" >');
						htmlArr.push('删除');
						htmlArr.push('<span class="glyphicon glyphicon-trash"></span> ');
					htmlArr.push('</button>');
        			return htmlArr.join("");
        		}
            }
        	
		]
	});
}
function initRoleInfoFormValidator(){
	if($('#roleInfoForm').data('bootstrapValidator')){
		$('#roleInfoForm').data('bootstrapValidator').destroy();
	}
	$('#roleInfoForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	name: {
                validators: {
                    notEmpty: {
                        message: '角色名称不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 64,
                        message: '角色名称为1~64位'
                    }
                }
            },
            seq: {
            	validators: {
            		notEmpty: {
            			message: '角色排序不能为空'
            		},
            		integer: {
            			message: '角色排序必须为数字'
            		}
            	}
            },
            description: {
                validators: {
                    notEmpty: {
                        message: '角色描述不能为空'
                    },
                    stringLength: {
                        min: 1,
                        max: 64,
                        message: '角色描述为1~255位'
                    }
                }
            }
        }
    });
	
}
function showRoleInfoModal(roleId){
	$("#id").val("");
	$("#name").val("");
	$("#seq").val(0);
	$("#description").val("");
    $("#status").val(0);
    initRoleInfoFormValidator();
	if(roleId == null || roleId == undefined){
		$("#roleInfoModalTitle").text("新增");
		$("#name").attr("readonly",false);
	}else{
		$("#roleInfoModalTitle").text("编辑");
		$("#name").attr("readonly",true);
		jsonAjax(appPath + "/role/"+roleId,null,function(role){
			$("#id").val(role.id);
			$("#name").val(role.name);
			$("#seq").val(role.seq);
			$("#description").val(role.description);
		    $("#status").val(role.status);
		},function(){
			notie(3,"获取角色信息失败！",2);
		},"get");
	}
	$("#roleInfoModal").modal("show");
}

function showDelModal(roleId){
	$("#delModal").data("roleId",roleId).modal("show");
	$("#delBtn").unbind("click").bind("click",function(){
		$("#delModal").modal("hide");
		blockUI();
		var roleId = $("#delModal").data("roleId");
		jsonAjax(appPath + "/role/" + roleId,null,function(){
			unblockUI();
			searchTable.draw(false);
		},function(){
			unblockUI();
			notie.alert(3,"删除失败",2);
		},"delete");
	});
}
/**
 * 显示授权窗口
 * @param roleId
 * @returns
 */
function showAuthorizationModal(roleId){
	//获取该角色拥有的资源
	jsonAjax(appPath + "/role/roleResource/" + roleId,null,function(resList){
		var roleResArr = new Array();
		$(resList).each(function(i,res){
			roleResArr.push(res.resourceId);
		});
		jsonAjax(appPath + "/resource/queryAll",null,function(resList){
			$(resList).each(function(i,res){
				res.text = res.name;
				if(roleResArr.inArray(res.id)){
					res.state  = {checked:true};
				}else{
					res.state  = {checked:false};
				}
				if(res.subResList && res.subResList.length > 0){
					res.nodes = res.subResList;
					setResTest(res.subResList,roleResArr);
				}
			});
			//初始化资源树
			$('#resourceTree').treeview({
						showCheckbox:true,
						showIcon:false,
//						color: "#428bca",
						data:resList
			});
		});
		
	});
	$("#authorizationModal").modal("show");
	//全选绑定事件
	$("#selectAllBtn").unbind("click").bind("click",function(){
		$('#resourceTree').treeview("checkAll");
	});
	//反选绑定事件
	$("#reverseSelectionBtn").unbind("click").bind("click",function(){
		var uncheckedNodeList =  $('#resourceTree').treeview("getUnchecked");
		var checkedNodeList =  $('#resourceTree').treeview("getChecked");
		$(uncheckedNodeList).each(function(i,node){
			$('#resourceTree').treeview("checkNode",node);
		});
		$(checkedNodeList).each(function(i,node){
			$('#resourceTree').treeview("uncheckNode",node);
		});
	});
	
	$("#authorizationBtn").unbind("click").bind("click",function(){
		blockUI();
		$("#authorizationModal").modal("hide");
		var checkedNodeList =  $('#resourceTree').treeview("getChecked");
		var resList = new Array();
		$(checkedNodeList).each(function(i,node){
			resList.push(node.id);
		});
		jsonAjax(appPath + "/role/authorization/" + roleId,{resList:resList,},function(){
			unblockUI();
		});
	});
}

function setResTest(resList,roleResArr){
	$(resList).each(function(i,res){
		res.text = res.name;
		if(roleResArr.inArray(res.id)){
			res.state  = {checked:true};
		}else{
			res.state  = {checked:false};
		}
		if(res.subResList && res.subResList.length > 0){
			setResTest(res.subResList,roleResArr);
			res.nodes = res.subResList
		}
	});
}