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
			组织管理
		</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">组织管理</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row" style="padding: 15px 30px;text-align: right;">
					<button id="addBtn" type="button" class="btn btn-primary glyphicon-class">
						新增
						<span class="glyphicon glyphicon-plus"></span> 
					</button>
				</div>
				<table id="orgListTreeTable" class="table tree-2 table-bordered table-striped table-condensed" style="text-align: center;">
					<tbody></tbody>
				</table>
			</div>
		</div>
	</section>
	<!-- /.content -->
	<!-- 	部门信息 -->
	<div class="modal fade" id="orgInfoModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 id="orgInfoModalTitle" class="modal-title"></h4>
				</div>
				<div id="examineModalBody"  class="modal-body text-center">
					<form class="form-horizontal" role="form" id="orgInfoForm">
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">部门名称</label>
							<div class="col-sm-10">
								<input value="" type="text" class="form-control" id="name"
									name="name" placeholder="请输入部门名称">
									<input value="" type="hidden" class="form-control" id="id"
									name="id">
							</div>
						</div>
						<div class="form-group">
							<label for="seq" class="col-sm-2 control-label">排序</label>
							<div class="col-sm-10">
								<input value="0" type="text" class="form-control" id="name"
									name="seq" placeholder="请输入部门排序">
							</div>
						</div>
						<div class="form-group">
							<label for="parentOrg" class="col-sm-2 control-label">上级部门</label>
							<div class="col-sm-10">
								<div class="input-group">
								  <input id="parentOrgName" readonly="readonly" type="text" class="form-control" placeholder="请选择上级部门" aria-describedby="selectOrgBtn">
								  <input id="pid" name="pid" readonly="readonly" type="hidden" class="form-control">
								  <div class="input-group-btn">
								  	<button id="cleanOrgBtn" type="button" class="btn btn-default" aria-label="Help">
								  		<span class="glyphicon glyphicon-remove"></span>
								  	</button>
            						<button id="selectOrgBtn" type="button" class="btn btn-default">选择</button>
								  </div>
								</div>
								<div id="orgTree" style="display:none; position: absolute;text-align: left;"></div>
							</div>
						</div>
						<div class="modal-footer" id="operation">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary" id="addOrUpdateOrgBtn">确定</button>
						</div>
					</form>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- 	删除部门 -->
	<div class="modal fade" id="delModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">删除</h4>
	      </div>
	      <div class="modal-body text-center">
	        <p style="font-size: 16px;font-weight: normal;">确定删除该部门？</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        
        	<button id="delBtn"  type="button" class="btn btn-primary">确定</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/organization/manager.js"></script>
</div>
  <!-- /.content-wrapper -->
	
  <!-- Main Footer -->
  <jsp:include page="/WEB-INF/views/common/mainFooter.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/common/controlSidebar.jsp"></jsp:include>
</div>
<!-- ./wrapper -->
</body>
</html>


