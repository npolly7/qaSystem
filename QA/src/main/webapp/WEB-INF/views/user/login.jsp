<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="qaport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value='/resources/css/mainCss.css'/>"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>LOGIN</h1>
	</div>
	<div class="container">
		<form class="form-horizontal" action="/user/loginPost"  method="post">
			<div class="form-group">
				<label class="control-label col-sm-offset-2 col-sm-2" for="email">ID:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="USER_ID" placeholder="Enter ID" name="USER_ID">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-offset-2 col-sm-2" for="password">Password:</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="USER_PW" placeholder="Enter password" name="USER_PW">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<div class="checkbox">
						<label><input type="checkbox" name="USER_COOKIE"> Remember me</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="submit" class="btn btn-default">SUBMIT</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>