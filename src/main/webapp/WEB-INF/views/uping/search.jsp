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
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">上报客户</li>
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
							<input type="text" class="form-control" id="phone"
								name="phone" placeholder="请输入客户电话">
						</div>
					</div>
					
					<div class="form-group">
						<label for="cardNumber" class="col-sm-1 control-label">身份证号</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="cardNumber"
								name="cardNumber" placeholder="请输入客户身份证号">
						</div>
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
						<label for="status" class="col-sm-1 control-label">状态</label>
						<div class="col-sm-5">
							<select name="status" class="form-control">
								<option value="" selected="selected">请选择</option>
								<option value="0">待上报</option>
								<option value="1">审核中</option>
								<option value="2">审核驳回</option>
								<option value="3">待放款</option>
								<option value="4">回款中</option>
								<option value="5">逾期中</option>
								<option value="6">完结</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10 text-right">
							<button id="searchBth" type="button" class="btn btn-primary glyphicon-class">
								查询
								<span class="glyphicon glyphicon-search"></span> 
							</button>
							
							<a data-pjax href="${contextPath}/customer/addOrUpdateBasic" 
								class="btn btn-info glyphicon-class">
								新增
								<span class="glyphicon glyphicon-plus"></span> 
							</a>
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
			                <th>分期数</th>
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
	
<!-- 	修改客户资料 -->
	<div class="modal fade" id="editCutomerModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">修改客户资料</h4>
	      </div>
	      <div class="modal-body text-center">
	      	<div>
	      		<p id="examineComments" style="font-size: 16px;font-weight: normal;color: red;"></p>
	      	</div>
	        <a  href="${contextPath}/customer/addOrUpdateBasic" type="button" class="btn btn-link">基础信息</a>
	        <a  href="${contextPath}/customer/addOrUpdateLoan" type="button" class="btn btn-link">贷款信息</a>
	        <a  href="${contextPath}/customer/addOrUpdateContract" type="button" class="btn btn-link">合同信息</a>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	
<!-- 	删除客户资料 -->
	<div class="modal fade" id="delCutomerModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">删除客户资料</h4>
	      </div>
	      <div class="modal-body text-center">
	        <p style="font-size: 16px;font-weight: normal;">确定删除该客户信息？</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        
        	<button id="delBtn"  type="button" class="btn btn-primary">确定</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
<!-- 	上报客户资料 -->
	<div class="modal fade" id="upingCutomerModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">上报客户资料</h4>
	      </div>
	      <div class="modal-body text-center">
	        <p style="font-size: 16px;font-weight: normal;">确定上报该客户信息？</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        
        	<button id="upingBtn" type="button" class="btn btn-primary">确定</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/uping/search.js"></script>
</div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <jsp:include page="/WEB-INF/views/common/mainFooter.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/common/controlSidebar.jsp"></jsp:include>
</div>
<!-- ./wrapper -->
</body>
</html>


