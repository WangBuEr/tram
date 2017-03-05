<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/variable.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>lol竞猜</title>
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
		<h1>战队</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">战队</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="chineseName" class="col-sm-2 control-label">中文队名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="chineseName"
								name="chineseName" placeholder="请输入中文队名">
						</div>
						<label for="otherName" class="col-sm-2 control-label">外文队名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="otherName"
								name="otherName" placeholder="请输入外文队名">
						</div>
					</div>
					<div class="form-group">
						<label for="coach" class="col-sm-2 control-label">战队教练</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="coach" name="coach"
								placeholder="请输入战队教练">
						</div>
						<label for="website" class="col-sm-2 control-label">战队网站</label>
						<div class="col-sm-4">
							<input type="url" class="form-control" id="website"
								name="website" placeholder="请输入战队网站">
						</div>
					</div>
					<div class="form-group">
						<label for="createTime" class="col-sm-2 control-label">建队时间</label>
						<div class="col-sm-4">
							<input type="date" class="form-control" id="createTime"
								name="createTime" placeholder="请输入建队时间">
						</div>
					</div>
					<div class="form-group">
						<label for="describe" class="col-sm-2 control-label">战队描述</label>
						<div class="col-sm-10">
							<textarea class="form-control" id="describe" name="describe"
								rows="5"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="" class="col-sm-2 control-label">战队logo</label>
						<div class="col-sm-10">
							<div class="col-xs-6 col-md-3">
								<a href="javascript:void(0)" class="thumbnail"
									style="min-width: 100px; min-height: 100px;"> <img
									id="logoImg" alt="">
								</a>
							</div>
							<div class="col-xs-6 col-md-7">
								<div id="filePicker">选择图片</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10 text-right">
							<a data-pjax href="${contextPath}/tream/list" class="btn btn-info">
								返回&nbsp;
								<span class="glyphicon glyphicon-arrow-left"></span>
							</a>
							<a data-pjax href="${contextPath}/tream/list" class="btn btn-info">
								保存&nbsp;
								<span class="glyphicon glyphicon-floppy-save"></span>
							</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript">
			var uploader = WebUploader.create({
				auto : true,
				// 文件接收服务端。
				server : 'http://upload.qiniu.com/',
				// 选择文件的按钮。可选。
				// 内部根据当前运行是创建，可能是input元素，也可能是flash.
				pick : '#filePicker',
				// 只允许选择图片文件。
				accept : {
					title : 'Images',
					extensions : 'gif,jpg,jpeg,bmp,png',
					mimeTypes : 'image/*'
				}
			});
			uploader.on("uploadBeforeSend", function(object, data, headers) {
				jsonAjax(appPath + "/upload/getUploadToken/", null, false,
						function(rsp) {
							data.token = rsp;
						});
			});
			// 文件上传成功，给item添加成功class, 用样式标记上传成功。
			uploader.on('uploadSuccess', function(file, response) {
				$("#logoImg")
						.attr(
								"src",
								"http://7xt80k.com1.z0.glb.clouddn.com/"
										+ response.key);
			});

			// 文件上传失败，显示上传出错。
			uploader.on('uploadError', function(file) {
			});
		</script>
	</section>
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


