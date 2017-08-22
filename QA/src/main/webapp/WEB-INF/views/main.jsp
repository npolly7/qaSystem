<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="include/header.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="qaport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value='/resources/css/mainCss.css'/>"
	rel="stylesheet">
</head>
<body>
	<script>
		var result = '${msg}';
		if (result == 'SUCCESS') {
			alert("정상 처리되었습니다.");
		}
	</script>
	<div class="jumbotron text-center">
		<h1>PROJECTS</h1>
		<br>
		<form>
			<div class="input-group">
				<div class="col-xs-2">
					<select class="form-control" id="searchType" name="searchType">
						<option value="n"
							<c:out value="${crieria.searchType == null?'selected':''}"/>>
							---</option>
						<option value="nm"
							<c:out value="${criteria.searchType eq 'nm'?'selected':''}"/>>
							PROJECT NAME</option>
						<option value="pm"
							<c:out value="${criteria.searchType eq 'pm'?'selected':''}"/>>
							PROJECT MANAGER</option>
						<option value="cd"
							<c:out value="${criteria.searchType eq 'cd'?'selected':''}"/>>
							PROJECT CODE</option>
						<option value="ct"
							<c:out value="${criteria.searchType eq 'ct'?'selected':''}"/>>
							CLIENT</option>
					</select>
				</div>
				<div class="col-xs-10">
					<input type="text" id="keyword" class="form-control col-xs-3" size="10"
						placeholder="INSERT KEYWORD" required>
				</div>
				<div class="input-group-btn">
					<button type="button" id="searchBtn" class="btn btn-success">검색</button>
				</div>

			</div>
		</form>
	</div>
	<div class="container">
		<table class="table">
			<tr>
				<th>Project Code</th>
				<th>Project Name</th>
				<th>PM</th>
				<th>Client</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Update</th>
			</tr>
			<c:forEach items="${list}" var="project">
				<tr>
					<td>${project.PRJ_CODE}</td>
					<td><a href='/project/read${pageMaker.makeSearch(pageMaker.criteria.page)}&PRJ_CODE=${project.PRJ_CODE}'>${project.PRJ_NAME}</a></td>
					<td>${project.PM}</td>
					<td>${project.CLIENT}</td>
					<td>${project.START_DATE}</td>
					<td>${project.END_DATE}</td>
					<td>${project.UPDT_DATE}</td>
				</tr>
			</c:forEach>
		</table>

		<div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a href="listAll${pageMaker.makeSearch(pageMaker.startPage-1)}">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.criteria.page == idx?'class =active':''}"/>>
						<a href="listAll${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a href="listAll${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
				</c:if>

			</ul>
		</div>
	</div>

	<script>
		/* 비밀번호 일치 확인 js */
		function checkPwd() {
			var f1 = document.getElementById('memberRegistForm');
			var pw1 = f1.memberPwd1.value;
			var pw2 = f1.memberPwd2.value;	
			var check = document.getElementById('checkPwd');
			if ((pw1.length == 0) && (pw2.length == 0)) {
				check.innerHTML = "";
			} else if ((pw1 != pw2) || (pw2.length == 0)) {
				check.style.color = "red";
				check.innerHTML = "동일한 암호를 입력하세요.";
			} else {
				check.style.color = "green";
				check.innerHTML = "암호가 확인되었습니다.";
			}
		}
		
		$(document).ready(function(){
			$("#searchBtn").on(
				"click",
				function(event){
					self.location = "listAll"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keyword').val();
				});
			
			$("#keyword").keypress(function(key){
				if(key.keyCode == 13){
					$('#searchBtn').click();
					return false;
				}
			});
		});
	</script>
</body>
</html>