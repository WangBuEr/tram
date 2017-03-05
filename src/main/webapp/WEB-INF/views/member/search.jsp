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
		<h1>会员</h1>
		<ol class="breadcrumb">
			<li><a data-pjax href="${contextPath}/index"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">会员</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="nickname" class="col-sm-2 control-label">会员昵称</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="nickname"
								name="nickname" placeholder="请输入会员昵称">
						</div>
						<label for="userName" class="col-sm-2 control-label">会员姓名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="userName"
								name="userName" placeholder="请输入会员姓名">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10 text-right">
							<button id="searchBth" type="button" class="btn btn-primary glyphicon-class">
								查询
								<span class="glyphicon glyphicon-search"></span> 
							</button>
							
							<button id="frozenBtn" type="button" class="btn btn-warning glyphicon-class">
								冻结
								<span class="glyphicon glyphicon-asterisk"></span> 
							</button>
							<button id="fdelrozenBtn" type="button" class="btn btn-danger glyphicon-class">
								删除
								<span class="glyphicon glyphicon-minus"></span> 
							</button>
							<button id="msgBth" type="button" class="btn btn-info glyphicon-class">
								消息
								<span class="glyphicon glyphicon-envelope"></span> 
							</button>
						</div>
					</div>
				</form>
				
				<table id="example" class="table table-striped table-bordered text-center" cellspacing="0" width="100%">
			        <thead>
			            <tr>
			                <th>
			                	<input class="checkAll" type="checkbox">
			                </th>
			                <th>序号</th>
			                <th>用户名</th>
			                <th>昵称</th>
			                <th>姓名</th>
			                <th>约票</th>
			                <th>金币</th>
			                <th>积分</th>
			                <th>对局数</th>
			                <th>胜率</th>
			            </tr>
			        </thead>
			        <tbody>
			        </tbody>
			    </table>
			</div>
		</div>
		<script type="text/javascript">
			$(function() {
			    var searchTable = initMemberList();
			    $("#searchBth").bind("click",function(){
			    	searchTable.ajax.reload();
			    });
			    
			    $(".checkAll").click(function () {
			        var check = $(this).prop("checked");
			        $(".checkchild").prop("checked", check);
			  });
			} );
			function initMemberList(){
				return $('#example').DataTable({
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
	                    infoEmpty: "没有记录"
	                },
	                serverSide:true,
	                ajax: {
	                    url: path +"/member/query",
	                    data: function(data){
	                    	if($("#nickname").val()){
	                    		data.nickname = $("#nickname").val();
	                    	}
	                    	if($("#userName").val()){
	                    		data.userName = $("#userName").val();
	                    	}
	                    }
	                    
	                },
	                columns:[
	                	{
	                		data:"id",
	                		render : function(data, type, row, meta) {  
	                            return "<input type='checkbox'  class='checkchild'  value='" + data + "' />";  
	                        }  
	                	},	
	                	{
	                		data : null,  
	                        bSortable : false,  
	                        targets : 0,  
	                        width:"50px",
	                        render : function(data, type, row, meta) {  
	                            // 显示行号  
	                            var startIndex = meta.settings._iDisplayStart;  
	                            return startIndex + meta.row + 1;  
	                        }  
	                	},
	                	{data:'userName'},
	                	{data:'nickname'},
	                	{data:'personalName'},
	                	{data:'roomTicket'},
	                	{data:'gold'},
	                	{data:'integral'},
	                	{data:'playGame'},
	                	{
	                		data:'winningProbability',
	                		render : function(data, type, row, meta) { 
	                			return data + "%";  
	                		}
                        }
	                ]
			    });
			}
			
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


