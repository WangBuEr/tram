<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./variable.jsp" %>
<!-- jQuery 2.2.3 -->
<script src="${contextPath}/resources/scripts/lib/jquery-2.2.3.min.js"></script>

<!-- 文件上传 -->
<script src="${contextPath}/resources/scripts/lib/fileinput/js/plugins/canvas-to-blob.min.js"></script>
<script src="${contextPath}/resources/scripts/lib/fileinput/js/plugins/sortable.min.js"></script>
<script src="${contextPath}/resources/scripts/lib/fileinput/js/plugins/purify.min.js"></script>
<script src="${contextPath}/resources/scripts/lib/fileinput/js/fileinput.min.js"></script>


<!-- Bootstrap 3.3.6 -->
<script src="${contextPath}/resources/scripts/lib/bootstrap.min.js"></script>

<!-- 文件上传 -->
<script src="${contextPath}/resources/scripts/lib/fileinput/themes/fa/theme.js"></script>
<script src="${contextPath}/resources/scripts/lib/fileinput/js/locales/zh.js"></script>

<script src="${contextPath}/resources/scripts/lib/icheck/icheck.min.js"></script>
<!-- AdminLTE App -->
<script src="${contextPath }/resources/scripts/lib/adminLTE/app.js"></script>

<script src="${contextPath}/resources/scripts/lib/jquery.pjax.js"></script>
<script src="${contextPath}/resources/scripts/lib/nprogress.js"></script>


<!-- datatables -->
<script src="${contextPath}/resources/scripts/lib/datatables/jquery.dataTables.min.js"></script>
<script src="${contextPath}/resources/scripts/lib/datatables/dataTables.bootstrap.min.js"></script>
<!-- 日历控件 -->
<script src="${contextPath}/resources/scripts/lib/datetimepicker/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script src="${contextPath}/resources/scripts/lib/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- 视频控件 -->
<script src="${contextPath}/resources/scripts/lib/videojs/js/video.min.js"></script>
<!-- 步骤控件 -->
<script src="${contextPath}/resources/scripts/lib/step/jquery.step.min.js"></script>

<script src="${contextPath}/resources/scripts/lib/jquery.blockUI.js"></script>
<script src="${contextPath}/resources/scripts/lib/iosOverlay/iosOverlay.js"></script>
<script src="${contextPath}/resources/scripts/lib/iosOverlay/spin.min.js"></script>

<!-- 表单验证 -->
<script src="${contextPath}/resources/scripts/lib/validator/bootstrapValidator.min.js"></script>
<script src="${contextPath}/resources/scripts/lib/validator/language/zh_CN.js"></script>

<!-- treegrid -->
<script src="${contextPath}/resources/scripts/lib/treegrid/jquery.treegrid.min.js"></script>
<script src="${contextPath}/resources/scripts/lib/treegrid/jquery.treegrid.bootstrap3.js"></script>
<!-- treeview -->
<script src="${contextPath}/resources/scripts/lib/treeview/bootstrap-treeview.min.js"></script>

<script src="${contextPath}/resources/scripts/lib/formToWizard/jquery.formtowizard.js"></script>

<script src="${contextPath}/resources/scripts/lib/multiselect/bootstrap-multiselect.js"></script>

<script src="${contextPath}/resources/scripts/app/ajax.js"></script>
<script src="${contextPath}/resources/scripts/lib/base64.js"></script>
<script src="${contextPath}/resources/scripts/app/common.js"></script>
<script type="text/javascript">
	var appPath = "${contextPath}";
	var path = "${contextPath}";
	$(function(){
		$(document).pjax("a[data-pjax]",".content-wrapper",{fragment:".content-wrapper",cache:false});
		$(document).on('pjax:start', function() { NProgress.start();});
		$(document).on('pjax:end',function() { NProgress.done();});
	});
</script>