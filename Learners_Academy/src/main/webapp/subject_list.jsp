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

.table-container{
	padding: 0 10%;
	margin: 40px auto 0;
	}

.heading{
	font-size: 40px;
	text-align: center;
	color: #FFEB3B;
	margin-bottom: 40px;
}

.table{
	width: 100%;
	border-collapse: collapse;
}

.table thead{
	background: #FBBF24;
	
}

.table thead tr th{
	font-size: 14px;
	font-weight: 600px;
	letter-spacing: 0.35px;
	opacity: 1;
	padding: 12px;
	vertical-align: top;
	border: 2.5px solid #0F172A ;
}

.table tbody tr td{
	font-size: 14px;
	letter-spacing: 0.35px;
	font-weight: lighter;
	color: #FFEB3B;
	background-color: #1F2937 ;
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

		<div class="table-container">
			<h1 class="heading">Subject List</h1>
			<table class="table">

				<thead>
					<tr>
						<th>Subject ID</th>
						<th>Subject Name</th>
						<th>No Of Topics</th>
					</tr>
				</thead>
				<tbody>
					<tr class="table-row">
						<td >1</td>
						<td>Java</td>
						<td>20</td>
					</tr>
					
					<tr>
						<td>2</td>
						<td>Python</td>
						<td>15</td>
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