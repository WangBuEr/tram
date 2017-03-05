<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@include file="./variable.jsp" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">

		<!-- Sidebar user panel (optional) -->
		<div class="user-panel">
			<div class="pull-left image">
				<c:choose>
					<c:when test="${! empty user.headImage}">
						<img style="height: 45px;width: 45px;" src="${user.fullUrlHeadImage}?imageView2/0/w/45/h/45" class="img-circle" alt="User Image">
					</c:when>
					<c:otherwise>
						<img src="${contextPath}/resources/img/user2-160x160.jpg" class="img-circle" alt="User Image">
					</c:otherwise>
				</c:choose>
			</div>
			<div class="pull-left info">
				<p>${user.name}</p>
				<a href="javascript:void(0)">${user.organization.name}</a>
			</div>
		</div>

		<!-- search form (Optional) -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input disabled="disabled" type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="button" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->

		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<shiro:hasAnyRoles name="admin,sc">
				<li>
					<a data-pjax href="${contextPath}/uping/search">
						<i class="fa fa-user-plus"></i>
						<span>上报客户</span>
					</a>
				</li>
			</shiro:hasAnyRoles>
			<shiro:hasAnyRoles name="admin,em">
				<li>
					<a data-pjax href="${contextPath}/examine/search">
						<i class="fa fa-exchange"></i>
						<span>业务审批</span>
					</a>
				</li>
			</shiro:hasAnyRoles>
			<shiro:hasAnyRoles name="admin,loan">
				<li>
					<a data-pjax href="${contextPath}/release/search">
						<i class="fa fa-cny"></i>
						<span>放款管理</span>
					</a>
				</li>
			</shiro:hasAnyRoles>
			<shiro:hasAnyRoles name="admin,rp">
				<li class="treeview">
		          <a href="#">
		            <i class="fa fa-dollar"></i> <span>回款管理</span>
		            <span class="pull-right-container">
		              <i class="fa fa-angle-left pull-right"></i>
		            </span>
		          </a>
		          <ul class="treeview-menu">
		            <li><a data-pjax href="${contextPath}/receive/search/0"><i class="fa fa-bell"></i>预警回款</a></li>
		            <li><a data-pjax href="${contextPath}/receive/search/1"><i class="fa fa-calendar-check-o"></i>当前回款</a></li>
		            <li><a data-pjax href="${contextPath}/receive/search/2"><i class="fa fa-bullhorn"></i>逾期回款</a></li>
		            <li><a data-pjax href="${contextPath}/receive/search/3"><i class="fa fa-hand-paper-o"></i>手动回款</a></li>
		          </ul>
		        </li>
		    </shiro:hasAnyRoles>
	        <shiro:hasAnyRoles name="admin,boss">
		        <li>
					<a data-pjax href="${contextPath}/customer/search">
						<i class="fa fa-medkit"></i>
						<span>客户报表</span>
					</a>
				</li>
		        <li>
					<a data-pjax href="${contextPath}/report/index">
						<i class="fa fa-pie-chart"></i>
						<span>统计报表</span>
					</a>
				</li>
			</shiro:hasAnyRoles>
			<shiro:hasAnyRoles name="admin">
				<li class="treeview">
		          <a href="#">
		            <i class="fa fa-cog"></i> <span>系统管理</span>
		            <span class="pull-right-container">
		              <i class="fa fa-angle-left pull-right"></i>
		            </span>
		          </a>
		          <ul class="treeview-menu">
		            <li><a data-pjax href="${contextPath}/organization/manager"><i class="fa  fa-users"></i>组织管理</a></li>
		            <li><a data-pjax href="${contextPath}/user/manager"><i class="fa  fa-user"></i>用户管理</a></li>
		            <li><a data-pjax href="${contextPath}/role/manager"><i class="fa  fa-street-view"></i>角色管理</a></li>
		            <li><a data-pjax href="${contextPath}/resource/manager"><i class="fa fa-map"></i>资源管理</a></li>
		          </ul>
		        </li>
		     </shiro:hasAnyRoles>
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>

<script type="text/javascript">
	$(function(){
		$(".sidebar-menu > li").bind("click",function(){
			if(!$(this).hasClass("treeview")){
				$(this).addClass("active").siblings().removeClass("active");
			}
		});
		$(".treeview-menu> li").bind("click",function(){
			if(!$(this).hasClass("treeview")){
				$(this).addClass("active").siblings().removeClass("active");
			}
		});
	});
</script>