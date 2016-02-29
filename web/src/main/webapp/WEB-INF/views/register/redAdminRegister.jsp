<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<title>Real estate development administrator registration -
	REDplatform</title>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/redAdminRegister.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/regexes.js"></script>
</head>

<body>
	<jsp:include page="../utils/navbar.jsp"></jsp:include>
	<div class="container">
		<h1 class="center">New real estate development administrator</h1>
		<div id="error" class="alert alert-danger" role="alert">Failed
			to add new administrator.</div>
		<div id="success" class="alert alert-success" role="alert">
			Administrator has been registered successfully.</div>
		<form id="red-admin-register" name="red-admin-register">
			<div class="col-sm-offset-3 col-sm-6">
				<div class="row">
					<div class="col-sm-12 text-danger">
						<p class="center"><b>Fields marked with <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> are required.
						</b></p>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12 form-group">
						<label class="control-label" for="mail"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span>Email
						</label> <input id="mail" name="mail" class="data form-control"
							placeholder="john.smith@example.com" />
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6 form-group">
						<label class="control-label" for="first-name"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span>First name
						</label> <input id="first-name" name="first-name"
							class="data name form-control" placeholder="John" />
					</div>

					<div class="col-sm-6 form-group">
						<label class="control-label" for="last-name"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span>Last name
						</label> <input id="last-name" name="last-name"
							class="data name form-control" placeholder="Smith" />
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12 form-group">
						<label class="control-label" for="phone"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span>Phone number
						</label> <input id="phone" name="phone" class="data form-control"
							placeholder="(+38)0123456789" />
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12 form-group">
						<label class="control-label" for="agency-drop-down"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span>Agency
						</label> <select id="agency-drop-down" name="agency-drop-down"
							class="data form-control">
							<c:forEach var="agency" items="${agencies}">
								<option value="${agency.id}">${agency.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<button type="submit"
				class="btn btn-primary col-sm-offset-5 col-sm-2">Submit</button>
		</form>
	</div>
	<jsp:include page="../utils/footer.jsp"></jsp:include>
</body>
</html>
