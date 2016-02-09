<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List of users</title>
	</head>
	<body>
		<jsp:include page = "navbar.jsp"></jsp:include>
		<h1>User List</h1>
		<table>
			<c:forEach items="${list}" var="item">
			<tr>
				<td><p>${item.getEmail()}</p></td>
			</tr>
			</c:forEach>
		</table>
		<jsp:include page = "footer.jsp"></jsp:include>
	</body>
</html>