<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<div class="active tab-pane" id="basic">
	<fieldset>
		<legend>借贷人信息</legend>
		<div class="row">
			<div class="col-md-1">姓名：</div>
			<div class="col-md-2">${customer.name}</div>
			<div class="col-md-1">联系电话：</div>
			<div class="col-md-2">${customer.phone}</div>
			<div class="col-md-1">车型：</div>
			<div class="col-md-2">${customer.carModels}</div>
			<div class="col-md-1">车价：</div>
			<div class="col-md-2">￥${customer.carPrice}</div>
		</div>
		<div class="row" style="margin-top: 30px;">
			<div class="col-md-1">上报人：</div>
			<div class="col-md-2">${customer.upingUser.name}</div>
			<div class="col-md-1">上报日期：</div>
			<c:choose>
				<c:when test="${customer.upingTime == null}">
					<div class="col-md-2">待上报</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-2">
						<fmt:formatDate value="${customer.upingTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					</div>
				</c:otherwise>
			</c:choose>
			
			<div class="col-md-1">审批人：</div>
			<div class="col-md-2">${customer.examineUser.name}</div>
			<div class="col-md-1">审批日期：</div>
			<c:choose>
				<c:when test="${customer.upingTime == null}">
					<div class="col-md-2">&nbsp;</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-2">
						<fmt:formatDate value="${customer.examineTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row" style="margin-top: 30px;">
			<div class="col-md-6">
				<div class="thumbnail">
					<c:choose>
						<c:when test="${customer.idCardFaceImg == null}">
							<img style="height: 300px;" src="">
						</c:when>
						<c:otherwise>
							<img style="height: 300px;" src="${customer.idCardFaceImg.fullUrl}">
						</c:otherwise>
					</c:choose>
					<div class="caption text-center">
						<h3>正面照片</h3>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="thumbnail">
					<c:choose>
						<c:when test="${customer.idCardSideImg == null}">
							<img style="height: 300px;" src="">
						</c:when>
						<c:otherwise>
							<img style="height: 300px;" src="${customer.idCardSideImg.fullUrl}">
						</c:otherwise>
					</c:choose>
					<div class="caption text-center">
						<h3>反面照片</h3>
					</div>
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>共偿人信息</legend>
		<div class="row">
			<div class="col-md-1">姓名：</div>
			<div class="col-md-2">${customer.share.name}</div>
			<div class="col-md-1">联系电话：</div>
			<div class="col-md-2">${customer.share.phone}</div>
			<div class="col-md-1">关系：</div>
			<div class="col-md-2">
				<c:choose>
					<c:when test="${customer.share.relation == 0}">
						夫妻
					</c:when>
					<c:otherwise>
						担保人
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div class="row" style="margin-top: 30px;">
			<div class="col-md-6">
				<div class="thumbnail">
					<c:choose>
						<c:when test="${customer.share.idCardFaceImg == null}">
							<img style="height: 300px;" src="">
						</c:when>
						<c:otherwise>
							<img style="height: 300px;" src="${customer.share.idCardFaceImg.fullUrl}">
						</c:otherwise>
					</c:choose>
					<div class="caption text-center">
						<h3>正面照片</h3>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="thumbnail">
					<c:choose>
						<c:when test="${customer.share.idCardSideImg == null}">
							<img style="height: 300px;" src="">
						</c:when>
						<c:otherwise>
							<img style="height: 300px;" src="${customer.share.idCardSideImg.fullUrl}">
						</c:otherwise>
					</c:choose>
					<div class="caption text-center">
						<h3>反面照片</h3>
					</div>
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset>
		<legend>紧急联系人信息</legend>
		<div class="row">
			<c:forEach var="emergencyContact" items="${customer.emergencyContactList}">
				<div class="col-md-1">姓名：</div>
				<div class="col-md-2">${emergencyContact.name}</div>
				<div class="col-md-1">联系电话：</div>
				<div class="col-md-2">${emergencyContact.phone}</div>
			</c:forEach>
		</div>
	</fieldset>
</div>