<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta charset="UTF-8">
<title>Quality Assurance System</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="/resources/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="/">NEXGEN</a>
		<!-- 넥스젠 로고 -->
	</div>
	<div class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="#">HOME</a>
			<li><a href="#">PROJECT</a>
			<li><a href="/user/mypage">MYPAGE</a>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-bell"></span></a>
			<li><a data-toggle="modal" href="#selectModal"><span
					class="glyphicon glyphicon-plus"></span></a>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"><span
					class="glyphicon glyphicon-user"></span></a>
				<div class="dropdown-menu">
					<form id="formLogin" class="form container-fluid">
						<div class="form-group">
							<label for="id">김기손</label>
						</div>
						<div class="form-group">
							<label for="password">010-6229-0964</label>
						</div>
						<button type="button" id="btnLogin" class="btn btn-block">Logout</button>
					</form>
				</div></li>
		</ul>
	</div>
</nav>

<!-- open the select modal -->
<div class="modal fade" id="selectModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>
					<span class="glyphicon glyphicon-info-sign"></span>&nbsp;SELECT
					REGISTRATION
				</h4>
			</div>
			<div class="modal-body">
				<button type="button" class="memberBtn btn btn-block btn-success"
					data-toggle="modal" href="#memberRegistModal">MEMBER</button>
				<button type="button" class="projectBtn btn btn-block btn-danger"
					data-toggle="modal" href="#projectRegistModal">PROJECT</button>
			</div>
		</div>
	</div>
</div>

<!-- open the project registration modal -->
<div class="modal fade" id="projectRegistModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>
					<span class="glyphicon glyphicon-info-sign"></span>&nbsp;PROJECT
					REGISTRATION
				</h4>
			</div>
			<div class="modal-body">
				<form id="prjRegisterForm" role="form" action="/project/register" method="post">
					<div class="form-group">
						<label for="PRJ_NAME"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;NAME
						</label> <input type="text" class="form-control" id="PRJ_NAME"
							placeholder="INSERT PROJECT NAME">
					</div>
					<div class="form-group">
						<label for="START_DATE"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;START DATE
						</label> <input type="text" class="form-control" id="START_DATE"
							placeholder="INSERT START DATE">
					</div>
					<div class="form-group">
						<label for="END_DATE"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;END DATE
						</label> <input type="text" class="form-control" id="END_DATE"
							placeholder="INSERT END DATE">
					</div>
					<div class="form-group">
						<label for="PRJ_CLIENT"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;CLIENT
						</label> <input type="text" class="form-control" id="PRJ_CLIENT"
							placeholder="INSERT CLIENT">
					</div>
					<div class="form-group">
						<label for="prjPm"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;PM
						</label> <input type="text" class="form-control" id="prjPm"
							placeholder="INSERT PM">
					</div>
					<button type="submit" class="btn btn-block btn-success">
						SUBMIT <span class="glyphicon glyphicon-ok"></span>
					</button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-danger btn-default pull-left"
					data-dismiss="modal">
					<span class="glyphicon glyphicon-remove"></span> Cancel
				</button>
				<p>
					Need <a href="#">help?</a>
				</p>
			</div>
		</div>
	</div>
</div>



<!-- open the member registration modal -->
<div class="modal fade" id="memberRegistModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>
					<span class="glyphicon glyphicon-info-sign"></span>&nbsp;MEMBER
					REGISTRATION
				</h4>
			</div>
			<div class="modal-body">
				<form id="memberRegistForm" role="form" action="/user/register"
					method="post">
					<div class="form-group">
						<label for="memberId"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;ID
						</label> <input type="text" class="form-control" id="USER_ID"
							placeholder="INSERT ID">
						<div>
							<button type="button" class="btn btn-default">CONFIRM ID</button>
						</div>
					</div>
					<div class="form-group">
						<label for="memberName"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;NAME
						</label> <input type="text" class="form-control" id="USER_NAME"
							placeholder="INSERT NAME">
					</div>
					<div class="form-group">
						<label for="memberPwd1"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;PASSWORD
						</label> <input type="password" onfocusout="checkPwd()"
							class="form-control" id="USER_PW" placeholder="INSERT PASSWORD">
					</div>
					<div class="form-group">
						<label for="USER_PW2"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;CONFIRM
							PASSWORD&nbsp;
						</label>
						<p id="checkPwd" style="display: inline;"></p>
						<input type="password" onfocusout="checkPwd()"
							class="form-control" id="USER_PW2" placeholder="CONFIRM PASSWORD">
					</div>
					<div class="form-group">
						<label for="MemberPhone"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;PHONE NUMBER
						</label> <input type="text" class="form-control" id="USER_PHONE"
							placeholder="INSERT PHONE NUMBER">
					</div>
					<button type="submit" class="btn btn-block btn-success">
						SUBMIT <span class="glyphicon glyphicon-ok"></span>
					</button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-danger btn-default pull-left"
					data-dismiss="modal">
					<span class="glyphicon glyphicon-remove"></span> Cancel
				</button>
				<p>
					Need <a href="#">help?</a>
				</p>
			</div>
		</div>
	</div>
</div>
