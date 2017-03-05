var searchTable = initTable();
$(function() {
	initTotalPayment();
	$("#searchBth").bind("click", function() {
		searchTable.ajax.reload();
		initTotalPayment();
	});
});

function initTotalPayment(){
	var searchParam = $("#searchForm").serializeObject();
	if(receivePaymentsStatus == 0
			|| receivePaymentsStatus == 1
			|| receivePaymentsStatus == 2){
		searchParam.receivePaymentsStatus = receivePaymentsStatus;
	}
	jsonAjax(path + "/receive/totalPayment",
			searchParam,function(data){
		$("#totalPayment").text("应回款"+data+"元");
		
	});
}
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
			url : path + "/receive/query",
			type:"POST",
			data : function(data) {
				var searchParam = $("#searchForm").serializeObject();
				$.extend(data, searchParam);
				if(receivePaymentsStatus == 0
						|| receivePaymentsStatus == 1
						|| receivePaymentsStatus == 2){
					data.receivePaymentsStatus = receivePaymentsStatus;
				}
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
        	{data:'phone'},
        	{data:'cardNumber'},
        	{data:'carModels'},
        	{data:'loan.amount'},
        	{data:'totalRepaymentAmount'},
        	{data:'loan.stageNumber'},
        	{data:'remainingPeriod'},
            {
        		data:'examineTime',
        		render : function(data, type, row, meta) { 
        			var htmlArr = new Array();
        			htmlArr.push('<a style="margin-left:8px;" data-pjax href="'+path+'/customer/details/'+row.id+'" class="btn btn-primary glyphicon-class">');
	    				htmlArr.push('详情');
	    				htmlArr.push('<span class="glyphicon glyphicon-user"></span> ');
	    			htmlArr.push('</a>');
    				htmlArr.push('<button style="margin-left:8px;" type="button" class="btn btn-info glyphicon-class" ');
    					htmlArr.push('data-toggle="modal"');
    					htmlArr.push('onclick="showManualReceivePaymentModal('+row.id+',\''+row.name+'\','+row.loan.stageNumber+','+row.remainingPeriod+','+row.currentRepayment+')" >');
    					htmlArr.push('手动回款');
    					htmlArr.push('<span class="glyphicon glyphicon-thumbs-up"></span> ');
    				htmlArr.push('</button>');
        			return htmlArr.join("");
        		}
            }
        	
		]
	});
}

function showManualReceivePaymentModal(customerId,customerName,stageNumber,remainingPeriod,currentRepayment){
	if($("#manualReceivePaymentForm").data('bootstrapValidator')){
		$("#manualReceivePaymentForm").data('bootstrapValidator').destroy();
	}
	$("#periods").empty();
	for(var i = 1; i <= remainingPeriod; i++){
		$("#periods").append("<option value='"+i+"'>"+i+"</option>");
	}
	$('#manualReceivePaymentForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	periods: {
            	validators: {
            		notEmpty: {
            			message: '回款期数不能为空'
            		}
            	}
            }
   
        }
    });
	$("#hint").html("<p>应回款"+currentRepayment+"元，确认收到客户"+customerName+"的回款？</p>");
	
	$("#periods").unbind("change").bind("change",function(){
		$("#hint").html("<p>应回款"+(currentRepayment * $("#periods").val()).toFixed(2)+"元，确认收到客户"+customerName+"的回款？</p>");
	});
	$("#manualReceivePaymentModal").modal('show');
	
//	回款事件绑定
	$("#paymentBtn").unbind("click").bind("click",function(){
		$("#manualReceivePaymentForm").data('bootstrapValidator').validate();
		if(!$("#manualReceivePaymentForm").data('bootstrapValidator').isValid()){
			return false;
		}
		$("#manualReceivePaymentModal").modal('hide');
		blockUI();
		var param = {
				customerId:customerId,
				stageNumber:stageNumber,
				remainingPeriod:remainingPeriod,
				periods:$("#periods").val()
		}
		jsonAjax(path + "/receive/manualReceivePayment",
				param,function(data){
			unblockUI();
			notie.alert(1,"回款成功！",1);
			searchTable.draw(false);
			
		});
	});
}