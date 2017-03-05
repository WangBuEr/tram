<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<div class="tab-pane" id="release">
	<div class="row" style="margin-top: 15px;">
		<div class="col-md-1">银行流水号：</div>
		<div class="col-md-2">${customer.releasePaymentsNumber}</div>
		<div class="col-md-1">放款人：</div>
		<div class="col-md-2">${customer.releasePaymentsUser.name}</div>
		<div class="col-md-1">放款时间：</div>
		<div class="col-md-2">
			<fmt:formatDate value="${customer.releasePaymentsTime}" pattern="yyyy-MM-dd HH:mm:ss" />
		</div>
	</div>

	<div class="row" style="margin-top: 30px;">
		<div class="col-md-12">
			<div class="thumbnail">
				<img style="height: 300px;"
					src="${customer.releasePaymentsImg.fullUrl}"
					alt="放款银行流水照片">
				<div class="caption text-center">
					<h3>放款银行流水照片</h3>
				</div>
			</div>
		</div>
	</div>

	
</div>