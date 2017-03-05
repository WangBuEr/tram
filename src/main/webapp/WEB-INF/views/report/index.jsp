<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
		
		<h1>
			统计
		</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">统计</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" role="form" id="searchForm">
					<div class="form-group">
						<label for="beginReleasePaymentsDate" class="col-sm-1 control-label">开始日期</label>
						<div class="col-sm-5">
							<div id="beginReleasePaymentsDate" class="input-group date form_date col-md-12">
			                    <input name="beginReleasePaymentsDate" class="form-control" size="16" type="text" value="${beginReleasePaymentsDate}" readonly>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
						</div>
						<label for="endReleasePaymentsDate" class="col-sm-1 control-label">结束日期</label>
						<div class="col-sm-5">
							<div id="endReleasePaymentsDate" class="input-group date form_date col-md-12">
			                    <input name="endReleasePaymentsDate" class="form-control" size="16" type="text" value="${endReleasePaymentsDate}" readonly>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10 text-right">
							<button id="searchBth" type="button" class="btn btn-primary glyphicon-class">
								查询
								<span class="glyphicon glyphicon-search"></span> 
							</button>
						</div>
					</div>
					
					<fieldset>
						<legend>放款统计</legend>
						<div class="row">
							<div class="col-md-1"><h4>放款客户数</h4></div>
							<div class="col-md-3"><h4><span id="releaseCustomerSum"></span>个</h4></div>
							<div class="col-md-1"><h4>放款金额</h4></div>
							<div class="col-md-3"><h4><span id="totalLoan"></span>元</h4></div>
						</div>
					</fieldset>
					
					<fieldset style="margin-top: 30px;">
						<legend>回款统计</legend>
						<div class="row">
							<div class="col-md-1"><h4>当收金额</h4></div>
							<div class="col-md-3"><h4><span id="totalPlanReceivedAmount"></span>元</h4></div>
							<div class="col-md-1"><h4>待收金额</h4></div>
							<div class="col-md-3"><h4><span id="totalToBeOverdueAmount"></span>元</h4></div>
							<div class="col-md-1"><h4>回款金额</h4></div>
							<div class="col-md-3"><h4><span id="totalReceivedAmount"></span>元</h4></div>
						</div>
						<div class="row">
							<div class="col-md-1"><h4>逾期金额</h4></div>
							<div class="col-md-3"><h4><span id="totalOverdueAmount"></span>元</h4></div>
						</div>
					</fieldset>
					
					<fieldset style="margin-top: 30px;">
						<legend>完结统计</legend>
						<div class="row">
							<div class="col-md-1"><h4>完结金额</h4></div>
							<div class="col-md-3"><h4><span id="endTotalLoan"></span>元</h4></div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/report/index.js"></script>
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


