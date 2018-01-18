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
		<h1>New License

			<form:form method="POST" action="/licenses/new" modelAttribute="license">
				<form:label path="person_id">Name
				<form:errors path="person_id"/>
				<c:forEach items="${persons}" var="person" varStatus="loop">
					<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
				</c:forEach></form:label>
				<form:label path="state">State
				<form:errors path="state"/>
				<form:textarea path="state"/></form:label>

				<form:label path="expiration_date">Expiration Date
				<form:errors path="expiration_date"/>
				<form:textarea path="expiration_date"/></form:label>
				<form:input type="hidden" name="number" value="00000${person_id}">

				<input type="submit" value="Create"/>
			</form:form>
			
		</h1>
	</body>
</html>