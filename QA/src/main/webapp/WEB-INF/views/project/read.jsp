<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.jsp"%>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ PROJECT</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post" action="/project/remove">

					<input type='hidden' name='PRJ_CODE' value="${project.PRJ_CODE}">
					<input type='hidden' name='page' value="${criteria.page}">
					<input type='hidden' name='perPageNum'
						value="${criteria.perPageNum}"> <input type='hidden'
						name='searchType' value="${criteria.searchType}"> <input
						type='hidden' name='keyword' value="${criteria.keyword}">

				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="PRJ_NAME">PROJECT NAME</label> <input type="text"
							name='PRJ_NAME' class="form-control" value="${project.PRJ_NAME}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="PM">PM</label> <input type="text" name="PM"
							class="form-control" value="${project.PM}" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="START_DATE">START DATE</label> <input type="text"
							name="START_DATE" class="form-control"
							value="${project.START_DATE}" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="START_DATE">END DATE</label> <input type="text"
							name="END_DATE" class="form-control" value="${project.END_DATE}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="UPDT_DATE">UPDATE</label> <input type="text"
							name="UPDT_DATE" class="form-control"
							value="${project.UPDT_DATE}" readonly="readonly">
					</div>
				</div>
			</div>
			<!-- /.box-body -->

			<div class="box-footer">
				<button type="submit" id="modifyPrjBtn" class="btn btn-warning">MODIFY</button>
				<button type="submit" id="removePrjBtn" class="btn btn-danger">REMOVE</button>
				<button type="submit" id="listAllBtn" class="btn btn-primary">LIST
					ALL</button>
			</div>
		</div>
	</div>
</section>

<section class="content">
	<form id="testCaseForm" method="post">

		<input type='hidden' name='PRJ_CODE' value="${project.PRJ_CODE}">
		<input type='hidden' name='page' value="${criteria.page}">
		<input type='hidden' name='perPageNum' value="${criteria.perPageNum}">
		<input type='hidden' name='searchType' value="${criteria.searchType}">
		<input type='hidden' name='keyword' value="${criteria.keyword}">
		<input type='hidden' name='UPDT_USER' value="${login.USER_CODE}">
		<input type='hidden' name='state'>
		<table class="table">
			<thead>
				<tr>
					<th>CHECK</th>
					<th>CODE</th>
					<th>NAME</th>
					<th>CONTENTS</th>
					<th>WRITER</th>
					<th>UPDATE_USER</th>
					<th>UPDATE_DATE</th>
					<th>STATE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${testCase}" var="testCase">
					<c:if test="${testCase.STATE == 1}">
						<tr class="Active">
					</c:if>
					<c:if test="${testCase.STATE == 2}">
						<tr class="Warning">
					</c:if>
					<c:if test="${testCase.STATE == 3}">
						<tr class="Success">
					</c:if>
					<c:if test="${testCase.STATE == 4}">
						<tr class="Danger">
					</c:if>
					<td><input type="checkbox" name="TC_CODE" id="TC_CODE"
						value="${testCase.TC_CODE}" /></td>
					<td>${testCase.TC_CODE}</td>
					<td>${testCase.TC_NAME}</td>
					<td>${testCase.CONTENTS}</td>
					<td>${testCase.TC_WRITER}</td>
					<td>${testCase.UPDT_USER }</td>
					<td>${testCase.UPDT_DATE}</td>
					<c:if test="${testCase.STATE == 1}">
						<td>일반</td>
					</c:if>
					<c:if test="${testCase.STATE == 2}">
						<td>요청</td>
					</c:if>
					<c:if test="${testCase.STATE == 3}">
						<td>완료</td>
					</c:if>
					<c:if test="${testCase.STATE == 4}">
						<td>재검토</td>
					</c:if>
					</tr>
				</c:forEach>

			</tbody>
		</table>


	</form>
	<div class="box-footer2">
		<button type="submit" id="basicTcBtn" class="btn btn-basic">BASIC CONDITION</button>
		<button type="submit" id="requestTcBtn" class="btn btn-warning">REQUEST</button>
		<button type="submit" id="confirmTcBtn" class="btn btn-success">CONFIRM</button>
		<button type="submit" id="reExamineTcBtn" class="btn btn-danger">RE-EXAMINE</button>
	
	</div>
	<div class="box-footer">
		<button type="submit" id="modifyTcBtn" class="btn btn-warning">MODIFY</button>
		<button type="submit" id="removeTcBtn" class="btn btn-danger">REMOVE</button>
		<button type="submit" id="addTcBtn" class="btn btn-primary">ADD</button>
	</div>
</section>



<!-- MODAL -->

