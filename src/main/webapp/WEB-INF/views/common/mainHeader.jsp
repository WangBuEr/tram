<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@include file="./variable.jsp" %>
<!-- Main Header -->
<header class="main-header">
	<!-- Logo -->
	<a href="javascript:void(0);" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>电</b>车</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>电车金融</span>
	</a>

	<!-- Header Navbar -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a>
		<!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				
				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> 
					<c:choose>
						<c:when test="${! empty user.headImage}">
							<img src="${user.fullUrlHeadImage}?imageView2/0/w/45/h/45" class="user-image" alt="User Image">
						</c:when>
						<c:otherwise>
							<img src="${contextPath}/resources/img/user2-160x160.jpg" class="user-image" alt="User Image">
						</c:otherwise>
					</c:choose>
					<span class="hidden-xs">${user.name}</span>
				</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header">
							<c:choose>
								<c:when test="${! empty user.headImage}">
									<img src="${user.fullUrlHeadImage}?imageView2/0/w/45/h/45" class="img-circle" alt="User Image">
								</c:when>
								<c:otherwise>
									<img src="${contextPath}/resources/img/user2-160x160.jpg" class="img-circle" alt="User Image">
								</c:otherwise>
							</c:choose>
							<p>
								<fmt:formatDate value="<%=new Date() %>" pattern="yyyy年MM月dd日" /> 
							</p>
						</li>
						
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a data-pjax href="${contextPath}/user/info/${user.id}" class="btn btn-default btn-flat">个人信息</a>
							</div>
							<div class="pull-right">
								<a href="${contextPath}/logout" class="btn btn-default btn-flat">退　　出</a>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</header>