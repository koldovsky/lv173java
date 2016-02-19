<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="../utils/jspheader.jsp" />
		<title>Register new real estate admin - REDplatform</title>
		<script src="resources/js/lib/jquery/jquery.validate.min.js"></script>
		<script src="resources/js/redAdminRegister.js"></script>
	</head>
	
	<body>
		<h1>Real estate development administrator registration</h1>
		<div class="container">
		
		<div id="error" class="alert alert-danger" role="alert">
			Failed to add new RED Administrator.</div>
		<div id="success" class="alert alert-success" role="alert">
			RED Administrator has been registered successfully.</div>
		<form id="red-admin-register" name="red-admin-register" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label" for="email-adr">Email</label>
					<div class="col-sm-10">
						<input type="text" id="email-adr" name="email-adr" class="data form-control" placeholder="user@example.com" />
					</div>
				</div>
			
				<div class="form-group">
					<label class="col-sm-2 control-label" for="first-name">First name</label>
					<div class="col-sm-10">
						<input id="first-name" name="first-name" class="name data form-control" />
					</div>
				</div>
			
				<div class="form-group">
					<label class="col-sm-2 control-label" for="last-name">Last name</label>
					<div class="col-sm-10">
						<input id="last-name" name="last-name" class="name data form-control" />
					</div>
				</div>
			
				<div class="form-group">
					<label class="col-sm-2 control-label" for="phone">Phone number</label>
					<div class="col-sm-10">
						<input id="phone" name="phone" class="data form-control" placeholder="0653900112"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label">Agency</label>
					<div class="col-sm-10">
						<select id="agency-drop-down" name="agency-drop-down" class="form-control">
							<c:forEach var="agency" items="${agencies}">
								<option value="${agency.id}">${agency.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			
			<button  type="submit" class="btn btn-primary col-sm-2 pull-right">Submit</button>
		</form>
		</div>
	</body>
</html>
