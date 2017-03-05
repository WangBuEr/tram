<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="tab-pane" id="receive">
	<c:forEach var="crp" items="${customer.receivePaymentList}">
		<div class="row" style="margin-top: 15px;">
			<div class="col-md-1">期数：</div>
			<div class="col-md-1">${crp.periods}</div>
			<div class="col-md-1">回款金额：</div>
			<div class="col-md-1">￥${crp.amount}</div>
			<div class="col-md-1">回款方式：</div>
			<div class="col-md-1">${crp.paymentType == 0 ? "自动":"手动"}</div>
			<div class="col-md-1">回款时间：</div>
			<div class="col-md-2">
				<fmt:formatDate value="${crp.actualPaymentDay}" pattern="yyyy-MM-dd" />
			</div>
			<c:if test="${crp.paymentType == 1}">
				<div class="col-md-1">手动回款人：</div>
				<div class="col-md-1">${crp.manualUser.name}</div>
			</c:if>
		</div>
	</c:forEach>
	
	<c:if test="${not empty customer.receivePaymentList && fn:length(customer.receivePaymentList) > 0}">
		<div class="row" style="margin-top: 30px;font-size: 18px;color: red;">
			<div class="col-md-12 text-right">
				已还${fn:length(customer.receivePaymentList)}期，剩余${customer.remainingPeriod}期，
				共回款￥${customer.totalRepaymentAmount}，待回款￥${customer.totalSurplusPaymentAmount}
			</div>
		</div>
	</c:if>
	
	
	
</div>