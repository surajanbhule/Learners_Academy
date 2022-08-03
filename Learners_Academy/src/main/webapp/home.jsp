<%@page import="com.surajanbhule.models.Student"%>
<%@page import="com.surajanbhule.models.Classes"%>
<%@page import="com.surajanbhule.models.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.surajanbhule.models.Teacher"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.surajanbhule.util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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

	<%@include file="sidemenu.html"%>

	<div class="home-section">
		<%
		Session s = HibernateUtil.getSessionFactory().openSession();
		String h1 = "From Student";
		Query<Student> q1 = s.createQuery(h1);
		List<Student> students = q1.list();

		int no_of_students = students.size();

		String h2 = "From Teacher";
		Query<Teacher> q2 = s.createQuery(h2);
		List<Teacher> teachers = q2.list();

		int no_of_teachers = teachers.size();

		String h3 = "From Subject";
		Query<Subject> q3 = s.createQuery(h3);
		List<Subject> subjects = q3.list();

		int no_of_subjects = subjects.size();

		String h4 = "From Classes";
		Query<Classes> q4 = s.createQuery(h4);
		List<Classes> classes = q4.list();

		int no_of_classes = classes.size();

		s.close();
		%>
		<div class="mt-3 ms-5">

			<button type="button"
				class="btn btn-outline-success position-relative mt-5 ms-5">
				Students <span
					class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					<%=no_of_students%>
				</span>
			</button>

			<button type="button"
				class="btn btn-outline-success position-relative mt-5 ms-5">
				Teachers <span
					class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					<%=no_of_teachers%>
				</span>
			</button>

			<button type="button"
				class="btn btn-outline-success position-relative mt-5 ms-5">
				Subjects <span
					class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					<%=no_of_subjects%>
				</span>
			</button>

			<button type="button"
				class="btn btn-outline-success position-relative mt-5 ms-5">
				Classes <span
					class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
					<%=no_of_classes%>
				</span>
			</button>
		</div>

		<div class="table-container">
			<h1 class="heading">Current Active Classes</h1>
			<table class="table">

				<thead>
					<tr>
						<th>Class ID</th>
						<th>Class Name</th>
						<th>Teacher Name</th>
						<th>Subject Name</th>
						<th>Duration In Minutes</th>
						<th>Students</th>

					</tr>
				</thead>
				<tbody>
					<%
					Session sess = HibernateUtil.getSessionFactory().openSession();
					String hql = "From Classes";
					Query<Classes> query = sess.createQuery(hql);
					List<Classes> list = query.list();

					for (Classes c : list) {
					%>
					<tr>
						<td><%=c.getClass_id()%></td>
						<td><%=c.getClass_name()%></td>
						<td><%=c.getTeacher().getTeacher_first_name()%></td>
						<td><%=c.getSubject().getSubject_name()%></td>
						<td><%=c.getClass_duration()%></td>
                        
						<td> <form action="view_students.jsp" method="post">
								<input type="hidden" value="<%= c.getClass_id() %>"
									name="class_id">
								<input type="hidden" value="<%= c.getClass_name() %>"
									name="class_name">
								<button type="submit" class="btn btn-outline-success btn-sm">View
									Students</button>
							</form></td>
						<%
						}
						%>
					</tr>


				</tbody>

			</table>
		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>