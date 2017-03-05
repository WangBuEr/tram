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
			
				<form class="form-horizontal" role="form" id="customerContract">
				
					<div class="row">
						<div class="form-group">
							<input type="hidden" name="id" value="${param.customerId}">
							<label for="contractNumber" class="col-sm-1 control-label">合同号</label>
							<div class="col-sm-11">
								<input value="${customer.contractNumber}" type="text" class="form-control" id="contractNumber"
									name="contractNumber" placeholder="请输入合同号">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="phone" class="col-sm-1 control-label">合同照片</label>
							<div class="col-sm-11" >
								<input id="contractImg" class="file" type="file" multiple name="file">
								<input name="contractImg" type="hidden">
							</div>
						</div>
					</div>
					<div class="row" >
						<div class="form-group">
							<label for="phone" class="col-sm-1 control-label">合同视频</label>
							<div class="col-sm-11 ">
								<input id="contractVideo" class="file" type="file" multiple name="file">
								<input name="contractVideo" type="hidden">
							</div>
						</div>
					</div>
				
					<div id="operation" class="form-group text-center">
						<button id="upBtn" type="button" class="btn btn-danger glyphicon-class">
							上一步
							<span class="glyphicon glyphicon-arrow-left"></span> 
						</button>
						<button id="saveBtn" type="button"  class="btn btn-primary glyphicon-class" style="margin-left: 30px;">
							保　存
							<span class="glyphicon glyphicon-floppy-save"></span> 
						</button>
						<button id="upingBtn" type="button"  class="btn btn-warning glyphicon-class" style="margin-left: 30px;">
							上　报
							<span class="glyphicon glyphicon-upload"></span> 
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- /.content -->
	<script type="text/javascript">
		var uploadToken = "${uploadToken}";
		var src = "${param.src}";
		var srcLink = "${param.srcLink}";
		var customerId = "${param.customerId}";
		var imageArr = new Array();
		<c:forEach var="image" items="${customer.contractImageList}" varStatus="status">
			imageArr.push("${image.url}");
		</c:forEach>
		$("input[name='contractImg']").val(imageArr.join(","));
		
		var imageInitialPreview = [
			<c:forEach var="image" items="${customer.contractImageList}" varStatus="status">
				"${image.fullUrl}"
				<c:if test="${!status.last}">
					,
				</c:if>
			</c:forEach>
		];
		var imageInitialPreviewConfig = [
			<c:forEach var="image" items="${customer.contractImageList}" varStatus="status">
				{
			        filetype:['image'],
			        frameClass: 'file-preview-image',
			        previewAsData:true,
			        key:'${image.url}'
			    }
				<c:if test="${!status.last}">
					,
				</c:if>
			</c:forEach>
		];
		
		var videoList = new Array();
		<c:forEach var="video" items="${customer.contractVideoList}" varStatus="status">
			videoList.push("${video.url}");
		</c:forEach>
		$("input[name='contractVideo']").val(videoList.join(","));
		var videoInitialPreview = [
			<c:forEach var="video" items="${customer.contractVideoList}" varStatus="status">
				'<video class="kv-preview-data" width="213px" height="160px" controls="">'
					+'<source src="${video.fullUrl}" type="video/mp4">'
				+'</video>'
				<c:if test="${!status.last}">
					,
				</c:if>
			</c:forEach>
		];
		var videoInitialPreviewConfig = [
			<c:forEach var="video" items="${customer.contractVideoList}" varStatus="status">
				{
			        filetype:['video'],
			        frameClass: 'kv-preview-data',
			        key:'${video.url}'
			    }
				<c:if test="${!status.last}">
					,
				</c:if>
			</c:forEach>
		];
		
	</script>
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/customer/addOrUpdateContract.js"></script>
</div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <jsp:include page="/WEB-INF/views/common/mainFooter.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/common/controlSidebar.jsp"></jsp:include>
</div>
<!-- ./wrapper -->
</body>
</html>


