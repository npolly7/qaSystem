<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="qaport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link href="<c:url value='/resources/css/mainCss.css'/>" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<title>NEXGEN QAS</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#myPage">NEXGEN</a> <!-- 넥스젠 로고 -->
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">HOME</a>
				<li><a href="#">PROJECT</a>
				<li><a href="#">MYPAGE</a>
			</ul>	
			<ul class="nav navbar-nav navbar-right">
				 <li><a href="#"><span class="glyphicon glyphicon-bell"></span></a>
				 <li><a data-toggle="modal" href="#selectModal"><span class="glyphicon glyphicon-plus"></span></a>
				 <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span></a>
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
          	</div>
        	</li>
        	</ul>
        </div>
</nav>

	<div class="jumbotron text-center">
	
  <h1>PROJECTS</h1><br>
  <form>
    <div class="input-group">
      <input type="text" class="form-control" size="10" placeholder="프로젝트 명" required>
      <div class="input-group-btn">
        <button type="button" class="btn btn-success">검색</button>
      </div>
    </div>
  </form>
</div>
<div class="container">
	<table class="table">
	<c:choose>
		<c:when test="{fn:length(list)>0">
			<c:forEach items="${list}" var ="row"> 
			<tr>
				<td>${row}</td>
			</tr>
			</c:forEach>
		</c:when>
	</c:choose>
		<tr>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>서울시 프로젝트</td>
		<td>서울시 프로젝트</td>
		</tr>
		<tr>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>서울시 프로젝트</td>
		<td>서울시 프로젝트</td>
		</tr>
		<tr>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>서울시 프로젝트</td>
		<td>서울시 프로젝트</td>
		</tr>
		<tr>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>서울시 프로젝트</td>
		<td>서울시 프로젝트</td>
		</tr>
		<tr>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>서울시 프로젝트</td>
		<td>서울시 프로젝트</td>
		</tr>
		<tr>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>서울시 프로젝트</td>
		<td>서울시 프로젝트</td>
		</tr>
		<tr>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>부산시 프로젝트</td>
		<td>서울시 프로젝트</td>
		<td>서울시 프로젝트</td>
		</tr>
	</table>
</div>
<!-- open the select modal -->
<div class="modal fade" id="selectModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4><span class="glyphicon glyphicon-info-sign"></span>&nbsp;SELECT REGISTRATION</h4>
			</div>
			<div class="modal-body">
				<button type="button" class="memberBtn btn btn-block btn-success" data-toggle="modal" href="#memberRegistModal">MEMBER</button>
				<button type="button" class="projectBtn btn btn-block btn-danger" data-toggle="modal" href="#projectRegistModal">PROJECT</button>
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
				<h4><span class="glyphicon glyphicon-info-sign"></span>&nbsp;PROJECT REGISTRATION</h4>
			</div>
			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<label for="prjName"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;NAME</label>
						<input type="text" class="form-control" id="prjName" placeholder="프로젝트 명 입력">
					</div>
					<div class="form-group">
						<label for="prjStartDate"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;START DATE</label>
						<input type="text" class="form-control" id="prjStartDate" placeholder="시작 날짜 입력">
					</div>
					<div class="form-group">
						<label for="prjEndDate"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;END DATE</label>
						<input type="text" class="form-control" id="prjEndDate" placeholder="마감 날짜 입력">
					</div>
					<div class="form-group">
						<label for="prjClient"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;CLIENT</label>
						<input type="text" class="form-control" id="prjClient" placeholder="고객사 명 입력">
					</div>
					<div class="form-group">
						<label for="prjPm"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;PM</label>
						<input type="text" class="form-control" id="prjPm" placeholder="PM 명 입력">
					</div>
					<div class="form-group">
						<label for="prjDev"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;DEVELOPERS</label>
						<input type="text" class="form-control" id="prjDev" placeholder="개발자 명 입력">
					</div>
					<button type="submit" class="btn btn-block btn-success">프로젝트 등록 <span class="glyphicon glyphicon-ok"></span></button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
				 <span class="glyphicon glyphicon-remove"></span> Cancel
				</button>
				<p>Need <a href="#">help?</a></p>
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
				<h4><span class="glyphicon glyphicon-info-sign"></span>&nbsp;MEMBER REGISTRATION</h4>
			</div>
			<div class="modal-body">
				<form id="memberRegistForm" role="form">
					<div class="form-group">
						<label for="memberId"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;ID</label>
						<input type="text" class="form-control" id="memberId" placeholder="아이디 입력">
						<div>
							<button type="button" class="btn btn-default">아이디 중복 확인</button>
						</div>
					</div>
					<div class="form-group">
						<label for="memberName"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;NAME</label>
						<input type="text" class="form-control" id="memberName" placeholder="이름 입력">
					</div>
					<div class="form-group">
						<label for="memberPwd1"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;PASSWORD</label>
						<input type="password" onfocusout="checkPwd()" class="form-control" id="memberPwd1" placeholder="패스워드 입력">
					</div>
					<div class="form-group">
						<label for="memberPwd2"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;CONFIRM PASSWORD&nbsp;</label>
						<p id="checkPwd" style="display:inline;"></p>
						<input type="password" onfocusout="checkPwd()" class="form-control" id="memberPwd2" placeholder="패스워드 재입력">
					</div>
					<div class="form-group">
						<label for="MemberPhone"><span class="glyphicon glyphicon-pushpin"></span>&nbsp;PHONE NUMBER</label>
						<input type="text" class="form-control" id="memberPhone" placeholder="연락처 입력">
					</div>
					<button type="submit" class="btn btn-block btn-success">회원 등록 <span class="glyphicon glyphicon-ok"></span></button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
				 <span class="glyphicon glyphicon-remove"></span> Cancel
				</button>
				<p>Need <a href="#">help?</a></p>
			</div>
		</div>
	</div>
</div>
<script>
/* 비밀번호 일치 확인 js */
function checkPwd(){
	var f1 = document.getElementById('memberRegistForm');
	var pw1=f1.memberPwd1.value;
	var pw2=f1.memberPwd2.value;
	var check=document.getElementById('checkPwd');
	if((pw1.length==0)&&(pw2.length==0)){
		check.innerHTML="";		
	} else if((pw1!=pw2)||(pw2.length==0)){
		check.style.color="red";
		check.innerHTML="동일한 암호를 입력하세요.";
	}else{
		check.style.color="green";
		check.innerHTML="암호가 확인되었습니다.";
	}
}
</script>
</body>
</html>