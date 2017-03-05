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
						<div class="col-sm-offset-2 col-sm-10 text-right">
							<button type="button" class="btn btn-info glyphicon-class">
								查询&nbsp;&nbsp;
								<span class="glyphicon glyphicon-search"></span> 
							</button>
							
							<a data-pjax href="${contextPath}/tream/publish" class="btn btn-info glyphicon-class">
								创建&nbsp;&nbsp;
								<span class="glyphicon glyphicon-plus"></span> 
							</a>
						</div>
					</div>
				</form>
				
				<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>中文队名</th>
			                <th>外文队名</th>
			                <th>战队教练</th>
			                <th>创建时间</th>
			                <th>战队网址</th>
			                <th>操作</th>
			            </tr>
			        </thead>
			        <tbody>
			            <tr>
			                <td>RNG</td>
			                <td>RoyalNeverGiveUp</td>
			                <td></td>
			                <td>2015-04-19</td>
			                <td></td>
			                <td>
			                	<a data-pjax href="${contextPath}/tream/publish">编辑</a>
			                	<a href="javascript:void(0)">停用</a>
			                </td>
			            </tr>
			            <tr>
			                <td>RNG</td>
			                <td>RoyalNeverGiveUp</td>
			                <td></td>
			                <td>2015-04-19</td>
			                <td></td>
			                <td>
			                	<a href="javascript:void(0)">启用</a>
			                </td>
			            </tr>
			        </tbody>
			    </table>
			</div>
		</div>
		<script type="text/javascript">
			$(function() {
			    var a = $('#example').DataTable({
			    	paging:   true,
			        ordering: false,
			        info:     true,
			        searching:false,
			        bLengthChange:false,
	                language: {
	                	paginate: {//分页的样式内容。
	                        previous: "上一页",
	                        next: "下一页",
	                        first: "第一页",
	                        last: "最后"
	                    },
	                    zeroRecords: "对不起，查询不到任何相关数据",
	                    info: "总共_PAGES_页，显示第_PAGE_页",
	                    infoEmpty: "No records available"
	                }
			    });
			    console.info(a);
			} );
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


