<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/variable.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>电车金融</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <jsp:include page="/WEB-INF/views/common/style.jsp"></jsp:include>
  <!-- REQUIRED JS SCRIPTS -->
  <jsp:include page="/WEB-INF/views/common/script.jsp"></jsp:include>
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href=""><b>电车</b>金融</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <form action="${contextPath}/login" method="post">
      <div class="form-group has-feedback">
        <input name="loginName" type="text" class="form-control" placeholder="请输入用户名">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input name="password" type="password" class="form-control" placeholder="请输入密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div  class="checkbox icheck">
            <label style="display: none;">
              <input value="1" name="rememberMe" type="checkbox"> 记住我
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button id="loginBtn" type="button" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

  </div>
  <!-- /.login-box-body -->
</div>
<script src="${contextPath}/resources/scripts/lib/notie/notie.min.js"></script>
<!-- /.login-box -->
<script type="text/javascript" src="${contextPath}/resources/scripts/app/login.js"></script>
</body>
</html>


