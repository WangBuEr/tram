<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
			<li><a href="javascript:void(0)" onclick="window.history.go(-1);"><i class="glyphicon glyphicon-backward"></i> 返回</a></li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" role="form" id="userInfoForm">
					<div class="row">
						<div class="form-group  col-sm-6">
							<label for="loginName" class="col-sm-2 control-label">登录名</label>
							<div class="col-sm-10">
								<input value="${user.loginName}" type="text" class="form-control" id="loginName"
									name="loginName" placeholder="请输入登录名">
									<input value="${user.id}" type="hidden" class="form-control" id="id"
									name="id">
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label for="name" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-10">
								<input style="display: none;">
								<input autocomplete="off" value="${user.name}" type="text" class="form-control" id="name"
									name="name" placeholder="请输入用户姓名">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group  col-sm-6">
							<label for="password" class="col-sm-2 control-label">密码</label>
							<div class="col-sm-10">
								<input style="display: none;">
								<input autocomplete="off" value="" type="password" class="form-control" id="password"
									name="password" placeholder="密码不修改请留空">
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label for="sex" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<select id="sex" name="sex" class="form-control">
									<option value="1">男</option>
									<option value="0" ${user.sex == 0 ? "selected='selected'" : ""}>女</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group  col-sm-6">
							<label for="age" class="col-sm-2 control-label">年龄</label>
							<div class="col-sm-10">
								<input value="${user.age}" type="text" class="form-control" id="age"
									name="age" placeholder="请输入用户年龄">
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label for="phone" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input value="${user.phone}" type="text" class="form-control" id="phone"
									name="phone" placeholder="请输入用户电话">
							</div>
						</div>
					</div>
					<shiro:hasAnyRoles name="admin">
						<div class="row">
							<div class="form-group  col-sm-6">
								<label for="userType" class="col-sm-2 control-label">用户类型</label>
								<div class="col-sm-10">
									<select id="userType" name="userType" class="form-control">
										<option value="1">用户</option>
										<option value="0" ${user.userType == 0 ? "selected='selected'" : ""}>管理员</option>
									</select>
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label for="status" class="col-sm-2 control-label">用户状态</label>
								<div class="col-sm-10">
									<select id="status" name="status" class="form-control">
										<option value="0">正常</option>
										<option value="1" ${user.status == 1 ? "selected='selected'" : ""}>禁用</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group  col-sm-6">
								<label for="userInfoOrgName" class="col-sm-2 control-label">部门</label>
								<div class="col-sm-10">
									 <div class="input-group">
										  <input value="${user.organization.name}" id="userInfoOrgName" readonly="readonly" type="text" class="form-control" placeholder="请选择部门" aria-describedby="searchSelectOrgBtn">
										  <input value="${user.organizationId}" id="organizationId" name="organizationId" readonly="readonly" type="hidden" class="form-control">
										  <div class="input-group-btn">
										  	<button id="userInfoCleanOrgBtn" type="button" class="btn btn-default" aria-label="Help">
										  		<span class="glyphicon glyphicon-remove"></span>
										  	</button>
			           						<button id="userInfoSelectOrgBtn" type="button" class="btn btn-default">选择</button>
										  </div>
									 </div>
									 <div id="userInfoOrgTree" style="display:none; position: absolute;text-align: left;z-index: 999;"></div>
								</div>
							</div>
							<div class="form-group col-sm-6">
								<label for="status" class="col-sm-2 control-label">用户角色</label>
								<div class="col-sm-10">
									<select id="roleList" name="roleList" class="form-control" multiple="multiple" ></select>
								</div>
							</div>
						</div>
					</shiro:hasAnyRoles>
					<div class="row">
						<div class="form-group  col-sm-6">
							<label for="userType" class="col-sm-2 control-label">头像</label>
							<div class="col-sm-10">
								<input id="headImage" type="file" name="file"  data-min-file-count="1">
								<input value="${user.headImage}" type="hidden" name="headImage">
							</div>
						</div>
					</div>
					<div id="operation" class="form-group text-center">
						<a href="javascript:void(0)" onclick="window.history.go(-1);" class="btn btn-danger glyphicon-class">
							取消
							<span class="glyphicon glyphicon-arrow-left"></span> 
						</a>
						<button id="saveBtn" type="button"  class="btn btn-primary glyphicon-class" style="margin-left: 30px;">
							保　存
							<span class="glyphicon glyphicon-floppy-save"></span> 
						</button>
					</div>
				</form>
			</div>
		</div>
	</section>
	<!-- /.content -->
	<script type="text/javascript">
		var uploadToken = "${uploadToken}";
		var userRoleList = ${userRoleList};
		var headImage = "${user.fullUrlHeadImage}";
	</script>
	<script type="text/javascript" src="${contextPath}/resources/scripts/app/user/addOrUpdate.js"></script>
</div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <jsp:include page="/WEB-INF/views/common/mainFooter.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/common/controlSidebar.jsp"></jsp:include>
</div>
<!-- ./wrapper -->
</body>
</html>


