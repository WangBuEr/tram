<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/variable.jsp"%>
<div class="side">
	<ul style="list-style: none;">
		<li><a href="javascript:void(0);" data-toggle="modal" data-target="#examineModal">
				<div class="sidebox">
					<img src="${contextPath}/resources/img/common/edit_64x64.png" />审核
				</div>
		</a></li>
	</ul>
</div>

<!-- 	审批意见 -->
<div class="modal fade" id="examineModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title">审批意见</h4>
			</div>
			<div class="modal-body text-center">
				<textarea id="examineComments" rows="6" style="width: 100%;" placeholder="请输入审批意见"></textarea>
			</div>
			<div class="modal-footer" id="examineOperation">
				<button id="rejectBtn" type="button" class="btn btn-danger">驳回</button>
				<button type="button" class="btn btn-primary">通过</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script type="text/javascript">
$("#examineOperation button").unbind("click").bind("click",function(){
	$("#examineOperation button").attr("disabled",true);
	$("#examineModal").modal('hide');
	$.blockUI({ message: "<image src='"+ path +"/resources/img/common/5-160914192R0.gif' />" });
	var paramObj =  {
		customerId:${customer.id},
		examineComments:$("#examineComments").val(),
		agree:$(this).attr("id") == "rejectBtn"? 0 : 1
	}
	jsonAjax(path + "/examine/approve/",paramObj,function(){
		$.unblockUI();
		$("#examineOperation button").attr("disabled",false);
		$.pjax.reload('.content-wrapper', {
			fragment : ".content-wrapper",
			cache : false,
			url : path + "/examine/search"
		});
	},
	function(){
		//TODO 
		alert("审批客户失败");
		$("##examineOperation button").attr("disabled",false);
		$.unblockUI();
	});
});
</script>