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
		<h1>用户管理</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">用户管理</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" role="form" id="searchForm">
					<div class="form-group">
						<label for="loginName" class="col-sm-1 control-label">登录名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="loginName"
								name="loginName" placeholder="请输入客户姓名">
						</div>
						<label for="name" class="col-sm-1 control-label">姓名</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="name"
								name="name" placeholder="请输入客户姓名">
						</div>
						
					</div>
					
					<div class="form-group">
						<label for="phone" class="col-sm-1 control-label">电话</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="phone"
								name="phone" placeholder="请输入客户电话">
						</div>
						<label for="upingTimeStr" class="col-sm-1 control-label">部门</label>
						<div class="col-sm-5">
							 <div class="input-group">
								  <input id="searchOrgName" readonly="readonly" type="text" class="form-control" placeholder="请选择部门" aria-describedby="searchSelectOrgBtn">
								  <input id="searchOrganizationId" name="organizationId" readonly="readonly" type="hidden" class="form-control">
								  <div class="input-group-btn">
								  	<button id="searchCleanOrgBtn" type="button" class="btn btn-default" aria-label="Help">
								  		<span class="glyphicon glyphicon-remove"></span>
								  	</button>
	           						<button id="searchSelectOrgBtn" type="button" class="btn btn-default">选择</button>
								  </div>
							 </div>
							 <div id="searchOrgTree" style="display:none; position: absolute;text-align: left;z-index: 999;"></div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10 text-right">
							<button id="searchBth" type="button" class="btn btn-primary glyphicon-class">
								查询
								<span class="glyphicon glyphicon-search"></span> 
							</button>
							<a data-pjax href="${contextPath}/user/addOrUpdate" 
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
			                <th>登录名</th>
			                <th>姓名</th>
			                <th>所属部门</th>
			                <th>性别</th>
			                <th>年龄</th>
			                <th>电话</th>
			                <th>角色</th>
			                <th>用户类型</th>
			                <th>状态</th>
			                <th>操作</th>
			            </tr>
			        </thead>
			        <tbody>
			        </tbody>
			    </table>
			</div>
		</div>
	</section>
	<!-- 	删除用户 -->
	<div class="modal fade" id="delModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">删除</h4>
	      </div>
	      <div class="modal-body text-center">
	        <p style="font-size: 16px;font-weight: normal;">确定删除该用户？</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        
        	<button id="delBtn"  type="button" class="btn btn-primary">确定</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/user/manager.js"></script>
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


