<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/variable.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>电车金融</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <jsp:include page="/WEB-INF/views/common/style.jsp"></jsp:include>
  <!-- REQUIRED JS SCRIPTS -->
  <jsp:include page="/WEB-INF/views/common/script.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue  sidebar-mini">
<div class="wrapper">
  <jsp:include page="/WEB-INF/views/common/mainHeader.jsp"></jsp:include>
  <!-- Left side column. contains the logo and sidebar -->
  <jsp:include page="/WEB-INF/views/common/leftSide.jsp"></jsp:include>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>上报客户</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="glyphicon glyphicon-backward"></i> 返回</a></li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row" style="padding-bottom: 30px;">
					<div class="step-body" id="step">
						<div class="step-header" style="width:80%">
							<ul>
								<li><p>基本信息</p></li>
								<li><p>贷款信息</p></li>
								<li><p>合同信息</p></li>
							</ul>
						</div>
					</div>
				</div>
				<form class="form-horizontal" role="form" id="customerLoan">
					<div class="row">
						<div class="form-group  col-sm-6">
							<input type="hidden" name="id" value="${loan.id}">
							<input type="hidden" name="customerId" value="${param.customerId}">
							<label for="serialNumber" class="col-sm-2 control-label">签约流水号</label>
							<div class="col-sm-10">
								<input value="${loan.serialNumber}" type="text" class="form-control" id="serialNumber"
									name="serialNumber" placeholder="请输入签约流水号">
							</div>
						</div>
						<div class="form-group  col-sm-6">
							<label for="amount" class="col-sm-2 control-label">贷款金额</label>
							<div class="col-sm-10">
								<input value="${loan.amount}" type="text" class="form-control" id="amount"
									name="amount" placeholder="请输入贷款金额">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group  col-sm-6">
							<label for="stageNumber" class="col-sm-2 control-label">分期数</label>
							<div class="col-sm-10">
								<input type="radio" name="stageNumber" value="3" checked="checked">
	              				<label for="input-3">&nbsp;&nbsp;3&nbsp;&nbsp;</label>
								<input ${loan.stageNumber == 6 ? "checked='checked'":""} type="radio" name="stageNumber" value="6">
	              				<label for="input-3">&nbsp;&nbsp;6&nbsp;&nbsp;</label>
								<input ${loan.stageNumber == 9 ? "checked='checked'":""}  type="radio" name="stageNumber" value="9">
	              				<label for="input-3">&nbsp;&nbsp;9&nbsp;&nbsp;</label>
								<input ${loan.stageNumber == 12 ? "checked='checked'":""}  type="radio" name="stageNumber" value="12">
	              				<label for="input-3">&nbsp;&nbsp;12&nbsp;&nbsp;</label>
							</div>
						</div>
						<div class="form-group  col-sm-6">
							<label for="bankAccount" class="col-sm-2 control-label">开户行</label>
							<div class="col-sm-10">
								<select class="form-control" name="bankAccount">
									<option value="1" ${loan.bankAccount == 1 ? "selected='selected'":""}>工商银行</option>									
									<option value="2" ${loan.bankAccount == 2 ? "selected='selected'":""}>建设银行</option>									
									<option value="3" ${loan.bankAccount == 3 ? "selected='selected'":""}>中国银行</option>									
									<option value="4" ${loan.bankAccount == 4 ? "selected='selected'":""}>农业银行</option>									
									<option value="5" ${loan.bankAccount == 5 ? "selected='selected'":""}>邮政储蓄</option>									
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group  col-sm-6">
							<label for="bankBranch" class="col-sm-2 control-label">开户行支行</label>
							<div class="col-sm-10">
								<input value="${loan.bankBranch}" type="text" class="form-control" id="bankBranch"
									name="bankBranch" placeholder="请输入开户行支行">
							</div>
						</div>
						<div class="form-group  col-sm-6">
							<label for="bankCardNumber" class="col-sm-2 control-label">银行卡号</label>
							<div class="col-sm-10">
								<input value="${loan.bankCardNumber}" type="text" class="form-control" id="bankCardNumber"
									name="bankCardNumber" placeholder="请输入银行卡号">
							</div>
						</div>
					</div>
					<div class="row" style="height: 300px;">
						<div class="form-group  col-sm-6">
							<label class="col-sm-2 control-label">&nbsp;</label>
							<div class="col-sm-10">
								<input id="bankCardImg" class="file" type="file" name="file">
								<input for="bankCardImg"  class="img" 
									value='${(loan != null && loan.bankCardImg != null) ? loan.bankCardImg.url : ""}' 
									type="hidden" name="bankCardImg">
							</div>
						</div>
						<div class="form-group  col-sm-6">
							<div class="col-sm-2">&nbsp;</div>
							<div class="col-sm-10">
								<input id="holdBankCardImg" class="file" type="file" name="file">
								<input for="holdBankCardImg"  class="img" 
									value='${(loan != null && loan.holdBankCardImg != null) ? loan.holdBankCardImg.url : ""}' 
									type="hidden" name="holdBankCardImg">
							</div>
						</div>
					</div>
				
					
					<div class="form-group" style="height:100px;"></div>
					<div id="operation" class="form-group text-center">
						<button id="upBtn" type="button" class="btn btn-danger glyphicon-class">
							上一步
							<span class="glyphicon glyphicon-arrow-left"></span> 
						</button>
						<button id="saveBtn" type="button"  class="btn btn-primary glyphicon-class" style="margin-left: 30px;">
							保　存
							<span class="glyphicon glyphicon-floppy-save"></span> 
						</button>
						<button id="nextBtn" type="button" class="btn btn-warning glyphicon-class" style="margin-left: 30px;">
							下一步
							<span class="glyphicon glyphicon-arrow-right"></span> 
						</button>
					</div>
				</form>
				
			</div>
		</div>
	</section>
	<script type="text/javascript">
		var uploadToken = "${uploadToken}";
		var src = "${param.src}";
		var srcLink = "${param.srcLink}";
		var customerId = "${param.customerId}";
		
		var bankCardImgInitialPreview = "${loan.bankCardImg.fullUrl}";
		var holdBankCardImgInitialPreview = "${loan.holdBankCardImg.fullUrl}";
		
	</script>
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/customer/addOrUpdateLoan.js"></script>
	<!-- /.content -->
</div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <jsp:include page="/WEB-INF/views/common/mainFooter.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/common/controlSidebar.jsp"></jsp:include>
  
  
</div>
<!-- ./wrapper -->
</body>
</html>


