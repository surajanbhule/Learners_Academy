<%@page import="org.hibernate.Query"%>
<%@page import="com.surajanbhule.models.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.surajanbhule.util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<title>Subject List</title>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Varta:wght@300&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Varta', sans-serif;
}

.table-container {
	padding: 0 10%;
	margin: 40px auto 0;
}

.heading {
	font-size: 40px;
	text-align: center;
	color: #FFEB3B;
	margin-bottom: 40px;
}

.table {
	width: 100%;
	border-collapse: collapse;
}

.table thead {
	background: #FBBF24;
}

.table thead tr th {
	font-size: 14px;
	font-weight: 600px;
	letter-spacing: 0.35px;
	opacity: 1;
	padding: 12px;
	vertical-align: top;
	border: 2.5px solid #0F172A;
	text-align: center;
}

.table tbody tr td {
	font-size: 14px;
	letter-spacing: 0.35px;
	font-weight: lighter;
	color: #FFEB3B;
	background-color: #1F2937;
	padding: 8px;
	text-align: center;
	border: 2.5px solid #0F172A;
}

.home-section {
	background: #0F172A;
	position: relative;
	min-height: 100vh;
	top: 0;
	left: 110px;
	width: calc(100% - 250px);
	transition: all 0.5s ease;
	z-index: 2;
}

body {
	background: #0F172A;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store");
	String uname = (String) session.getAttribute("uname");
	String pass = (String) session.getAttribute("pass");
	if (uname == null || pass == null) {
		uname = "";
		pass = "";
	}
	if (uname.equals("") && pass.equals("")) {
		request.setAttribute("status", "not-login");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		request.setAttribute("status", "not-login");
		rd.forward(request, response);
	}
	%>
	<%@include file="sidemenu.html"%>
	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
	<input type="hidden" id="id" value="<%=request.getAttribute("id")%>">

	<input type="hidden" id="name"
		value="<%=request.getAttribute("name")%>">
	<div class="home-section">

		<div class="table-container">
			<h1 class="heading">Subject List</h1>
			<table class="table">

				<thead>
					<tr>
						<th>Subject ID</th>
						<th>Subject Name</th>
						<th>No Of Topics</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<%
					Session sess = HibernateUtil.getSessionFactory().openSession();

					String hql = "From Subject";

					@SuppressWarnings("deprecation")
					Query<Subject> query = sess.createQuery(hql);
					List<Subject> list = query.list();

					for (Subject s : list) {
					%>
					<tr>
						<td><%=s.getSubject_id()%></td>
						<td><%=s.getSubject_name()%></td>
						<td><%=s.getNo_of_topics()%></td>
						<td>
							<form action="DeleteSubject" method="post">
								<input type="hidden" value="<%=s.getSubject_id()%>"
									name="subject_id"> <input type="hidden"
									value="<%=s.getSubject_name()%>" name="subject_name">
								<button type="submit" class="btn btn-outline-danger btn-sm">Delete</button>
							</form>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>

			</table>
		</div>

	</div>
	<script src="sweetalert2.all.min.js"></script>
	<script type="text/javascript">
		var status1 = document.getElementById("status").value;
		var id = document.getElementById("id").value;
		var name = document.getElementById("name").value;
		if (status1 == "delete") {
			Swal.fire({
				title : 'Subject Deleted Successfully',
				text : 'Subject Id : ' + id + '| Subject Name: ' + name,
				icon : 'success',
				confirmButtonText : 'Ok'
			})
		}
		if (status1 == "not-delete") {
			Swal
					.fire({
						title : 'Unable To Delete Subject, Something Went Wrong (Try Again)',
						text : 'Messege: ' + name,
						icon : 'error',
						confirmButtonText : 'OK'
					})
		}
		if (status1 == "empty") {
			Swal
					.fire({
						title : 'Please fill all input values',
						text : 'You should fill all text and select specific option from dropdown ',
						icon : 'error',
						confirmButtonText : 'OK'
					})
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>