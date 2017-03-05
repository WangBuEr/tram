$(function() {
	$('#beginReleasePaymentsDate').datetimepicker({
		format : 'yyyy-mm-dd',
		language : 'zh-CN',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});
	$('#endReleasePaymentsDate').datetimepicker({
		format : 'yyyy-mm-dd',
		language : 'zh-CN',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0,
		endDate:new Date()
	});
	$("#searchBth").bind("click", function() {
		statisticsQuery();
	});
	statisticsQuery();
});

function statisticsQuery(){
	blockUI();
	jsonAjax(path + "/report/statistics",
			$("#searchForm").serializeObject(),
			function(data){
		for(var magic in data){
			$("#" + magic).text(data[magic]);
			unblockUI();
		}
	});
}