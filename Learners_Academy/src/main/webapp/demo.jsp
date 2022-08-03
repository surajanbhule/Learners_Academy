<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="@sweetalert2/theme-dark/dark.css">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<c:set var="income" scope="session" value="${4000*4}" />
	<c:if test="${income > 8000}">
		<p>
			My income is:
			<c:out value="${income}" />
		<p>
	</c:if>
	<script type="text/javascript">
	Swal.fire({
		  title: 'Error!',
		  text: 'Do you want to continue',
		  icon: 'error',
		  confirmButtonText: 'Ok'
		})	
	</script>
	<script src="sweetalert2.all.min.js"></script>
</body>
</html>