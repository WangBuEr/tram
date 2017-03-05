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
			url : path + "/examine/query",
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
        	{data:'upingUser.name'},
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
        			htmlArr.push('<a style="margin-left:8px;" data-pjax href="'+path+'/customer/details/'+row.id+'" class="btn btn-primary glyphicon-class">');
	    				htmlArr.push('详情');
	    				htmlArr.push('<span class="glyphicon glyphicon-user"></span> ');
	    			htmlArr.push('</a>');
    				htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-danger glyphicon-class" ');
    					htmlArr.push('data-toggle="modal" onclick="showExamineModal('+row.id+','+row.preStatus+')" >');
    					htmlArr.push('审批');
    					htmlArr.push('<span class="glyphicon glyphicon-edit"></span> ');
    				htmlArr.push('</button>');
        			return htmlArr.join("");
        		}
            }
        	
		]
	});
}

function showExamineModal(customerId,preStatus){
	$("#failComments").remove();
	if(preStatus != null && preStatus == 2){
		jsonAjax(path + "/customer/queryApprovalFailure/" + customerId,null,function(data){
			$('<div id="failComments" class="callout callout-danger"><p>'+data+'</p></div>').prependTo($("#examineModalBody"));
		},
		function(){
			notie.alert(2,"获取上次审批意见失败",2);
		});
		
	}
	$("#examineModal").modal('show');
	$("#examineOperation button").unbind("click").bind("click",function(){
		$("#examineOperation button").attr("disabled",true);
		$("#examineModal").modal('hide');
		blockUI();
		var paramObj =  {
			customerId:customerId,
			examineComments:$("#examineComments").val(),
			agree:$(this).attr("id") == "rejectBtn"? 0 : 1
		}
		jsonAjax(path + "/examine/approve/",paramObj,function(){
			unblockUI();
			searchTable.draw(false);
			$("#examineOperation button").attr("disabled",false);
		},
		function(){
			notie.alert(2,"审批客户失败",2);
			$("##examineOperation button").attr("disabled",false);
			unblockUI();
		});
	});
}