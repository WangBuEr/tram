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
			forceParse: 0
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
			url : path + "/customer/query",
			data : function(data) {
				var searchParam = $("#searchForm").serializeObject();
				$.extend(data, searchParam);
			}
		},
		"createdRow": function (row, data, index ){
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
        	{
        		data:'loan',
        		render : function(data, type, row, meta) {
        			if(data){
        				return data.amount;
        			}else{
        				return "未填写";
        			}
        		}
        	},
        	{data:'totalRepaymentAmount'},
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
        		data:'loan',
        		render : function(data, type, row, meta) {
        			if(data){
        				return row.remainingPeriod;
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
