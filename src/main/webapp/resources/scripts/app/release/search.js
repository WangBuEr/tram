var searchTable = initTable();
$(function() {
	$("#searchBth").bind("click", function() {
		searchTable.ajax.reload();
	});
	$("#bankWaterImg").fileinput({
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
		initialCaption: "请上传银行流水照片",//文本框初始话value
		uploadExtraData : {
			token : uploadToken
		},
		showUploadedThumbs:false,
		autoReplace:true
	}).on('fileuploaded', function(event, data, previewId, index) {
		$("input[name='bankWaterImg']").val(data.response.key);
	}).on('filebatchuploadcomplete', function(event, files, extra) {
		var paramObj = {
				customerId:$("#loanModal").data("customerId"),
				releasePaymentsNumber:$("#releasePaymentsNumber").val(),
				imageId:$("input[name='bankWaterImg']").val()
		};
		jsonAjax(path + "/release/loan",paramObj,function(){
			unblockUI();
			searchTable.draw(false);
			$("#loanOperation button").attr("disabled",false);
		},
		function(){
			notie.alert(3,"放款失败",2);
			$("#loanModal").modal('show');
			$("##loanOperation button").attr("disabled",false);
			unblockUI();
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
			url : path + "/release/query",
			data : function(data) {
				var searchParam = $("#searchForm").serializeObject();
				$.extend(data, searchParam);
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
        	{data:'loan.amount'},
        	{data:'loan.stageNumber'},
        	{data:'examineUser.name'},
        	{
            	data:'examineTime',
            	render:function(data, type, row, meta){
            		var upingTime = new Date(data);
            		return upingTime.format("yyyy-MM-dd hh:mm:ss"); 
            	}
            },
            {
        		data:'examineTime',
        		render : function(data, type, row, meta) { 
        			var htmlArr = new Array();
    				htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-info glyphicon-class" ');
    					htmlArr.push('data-toggle="modal" onclick="showLoanModal('+row.id+')" >');
    					htmlArr.push('放款');
    					htmlArr.push('<span class="glyphicon glyphicon-usd"></span> ');
    				htmlArr.push('</button>');
        			return htmlArr.join("");
        		}
            }
        	
		]
	});
}

function showLoanModal(customerId){
	$("#releasePaymentsNumber").val("");
	$("#bankWaterImg").fileinput("clear");
	$("#loanModal").data("customerId",customerId);
	$("#loanModal").modal('show');
	$("#loanBtn").unbind("click").bind("click",function(){
		$("#loanOperation button").attr("disabled",true);
		if($.trim($("#releasePaymentsNumber").val()) == '' || $("#releasePaymentsNumber").val() == null){
			notie.alert(2,"请填写银行流水号",2);
			$("#loanOperation button").attr("disabled",false);
			return false;
		}
		if($("#bankWaterImg").fileinput("getFileStack").length == 0){
			notie.alert(2,"请上传银行流水照片",2);
			$("#loanOperation button").attr("disabled",false);
			return false;
		}
		$("#loanModal").modal('hide');
		$("#bankWaterImg").fileinput("upload");
		blockUI();
	});
}