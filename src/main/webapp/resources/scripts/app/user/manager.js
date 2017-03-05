var searchTable = initTable();
$(function() {
	$("#searchBth").bind("click", function() {
		searchTable.ajax.reload();
	});
	//初始化部门树
	initOrgTree();
});

function initTable() {
	return $('#searchTable').DataTable({
		paging : true,
		ordering : false,
		info : true,
		searching : false,
		bLengthChange : false,
		method:"post",
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
			url : path + "/user/query",
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
        	{data:'loginName'},
        	{data:'name'},
        	{data:'organization.name'},
        	{data:'sex',render:function(data, type, row, meta){
        		if(data == 1){
        			return "男";
        		}else{
        			return "女";
        		}
        	}},
        	{data:'age'},
        	{data:'phone'},
        	{data:'roleList',render:function(data, type, row, meta){
        		if(data && data.length > 0){
        			var roleArr = new Array();
        			$(data).each(function(i,role){
        				roleArr.push(role.name + "(" + role.description + ")");
        			});
        			return roleArr.join(",");
        		}else{
        			return "";
        		}
        	}},
        	{
        		data:'userType',
        		render : function(data, type, row, meta) {
        			if(data == 0){
        				return "管理员";
        			}else{
        				return "用户";
        			}
        		}
        	},
            {
            	data:'status',
            	render:function(data, type, row, meta){
            		if(data == 0){
        				return "正常";
        			}else{
        				return "禁用";
        			}
            	}
            },
            {
        		data:'id',
        		render : function(data, type, row, meta) { 
        			var htmlArr = new Array();
        			htmlArr.push('<a style="margin-left:8px;" data-pjax href="'+path+'/user/addOrUpdate?userId='+row.id+'" class="btn btn-primary glyphicon-class">');
	    				htmlArr.push('编辑');
	    				htmlArr.push('<span class="glyphicon glyphicon-edit"></span> ');
	    			htmlArr.push('</a>');
    				htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-danger glyphicon-class" ');
    					htmlArr.push('data-toggle="modal" onclick="showDelModal('+row.id+')" >');
    					htmlArr.push('删除');
    					htmlArr.push('<span class="glyphicon glyphicon-remove"></span> ');
    				htmlArr.push('</button>');
        			return htmlArr.join("");
        		}
            }
        	
		]
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
		//初始化部门树
		$('#searchOrgTree').treeview({
			showIcon:false,
			color: "#428bca",
			data:orgList,onNodeSelected: function(event, data) {
			    $("#searchOrgName").attr("readonly",false).val(data.name).attr("readonly",true);
			    $("#searchOrganizationId").attr("readonly",false).val(data.id).attr("readonly",true);
			    $("#searchOrgTree").fadeOut("fast");
		}});
	});
	
	$("#searchSelectOrgBtn").bind("click",function(){
		if($("#searchOrgTree").is(":hidden")){
			$("#searchOrgTree").show().width($("#searchSelectOrgBtn").parent().parent().width());
			$("body").bind("mousedown", onBodyDown);
		}else{
			$("#searchOrgTree").fadeOut("fast");
		}
	});
	$("#searchCleanOrgBtn").bind("click",function(){
		 $("#searchOrgName").attr("readonly",false).val("").attr("readonly",true);
		    $("#searchOrganizationId").attr("readonly",false).val("").attr("readonly",true);
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
	if (!(event.target.id == "searchCleanOrgBtn"
			|| event.target.id == "searchSelectOrgBtn" 
			|| event.target.id == "searchOrgTree" 
			|| $(event.target).parents("#searchOrgTree").length>0)) {
		$("#searchOrgTree").fadeOut("fast");
		$("#userInfoOrgTree").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
}

function showDelModal(userId){
	$("#delModal").data("userId",userId).modal("show");
	$("#delBtn").unbind("click").bind("click",function(){
		$("#delModal").modal("hide");
		blockUI();
		var orgId = $("#delModal").data("orgId");
		jsonAjax(appPath + "/user/" + userId,null,function(){
			unblockUI();
			searchTable.draw(false);
		},function(data){
			unblockUI();
			notie.alert(3,data.message,2);
		},"delete");
	});
}
