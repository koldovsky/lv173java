<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Register new real estate admin - REDplatform</title>
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body>
		<h1>Real estate development admin registration</h1>
		<div class="container">
		
		<form:form modelAttribute="redAdmin" class="form-horizontal">
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label" for="email">Email</label>
					<div class="col-sm-10">
						<form:input path="email" type="email" id="email" class="form-control" />
						<form:errors path="email" class="control-label" />
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label" for="first-name">First name</label>
					<div class="col-sm-10">
						<form:input path="firstName" id="first-name" class="form-control" />
						<form:errors path="firstName" class="control-label" />
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label" for="last-name">Last name</label>
					<div class="col-sm-10">
						<form:input path="lastName" id="last-name" class="form-control" />
						<form:errors path="lastName" class="control-label" />
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label" for="phone">Phone number</label>
					<div class="col-sm-10">
						<form:input path="phone" id="phone" class="form-control" />
						<form:errors path="phone" class="control-label" />
					</div>
				</div>
			</spring:bind>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="agency">Agency</label>
				<div class="col-sm-10">
					<form:select path="agency" id="agency" class="form-control">
						<form:options items="${agencies}" itemValue="id" itemLabel="name"/>
					</form:select>
				</div>
			</div>
			<button  type="submit" class="btn btn-primary col-sm-2 pull-right">Submit</button>
		</form:form>
		</div>
		<script src="resources/bootstrap/js/lib/bootstrap/bootstrap.js"></script>
	</body>
</html>