<div class="modal fade" id="addTestCaseModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4>
					<span class="glyphicon glyphicon-info-sign"></span>&nbsp;ADD
					TESTCASE
				</h4>
			</div>
			<div class="modal-body">
				<form id="addTcForm" role="form" action="/project/testCase/add"
					method="post">
					<input type="hidden" id="PRJ_CODE" name="PRJ_CODE"
						value="${project.PRJ_CODE}"> <input type="hidden"
						id="TC_WRITER" name="TC_WRITER" value="${login.USER_CODE}">
					<input type="hidden" id="page" name="page" value="${criteria.page}">
					<input type="hidden" id="perPageNum" name="perPageNum"
						value="${criteria.perPageNum}"> <input type="hidden"
						id="searchType" name="searchType" value="${criteria.searchType}">
					<input type="hidden" id="keyword" name="keyword"
						value="${criteria.keyword}">
					<div class="form-group">
						<label for="tcName"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;NAME
						</label> <input type="text" class="form-control" id="TC_NAME"
							name="TC_NAME" placeholder="INSERT CASE NAME">
					</div>
					<div class="form-group">
						<label for="contents"> <span
							class="glyphicon glyphicon-pushpin"></span>&nbsp;CONTENTS
						</label> <input type="text" class="form-control" id="CONTENTS"
							name="CONTENTS" placeholder="INSERT CONTENTS">
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
			</div>
		</div>
	</div>
</div>



<div id="removeConfirmModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Remove Project</h4>
			</div>
			<div class="modal-body">
				<p>해당 프로젝트의 테스트케이스까지 모두 삭제됩니다. 정말 삭제하시겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<button type="button" id="confirmRemoveBtn" class="btn btn-danger"
					data-dismiss="modal">Delete</button>
			</div>
		</div>

	</div>
</div>

<div id="removeTcConfirmModal" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Remove TestCase</h4>
			</div>
			<div class="modal-body">
				<p>삭제 후에는 복구가 불가능합니다. 정말 삭제하시겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<button type="button" id="confirmTcRemoveBtn" class="btn btn-danger"
					data-dismiss="modal">Delete</button>
			</div>
		</div>

	</div>
</div>

<div id="requestTcStateModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Modify State</h4>
			</div>
			<div class="modal-body">
				<p>해당 테스트 케이스의 상태를 변경하시겠습니까?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<button type="button" id="confirmTcRequestBtn" class="btn btn-primary"
					data-dismiss="modal">Confirm</button>
			</div>
		</div>

	</div>
</div>

<style>
.box-footer {
	float: right;
}
.box-footer2{
	float: left;
}
</style>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		$("#modifyPrjBtn").on("click", function() {
			formObj.attr("action", "/project/modify");
			formObj.attr("method", "get");
			formObj.submit();
			});

		$("#removePrjBtn").on("click", function() {
			$("#removeConfirmModal").modal();
			});

		$("#addTcBtn").on("click", function() {
			$("#addTestCaseModal").modal();
			});
		$("#modifyTcBtn").on("click", function() {
			formObj.attr("action", "/project/testCase/modify");
			formObj.attr("method", "get");
			formObj.submit();
			});
		
		$("#removeTcBtn").on("click", function() {
			$("#removeTcConfirmModal").modal();
			});
		$("#confirmTcRemoveBtn").on("click", function() {
			$("#testCaseForm").attr("action","/project/testCase/remove");
			$("#testCaseForm").submit();
			});
		
		$("#listAllBtn").on("click",function() {
			$(location).attr("href", "/project/listAll?page=${criteria.page}&perPageNum=${criteria.perPageNum}" + "&searchType=${criteria.searchType}&keyword=${criteria.keyword}");
			});
		
		$("#confirmRemoveBtn").on("click", function() {
			var formObj = $("form[role='form']");
			formObj.submit();
			});
		
		$("#confirmTcRequestBtn").on("click", function(){
			$("#testCaseForm").attr("action","/project/testCase/modifyState");
			$("#testCaseForm").submit();
			});
		
		$("#basicTcBtn").on("click", function(){
			$('input[name="state"]').val("1");
			$("#requestTcStateModal").modal();
			});
		
		$("#requestTcBtn").on("click", function(){
			$('input[name="state"]').val("2");
			$("#requestTcStateModal").modal();
			});
		
		$("#confirmTcBtn").on("click", function(){
			$('input[name="state"]').val("3");
			$("#requestTcStateModal").modal();
			});
		
		$("#reExamineTcBtn").on("click", function(){
			$('input[name="state"]').val("4");
			$("#requestTcStateModal").modal();
			});
		});
</script>

