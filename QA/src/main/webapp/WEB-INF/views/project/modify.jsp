<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">MODIFY PROJECT</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="PRJ_CODE">PROJECT CODE</label> <input type="text"
								name='PRJ_CODE' class="form-control" value="${project.PRJ_CODE}"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="PRJ_NAME">PROJECT NAME</label> <input type="text"
								name='PRJ_NAME' class="form-control" value="${project.PRJ_NAME}">
						</div>
						<div class="form-group">
							<label for="PM">PM</label> <input type="text" name="PM"
								class="form-control" value="${project.PM}">
						</div>
						<div class="form-group">
							<label for="START_DATE">START DATE</label> <input type="text"
								name="START_DATE" class="form-control"
								value="${project.START_DATE}" >
						</div>
						<div class="form-group">
							<label for="START_DATE">END DATE</label> <input type="text"
								name="END_DATE" class="form-control" value="${project.END_DATE}">
						</div>
					</div>
				</form>
			</div>
			<!-- /.box-body -->

			<div class="box-footer">
				<button type="submit" class="btn btn-primary">Save</button>
				<button type="submit" class="btn btn-warning">Cancel</button>
			</div>


			<script>
				$(document).ready(function() {

					var formObj = $("form[role='form']");

					console.log(formObj);

					$(".btn-warning").on("click", function() {
						self.location = "/project/listAll";
					});

					$(".btn-primary").on("click", function() {
						formObj.submit();
					});
				});
			</script>
		</div>
	</div>
</section>


