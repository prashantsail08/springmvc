<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${ student }</h1>
	
	<h1>Name is ${student.name }</h1>
	<h1>Student id is ${student.id }</h1>
	<h1>date is ${student.dob }</h1>
	<c:forEach var="item" items="${student.courses }">
		<h1><c:out value="${item }"></c:out></h1>
	</c:forEach>
<%-- 	<h1>courses is ${student.courses }</h1> --%>
	<h1>Gender is ${student.gender }</h1>
	<h1>Type is ${student.type }</h1>
	<hr>
	<h1>Address street is ${student.address.street }</h1>
	<h1>Address city is ${student.address.city }</h1>

</body>
</html>