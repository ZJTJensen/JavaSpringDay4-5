<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<h1>New Person</h1>
		<form:form method="POST" action="/persons/new" modelAttribute="person">
			<form:label path="firstName">First Name
			<form:errors path="firstName"/>
			<form:input path="firstName"/></form:label>
			
			<form:label path="lastName">Last Name
			<form:errors path="lastName"/>
			<form:input path="lastName"/></form:label>

			<input type="submit" value="Create"/>
		</form:form>
	</body>
</html>