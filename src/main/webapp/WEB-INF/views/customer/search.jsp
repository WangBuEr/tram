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
		<h1>客户报表</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">客户报表</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" role="form" id="searchForm">
					<div class="form-group">
						<label for="name" class="col-sm-1 control-label">客户姓名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="name"
								name="name" placeholder="请输入客户姓名">
						</div>
						<label for="phone" class="col-sm-1 control-label">客户电话</label>
						<div class="col-sm-5">
							<input type="tel" class="form-control" id="phone"
								name="phone" placeholder="请输入客户电话">
						</div>
					</div>
					
					<div class="form-group">
						<label for="loanAmount" class="col-sm-1 control-label">贷款额</label>
						<div class="col-sm-5">
							<input type="number" class="form-control" id="loanAmount"
								name="loanAmount" placeholder="请输入客户贷款额">
						</div>
						
						<label for="repaymentAmount" class="col-sm-1 control-label">当前还款额</label>
						<div class="col-sm-5">
							<input type="number" class="form-control" id="repaymentAmount"
								name="repaymentAmount" placeholder="请输入客户当前还款额">
						</div>
					</div>
					
					<div class="form-group">
						<label for="stageNumber" class="col-sm-1 control-label">分期数</label>
						<div class="col-sm-5">
							<select class="form-control" name="stageNumber">
								<option value="" selected="selected">请选择</option>
								<option value="3">3期</option>
								<option value="6">6期</option>
								<option value="9">9期</option>
								<option value="12">12期</option>
							</select>
						</div>
						
						<label for="remainingPeriod" class="col-sm-1 control-label">剩余分期数</label>
						<div class="col-sm-5">
							<select class="form-control" name="remainingPeriod">
								<option value="" selected="selected">请选择</option>
								<option value="1">1期</option>
								<option value="2">2期</option>
								<option value="3">3期</option>
								<option value="4">4期</option>
								<option value="5">5期</option>
								<option value="6">6期</option>
								<option value="7">7期</option>
								<option value="8">8期</option>
								<option value="9">9期</option>
								<option value="10">10期</option>
								<option value="11">11期</option>
								<option value="12">12期</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="upingTimeStr" class="col-sm-1 control-label">上报日期</label>
						<div class="col-sm-5">
							 <div id="upingDate" class="input-group date form_date col-md-12" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
			                    <input name="upingTimeStr" class="form-control" size="16" type="text" value="" readonly>
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                </div>
						</div>
					</div>
					<div class="form-group">
						<label for="nickname" class="col-sm-1 control-label">&nbsp;</label>
						<div class="col-sm-5" style="color: red;font-size: 18px;">
							<label id="totalPayment"></label>
						</div>
					
						<div class="col-sm-offset-2 col-sm-4 text-right">
							<button id="searchBth" type="button" class="btn btn-primary glyphicon-class">
								查询
								<span class="glyphicon glyphicon-search"></span> 
							</button>
						</div>
					</div>
				</form>
				
				<table id="searchTable" class="table table-striped table-bordered text-center" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>序号</th>
			                <th>客户姓名</th>
			                <th>身份证号</th>
			                <th>联系电话</th>
			                <th>车型</th>
			                <th>贷款额（元）</th>
			                <th>还款额（元）</th>
			                <th>分期数</th>
			                <th>剩余期数</th>
			                <th>状态</th>
			                <th>上报日期</th>
			                <th>操作</th>
			            </tr>
			        </thead>
			        <tbody>
			        </tbody>
			    </table>
			</div>
		</div>
	</section>
	<!-- /.content -->
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/customer/search.js"></script>
</div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <jsp:include page="/WEB-INF/views/common/mainFooter.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/common/controlSidebar.jsp"></jsp:include>
</div>
<!-- ./wrapper -->
</body>
</html>


