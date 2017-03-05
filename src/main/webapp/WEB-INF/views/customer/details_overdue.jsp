<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="tab-pane" id="overdue">
	<c:forEach var="crp" items="${customer.overdubPaymentList}">
		<div class="row" style="margin-top: 15px;${crp.status == 1 ? 'color:red;':''}">
			<div class="col-md-1">期数：</div>
			<div class="col-md-1">${crp.periods}</div>
			<div class="col-md-1">应回款额：</div>
			<div class="col-md-1">￥${crp.amount}</div>
			<div class="col-md-1">应还日期：</div>
			<div class="col-md-1">
				<fmt:formatDate value="${crp.planPaymentDay}" pattern="yyyy-MM-dd" />
			</div>
			<div class="col-md-1">逾期天数</div>
			<div class="col-md-1">${crp.sumOverdueDay}</div>
			<div class="col-md-1">是否追回</div>
			<div class="col-md-1">${crp.status == 1 ? "否":"是"}</div>
			<div class="col-md-1">追回方式</div>
			<div class="col-md-1">${crp.paymentType == 0 ? "自动":"手动"}</div>
		</div>
	</c:forEach>
	<c:if test="${not empty customer.overdubPaymentList && fn:length(customer.overdubPaymentList) > 0}">
		<div class="row" style="margin-top: 30px;font-size: 18px;color: red;">
			<div class="col-md-12 text-right">
				共逾期${fn:length(customer.overdubPaymentList)}期，
				追回￥${customer.totalRecoveredAmount}，待追回￥${customer.totalToBeRecoveredOverdueAmount}
			</div>
		</div>
	</c:if>
	
</div>