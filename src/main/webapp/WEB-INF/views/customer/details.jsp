<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@include file="/WEB-INF/views/common/variable.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>电车金融</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
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
				<h1>客户详情</h1>
				<ol class="breadcrumb">
					<li><a href="javascript:void(0)" onclick="window.history.go(-1);"><i class="glyphicon glyphicon-backward"></i> 返回</a></li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<c:if test="${!empty failComments}">
					<div class="callout callout-danger">
			          <h4>上次审批意见：${failComments}</h4>
			        </div>
				</c:if>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row" style="padding-bottom: 30px;">
							<div class="step-body" id="step">
								<div class="step-header" style="width:80%">
									<ul>
										<li><p>待上报</p></li>
										<li><p>待核中</p></li>
										<li><p>待放款</p></li>
										<c:choose>
											<c:when test="${customer.status == 5}">
												<li><p>逾期中</p></li>
											</c:when>
											<c:otherwise>
												<li><p>回款中</p></li>
											</c:otherwise>
										</c:choose>
										
										<li><p>完结</p></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="nav-tabs-custom">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#basic" data-toggle="tab">基本信息</a></li>
								<li><a href="#loan" data-toggle="tab">贷款信息</a></li>
								<li><a href="#contract" data-toggle="tab">合同信息</a></li>
								<shiro:hasAnyRoles name="admin,boss">
									<li><a href="#release" data-toggle="tab">放款信息</a></li>
									<li><a href="#receive" data-toggle="tab">回款信息</a></li>
									<li><a href="#overdue" data-toggle="tab">逾期信息</a></li>
								</shiro:hasAnyRoles>
							</ul>
							<div class="tab-content">
								<jsp:include page="./details_basic.jsp"></jsp:include>
								<jsp:include page="./details_loan.jsp"></jsp:include>
								<jsp:include page="./details_contract.jsp"></jsp:include>
								<shiro:hasAnyRoles name="admin,boss">
									<jsp:include page="./details_release.jsp"></jsp:include>
									<jsp:include page="./details_receive.jsp"></jsp:include>
									<jsp:include page="./details_overdue.jsp"></jsp:include>
								</shiro:hasAnyRoles>
							</div>
							<!-- /.tab-content -->
						</div>
						<!-- /.nav-tabs-custom -->

					</div>
				</div>
			</section>
			<shiro:hasAnyRoles name="em">
				<c:if test="${customer.status == 1}">
					<jsp:include page="./details_examine.jsp"></jsp:include>
				</c:if>
			</shiro:hasAnyRoles>
			<!-- /.content -->
			<script type="text/javascript">
				var status = ${customer.status};
				$(function(){
					if(status != 2){
						if(status < 2){
							++status;
						}
						$("#step").step().goStep(status);
					}
					
					
					$("video").each(function(i,v){
						 videojs('video_' + i);
					});
					$(".side ul li").hover(function(){
						$(this).find(".sidebox").stop().animate({"width":"124px"},200).css({"opacity":"1","filter":"Alpha(opacity=100)","background":"#ECF0F5"})	
					},function(){
						$(this).find(".sidebox").stop().animate({"width":"64px"},200).css({"opacity":"0.8","filter":"Alpha(opacity=80)","background":"none"})	
					});
				});
				
			</script>
		</div>
		<!-- /.content-wrapper -->
		
		<!-- Main Footer -->
		<jsp:include page="/WEB-INF/views/common/mainFooter.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/common/controlSidebar.jsp"></jsp:include>
	</div>
	<!-- ./wrapper -->
</body>
</html>


