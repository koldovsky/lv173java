<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form id="red-admin-register" name="red-admin-register">
	<div class="col-sm-offset-3 col-sm-6">
		<div class="row">
			<div class="col-sm-12 text-danger">
				<p class="center">
					<b>Fields marked with <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> are required.
					</b>
				</p>
			</div>
		</div>
		
		<input id="id" name="id" type="hidden" class="data" value="${admin.id}"/>

		<div class="row">
			<div class="col-sm-12 form-group">
				<label class="control-label" for="email"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>Email
				</label> <input id="email" name="email" class="data form-control"
					value="${admin.email}" 
					placeholder="john.smith@example.com" />
			</div>
		</div>

		<div class="row">
			<div class="col-sm-6 form-group">
				<label class="control-label" for="firstName"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>First
					name
				</label> <input id="firstName" name="firstName" 
				value="${admin.firstName}"
					class="data name form-control" placeholder="John" />
			</div>

			<div class="col-sm-6 form-group">
				<label class="control-label" for="lastName"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>Last
					name
				</label> <input id="lastName" name="lastName" class="data name form-control"
					value="${admin.lastName}" 
					placeholder="Smith" />
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12 form-group">
				<label class="control-label" for="phone"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>Phone
					number
				</label> <input id="phone" name="phone" class="data form-control"
					value="${admin.phone}" 
					placeholder="(+38)0123456789" />
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12 form-group">
				<label class="control-label" for="agencyId"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>Agency
				</label> <select id="agencyId" name="agencyId" class="data form-control">
					<c:forEach var="agency" items="${agencies}">
						<option value="${agency.id}">${agency.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>

	<button type="submit" class="btn btn-primary col-sm-offset-5 col-sm-2">Submit</button>
</form>