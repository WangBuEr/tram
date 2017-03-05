<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<div class="tab-pane" id="contract">
	<div class="row" style="margin-top: 15px;">
		<div class="col-md-1">合同号：</div>
		<div class="col-md-2">${customer.contractNumber}</div>
	</div>
	<c:if test="${customer.contractImageList != null && !empty customer.contractImageList}">
		<div class="row" style="margin-top: 30px;">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<c:forEach var="image" items="${customer.contractImageList}" varStatus="status">
						<c:choose>
							<c:when test="${status.index == 0}">
								<li data-target="#carousel-example-generic" data-slide-to="${status.index}" class="active"></li>
							</c:when>
							<c:otherwise>
								<li data-target="#carousel-example-generic" data-slide-to="${status.index}"></li>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</ol>
	
				<!-- Wrapper for slides -->
				
				<div class="carousel-inner" role="listbox">
						<c:forEach var="image" items="${customer.contractImageList}" varStatus="status">
							<c:choose>
								<c:when test="${status.index == 0}">
									<div class="item active">
										<img style="width: 100%; height: 842px;" src="${image.fullUrl}">
									</div>
								</c:when>
								<c:otherwise>
									<div class="item">
										<img style="width: 100%; height: 842px;" src="${image.fullUrl}">
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</div>
				
				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
    </c:if>
    
    <c:if test="${customer.contractVideoList != null && !empty customer.contractVideoList}">
    	<c:forEach var="video" items="${customer.contractVideoList}" varStatus="status">
    		<div class="row" style="margin-top: 30px;">
				<video id="video_${status.index}"
					class="video-js vjs-default-skin vjs-big-play-centered vjs-fluid"
					controls preload="none" width="100" height="100"
					poster="http://video-js.zencoder.com/oceans-clip.png" data-setup="{}">
					<!-- 										    <source src="http://视频地址格式1.mp4" type='video/mp4' /> -->
					<!-- 										    <source src="http://视频地址格式2.webm" type='video/webm' /> -->
					<source
						src="${video.fullUrl}"
						type='video/ogg' />
					<track kind="captions" src="demo.captions.vtt" srclang="en"
						label="English"></track>
					<!-- Tracks need an ending tag thanks to IE9 -->
					<track kind="subtitles" src="demo.captions.vtt" srclang="en"
						label="English"></track>
					<!-- Tracks need an ending tag thanks to IE9 -->
				</video>
			</div>
    	</c:forEach>
    	
    </c:if>
	
</div>