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
		<h1>业务审批</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">业务审批</li>
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
							<input type="text" class="form-control" id="nickname"
								name="name" placeholder="请输入客户姓名">
						</div>
						<label for="phone" class="col-sm-1 control-label">身份证号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="nickname"
								name="phone" placeholder="请输入客户身份证号">
						</div>
					</div>
					
					<div class="form-group">
						<label for="loanAmount" class="col-sm-1 control-label">贷款金额</label>
						<div class="col-sm-5">
							<input  type="number" class="form-control" id="loanAmount"
								name="loanAmount" placeholder="请输入客户贷款金额">
						</div>
						
						<label for="stageNumber" class="col-sm-1 control-label">分期数</label>
						<div class="col-sm-5">
							<select name="stageNumber" class="form-control">
								<option value="" selected="selected">请选择</option>
								<option value="3">3</option>
								<option value="6">6</option>
								<option value="9">9</option>
								<option value="12">12</option>
							</select>
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
				</form>
				
				<table id="searchTable" class="table table-striped table-bordered text-center" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>序号</th>
			                <th>客户姓名</th>
			                <th>身份证号</th>
			                <th>贷款额(元)</th>
			                <th>分期数</th>
			                <th>审核人</th>
			                <th>审核时间</th>
			                <th>操作</th>
			            </tr>
			        </thead>
			        <tbody>
			        </tbody>
			    </table>
			</div>
		</div>
	</section>
	
	<!-- 	审批意见 -->
	<div class="modal fade" id="loanModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">放款</h4>
				</div>
				<div class="modal-body">
					<div>
						<input id="releasePaymentsNumber" type="text" class="form-control" placeholder="请输入银行流水号">
					</div>
					
					<div style="height: 300px;margin-top: 15px;">
						<input id="bankWaterImg" type="file" name="file"  data-min-file-count="1">
						<input type="hidden" name="bankWaterImg">
					</div>
				</div>
				<div class="modal-footer" style="margin-top: 70px;" id="loanOperation">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" id="loanBtn" class="btn btn-primary" data-dismiss="modal">放款</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<script type="text/javascript">
		var uploadToken = "${uploadToken}";
	</script>
    <script type="text/javascript" src="${contextPath}/resources/scripts/app/release/search.js"></script>
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


