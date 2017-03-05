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
			<li><a href="javascript:void(0)" onclick="window.history.go(-1);"><i class="glyphicon glyphicon-backward"></i> 返回</a></li>
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
			
				<form class="form-horizontal" role="form" id="customerBasic">
					<fieldset>
						<legend>借贷人信息</legend>
						<div class="row">
							<div class="form-group  col-sm-6">
								<label for="name" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input id="id" name="id" type="hidden" value="${param.customerId}">
									<input type="text" class="form-control" id="name"
										name="name" value="${customer.name}" placeholder="请输入客户姓名">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label for="cardNumber" class="col-sm-2 control-label">身份证</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="cardNumber"
										name="cardNumber" value="${customer.cardNumber}" placeholder="请输入客户身份证号码">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6">
								<label for="phone" class="col-sm-2 control-label">联系电话</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="phone"
										name="phone" value="${customer.phone}" placeholder="请输入客户联系电话">
								</div>
							</div>	
							<div class="form-group col-sm-6">
								<label for="carType" class="col-sm-2 control-label">车型</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="carModels"
										name="carModels" value="${customer.carModels}" placeholder="请输入车型">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group col-sm-6">
								<label for="carType" class="col-sm-2 control-label">车价</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="carPrice"
										name="carPrice" value="${customer.carPrice}" placeholder="请输入车价">
								</div>
							</div>
						</div>
						
						<div class="row"  style="height: 300px;">
							<div class="form-group col-sm-6">
								<label class="col-sm-2 control-label">&nbsp;</label>
								<div class="col-sm-10" >
									<input id="idCardFaceImg" class="file-loading"  type="file" name="file">
									<input for="idCardFaceImg"  class="img" 
										value='${(customer != null && customer.idCardFaceImg != null) ? customer.idCardFaceImg.url : ""}' 
										type="hidden" name="idCardFaceImg">
								</div>
							</div>
							
							<div class="form-group col-sm-6">
								<label class="col-sm-2 control-label">&nbsp;</label>
								<div class="col-sm-10">
									<input id="idCardSideImg" class="file-loading" type="file"  name="file">
									<input for="idCardSideImg" class="img"
										value='${(customer != null && customer.idCardSideImg != null) ? customer.idCardSideImg.url : ""}' 
										type="hidden" name="idCardSideImg">
								</div>
							</div>
						</div>
						
					</fieldset>
				</form>
				
				<form class="form-horizontal" role="form" id="customerShare">
					<fieldset>
						<legend>共偿人信息</legend>
						<div class="row">
							<div class="form-group col-sm-6">
								<label for="name" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input id="id" name="id" type="hidden" value="${customer.share.id}">
									<input type="text" class="form-control" id="name"
										name="name" value="${customer.share.name}" placeholder="请输入客户共偿人姓名">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label for="phone" class="col-sm-2 control-label">联系电话</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="phone"
										name="phone" value="${customer.share.phone}" placeholder="请输入客户共偿人联系电话">
								</div>
							</div>
						</div>
						
						
						<div class="row">
							<div class="form-group col-sm-6">
								<label for="carType" class="col-sm-2 control-label">关系</label>
								<div class="col-sm-10">
									<input type="radio" name="relation" value="0" checked="checked">
	              					<label for="input-3">&nbsp;&nbsp;配偶&nbsp;&nbsp;</label>
									<input type="radio" name="relation" value="1" ${customer.share.relation == 1 ? "checked='checked'":""}>
	              					<label for="input-3">&nbsp;&nbsp;担保人&nbsp;&nbsp;</label>
								</div>
							</div>
						</div>
						<div class="row" style="height: 300px;">
							<div class="form-group col-sm-6">
								<label for="phone" class="col-sm-2 control-label">&nbsp;</label>
								<div class="col-sm-10">
									<input id="shareIdCardFaceImg" class="file" type="file" name="file">
									<input for="shareIdCardFaceImg" class="img"
										value='${(customer != null && customer.share != null && customer.share.idCardFaceImg != null) ? customer.share.idCardFaceImg.url : ""}' 
										type="hidden" name="shareIdCardFaceImg">
								</div>
							</div>
							<div class="form-group col-sm-6">
								<div class="col-sm-2">&nbsp;</div>
								<div class="col-sm-10">
									<input id="shareIdCardSideImg" class="file" type="file" name="file">
									<input for="shareIdCardSideImg" class="img"
										value='${(customer != null && customer.share != null && customer.share.idCardFaceImg != null) ? customer.share.idCardSideImg.url : ""}' 
										type="hidden" name="shareIdCardSideImg">
								</div>
							</div>
						</div>
					</fieldset>
				</form>
				<form class="form-horizontal" role="form" id="customerurgent">	
					<fieldset>
						<legend>紧急联系人信息</legend>
						<div class="row">
							<c:choose>
								<c:when test="${customer != null && not empty customer.emergencyContactList && fn:length(customer.emergencyContactList) > 0}">
									<div class="form-group col-sm-6">
										<label for="nameOne" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="nameOne"
												value="${customer.emergencyContactList[0].name}" name="nameOne" placeholder="请输入紧急联系人姓名">
										</div>
									</div>
									<div class="form-group col-sm-6">
										<label for="phone" class="col-sm-2 control-label">联系电话</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="phoneOne"
												value="${customer.emergencyContactList[0].phone}" name="phoneOne" placeholder="请输入紧急联系人联系电话">
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group col-sm-6">
										<label for="personalName" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="nameOne"
												name="nameOne" placeholder="请输入紧急联系人姓名">
										</div>
									</div>
									<div class="form-group col-sm-6">
										<label for="phone" class="col-sm-2 control-label">联系电话</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="phoneOne"
												name="phoneOne" placeholder="请输入紧急联系人联系电话">
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="row">
							<c:choose>
								<c:when test="${customer != null && not empty customer.emergencyContactList && fn:length(customer.emergencyContactList) > 1}">
									<div class="form-group col-sm-6">
										<label for="nameTwo" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="nameTwo"
												value="${customer.emergencyContactList[1].name}" name="nameTwo" placeholder="请输入紧急联系人姓名">
										</div>
									</div>
									<div class="form-group col-sm-6">
										<label for="phoneTwo" class="col-sm-2 control-label">联系电话</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="phoneTwo"
												value="${customer.emergencyContactList[1].phone}" name="phoneTwo" placeholder="请输入紧急联系人联系电话">
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group col-sm-6">
										<label for="nameTwo" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="nameTwo"
												name="nameTwo" placeholder="请输入紧急联系人姓名">
										</div>
									</div>
									<div class="form-group col-sm-6">
										<label for="phoneTwo" class="col-sm-2 control-label">联系电话</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="phoneTwo"
												name="phoneTwo" placeholder="请输入紧急联系人联系电话">
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
						
						<div id="operation" class="form-group text-center">
							<button id="saveBtn" type="button"  class="btn btn-primary glyphicon-class">
								保　存
								<span class="glyphicon glyphicon-floppy-save"></span> 
							</button>
							<button id="nextBtn" type="button" class="btn btn-danger glyphicon-class" style="margin-left: 30px;">
								下一步
								<span class="glyphicon glyphicon-arrow-right"></span> 
							</button>
						</div>
					</fieldset>
			</div>
		</div>
	</section>
	<!-- /.content -->
	<script type="text/javascript">
		var uploadToken = "${uploadToken}";
		var src = "${param.src}";
		var srcLink = "${param.srcLink}";
		var idCardFaceImgInitialPreview = "${customer.idCardFaceImg.fullUrl}";
		var idCardSideImgInitialPreview = "${customer.idCardSideImg.fullUrl}";
		var shareIdCardFaceImgInitialPreview = "${customer.share.idCardFaceImg.fullUrl}";
		var shareIdCardSideImgInitialPreview = "${customer.share.idCardSideImg.fullUrl}";
	</script>
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/customer/addOrUpdateBasic.js"></script>
	</div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <jsp:include page="/WEB-INF/views/common/mainFooter.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/common/controlSidebar.jsp"></jsp:include>
</div>
<!-- ./wrapper -->
</body>
</html>


