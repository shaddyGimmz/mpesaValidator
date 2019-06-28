<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/general.css"/>" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-fluid">

		<div class="panel panel-default">
			<img src="/loginProject/resources/images/gimmz.png">
			<div class="panel-heading">
				<h4>Sign in</h4>
			</div>
			<div class="panel-body">
			<spring:url value="/save" var="formUrl" />
              <form:form action="${formUrl}" method="POST" modelAttribute="user">
				<div class="form-group">
					<label for="username">User name</label> 
					<form:input type="text" path="username"
						class="form-control" id="username" placeholder="Enter name"
						size="50"/>
				</div>
				<div class="form-group">
					<label for="pwd">Password</label> 
					<form:input  path="password" type="password"
						class="form-control" id="pwd" placeholder="Enter password"/>
						<form:errors path="password"/>
				</div>
				<button type="submit" class="btn btn-default">Continue</button>
				</form:form>
			</div>
			<div class="panel-footer">
				<h5>
					New to GimmzAuto? <a href="#">Create account >></a>
				</h5>
			</div>
		</div>
	</div>
</body>
</html>