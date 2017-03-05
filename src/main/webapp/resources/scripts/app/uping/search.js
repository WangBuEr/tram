var searchTable = initTable();
$(function() {
	$('#upingDate').datetimepicker({
		    format: 'yyyy-mm-dd',
		    language:  'zh-CN',
		    weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0,
			endDate:new Date()
	});
	$("#searchBth").bind("click", function() {
		searchTable.ajax.reload();
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
			url : path + "/uping/query",
			data : function(data) {
				var searchParam = $("#searchForm").serializeObject();
				$.extend(data, searchParam);
			}
		},
		"createdRow": function (row, data, index ){
			if(data.status == 1){
				$('td', row).css('color','blue');
			}else if(data.status == 2){
				$('td', row).css('color','red');
			}else if(data.status > 2){
				$('td', row).css('color','green');
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
        	{data:'cardNumber'},
        	{data:'phone'},
        	{data:'carModels'},
        	{data:'carPrice'},
        	{
        		data:'loan',
        		render : function(data, type, row, meta) {
        			if(data){
        				return data.stageNumber;
        			}else{
        				return "未填写";
        			}
        		}
        	},
        	{
        		data:'status',
        		render : function(data, type, row, meta) { 
        			switch(data){
        			case 0:
        				return "待上报";
        				break;
        			case 1:
        				return "审核中";
        				break;
        			case 2:
        				return "审核驳回";
        				break;
        			case 3:
        				return "待放款";
        				break;
        			case 4:
        				return "回款中";
        				break;
        			case 5:
        				return "逾期中";
        				break;
        			case 6:
        				return "完结";
        				break;
        			}
        		}
            },
            {
            	data:'upingTime',
            	render:function(data, type, row, meta){
            		var upingTime = new Date(data);
            		return upingTime.format("yyyy-MM-dd hh:mm:ss"); 
            	}
            },
            {
        		data:'upingTime',
        		render : function(data, type, row, meta) { 
        			var htmlArr = new Array();
        			if(row.status == 0 || row.status == 2 ){
        				htmlArr.push('<button type="button" class="btn btn-info glyphicon-class"');
        					htmlArr.push('data-toggle="modal" onclick="showUpingModal('+row.id+')">');
        					htmlArr.push('上报');
        					htmlArr.push('<span class="glyphicon glyphicon-upload"></span>');
        				htmlArr.push('</button>');
        			}
        			if(row.status < 3){
        				htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-warning glyphicon-class" ');
        					htmlArr.push('data-toggle="modal" onclick="showEditCutomerModal('+row.id+','+row.preStatus+')">');
        					htmlArr.push('修改');
        					htmlArr.push('<span class="glyphicon glyphicon-pencil"></span> ');
        				htmlArr.push('</button>');
        				htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-danger glyphicon-class" ');
        					htmlArr.push('data-toggle="modal" onclick="showDelModal('+row.id+')" >');
        					htmlArr.push('删除');
        					htmlArr.push('<span class="glyphicon glyphicon-trash"></span> ');
        				htmlArr.push('</button>');
        			}
        			htmlArr.push('<a style="margin-left:8px;" data-pjax href="'+path+'/customer/details/'+row.id+'" class="btn btn-primary glyphicon-class">');
        				htmlArr.push('详情');
        				htmlArr.push('<span class="glyphicon glyphicon-user"></span> ');
        			htmlArr.push('</a>');
        			return htmlArr.join("");
        		}
            }
        	
		]
	});
}


function showDelModal(customerId){
	$("#delCutomerModal").modal('show');
	$("#delBtn").unbind("click").bind("click",function(){
		$("#delCutomerModal").modal('hide');
		blockUI();
		jsonAjax(path + "/uping/deleteCustomer/" + customerId,null,function(){
			searchTable.draw(false);
			$("#delBtn").attr("disabled",false);
			unblockUI();
		},
		function(){
			notie.alert(3,"删除客户失败",2);
			$("#delBtn").attr("disabled",false);
			unblockUI();
		});
	});
}
function showUpingModal(customerId){
	$("#upingCutomerModal").modal('show');
	$("#upingBtn").unbind("click").bind("click",function(){
		$("#upingCutomerModal").modal('hide');
		blockUI();
		jsonAjax(path + "/uping/upingCustomer/" + customerId,null,function(){
			searchTable.draw(false);
			$("#upingBtn").attr("disabled",false);
			unblockUI();
		},
		function(){
			notie.alert(3,"上报客户失败",2);
			$("#upingBtn").attr("disabled",false);
			unblockUI();
		});
	});
}


function showEditCutomerModal(customerId,preStatus){
	$("#examineComments").text("");
	if(preStatus != null && (preStatus == 1 || preStatus == 2)){
		jsonAjax(path + "/customer/queryApprovalFailure/" + customerId,null,function(data){
			$("#examineComments").text(data);
		},
		function(){
			notie.alert(2,"获取审批意见失败",2);
		});
		
	}
	$("#editCutomerModal .modal-body a").each(function(i,v){
		var href = $(v).attr("href");
		href = href.split("?")[0] + "?customerId=" +  customerId;
		$(v).attr("href",href);
	});
	
	
	$("#editCutomerModal").modal('show');
}