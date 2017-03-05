<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="tab-pane" id="loan">
	<div class="row" style="margin-top: 15px;">
		<div class="col-md-1">签约流水号：</div>
		<div class="col-md-2">${customer.loan.serialNumber}</div>
		<div class="col-md-1">贷款金额：</div>
		<div class="col-md-2">
			<c:if test="${customer.loan.amount != null}">
				<i>￥</i>${customer.loan.amount}
			</c:if>
		</div>
		<div class="col-md-1">分期数：</div>
		<div class="col-md-2">${customer.loan.stageNumber}</div>
		<div class="col-md-1">开户行：</div>
		<div class="col-md-2">
			<c:choose>
				<c:when test="${customer.loan.bankAccount == 1}">
					工商银行
				</c:when>
				<c:when test="${customer.loan.bankAccount == 2}">
					建设银行
				</c:when>
				<c:when test="${customer.loan.bankAccount == 3}">
					中国银行
				</c:when>
				<c:when test="${customer.loan.bankAccount == 4}">
					农业银行
				</c:when>
				<c:when test="${customer.loan.bankAccount == 5}">
					邮政储蓄
				</c:when>
				<c:otherwise>&nbsp;</c:otherwise>
			</c:choose>
		</div>
	</div>

	<div class="row" style="margin-top: 30px;">
		<div class="col-md-1">开户行支行：</div>
		<div class="col-md-2">${customer.loan.bankBranch}</div>
		<div class="col-md-1">银行卡号：</div>
		<div class="col-md-2">${customer.loan.bankCardNumber}</div>
	</div>

	<div class="row" style="margin-top: 30px;">
		<div class="col-md-6">
			<div class="thumbnail">
				<c:choose>
					<c:when test="${customer.loan.bankCardImg == null}">
						<img style="height: 300px;" src="">
					</c:when>
					<c:otherwise>
						<img style="height: 300px;" src="${customer.loan.bankCardImg.fullUrl}">
					</c:otherwise>
				</c:choose>
				<div class="caption text-center">
					<h3>银行卡照片</h3>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="thumbnail">
				<c:choose>
					<c:when test="${customer.loan.holdBankCardImg == null}">
						<img style="height: 300px;" src="">
					</c:when>
					<c:otherwise>
						<img style="height: 300px;" src="${customer.loan.holdBankCardImg.fullUrl}">
					</c:otherwise>
				</c:choose>
				<div class="caption text-center">
					<h3>手持银行卡照片</h3>
				</div>
			</div>
		</div>
	</div>
</div>