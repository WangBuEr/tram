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
		<h1>角色管理</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">角色管理</li>
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
				<table id="searchTable" class="table table-striped table-bordered text-center" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>序号</th>
			                <th>名称</th>
			                <th>排序</th>
			                <th>描述</th>
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
	
	<!-- 	角色信息 -->
	<div class="modal fade" id="roleInfoModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 id="roleInfoModalTitle" class="modal-title"></h4>
				</div>
				<div class="modal-body text-center">
					<form class="form-horizontal" role="form" id="roleInfoForm">
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">角色名称</label>
							<div class="col-sm-10">
								<input value="" type="text" class="form-control" id="name"
									name="name" placeholder="请输入角色名称">
									<input value="" type="hidden" class="form-control" id="id"
									name="id">
							</div>
						</div>
						<div class="form-group">
							<label for="seq" class="col-sm-2 control-label">排序</label>
							<div class="col-sm-10">
								<input value="0" type="text" class="form-control" id="name"
									name="seq" placeholder="请输入角色排序">
							</div>
						</div>
						<div class="form-group">
							<label for="status" class="col-sm-2 control-label">状态</label>
							<div class="col-sm-10">
								<select id="status" name="status" class="form-control">
									<option value="0">正常</option>
									<option value="1">禁用</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="parentOrg" class="col-sm-2 control-label">描述</label>
							<div class="col-sm-10">
								<textarea id="description" name="description" rows="3" style="width: 100%;" placeholder="请输入角色描述"></textarea>
							</div>
						</div>
						
						<div class="modal-footer" id="operation">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="button" class="btn btn-primary" id="addOrUpdateBtn">确定</button>
						</div>
					</form>
				</div>
				
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- 	删除角色 -->
	<div class="modal fade" id="delModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">删除</h4>
	      </div>
	      <div class="modal-body text-center">
	        <p style="font-size: 16px;font-weight: normal;">确定删除该角色？</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        
        	<button id="delBtn"  type="button" class="btn btn-primary">确定</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
<!-- 	授权 -->
	<div class="modal fade" id="authorizationModal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title">授权</h4>
	      </div>
	      <div class="modal-body text-center">
	       	<div class="row" style="padding: 0px 30px 15px 0px;text-align: right;">
				<button id="selectAllBtn" type="button" class="btn btn-primary glyphicon-class">
					全选
					<span class="glyphicon glyphicon-ok"></span> 
				</button>
				<button id="reverseSelectionBtn" type="button" class="btn btn-info glyphicon-class">
					反选
					<span class="glyphicon glyphicon-resize-full"></span> 
				</button>
			</div>
			<div class="row" style="height: 300px;overflow: auto;">
				<div id="resourceTree" style="text-align: left;"></div>
			</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        
        	<button id="authorizationBtn"  type="button" class="btn btn-primary">确定</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/role/manager.js"></script>
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


