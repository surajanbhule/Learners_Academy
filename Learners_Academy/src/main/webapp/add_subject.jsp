<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>Learners Academy</title>
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

.card {
	margin-top: 100px;
	border: thin;
	border-color: #FFE0B2;
	background: #0F172A;
	color: #FFEB3B;
	padding: 5px;
}

.input-box {
	width: 600px;
	position: relative;
	background: transparent;
	color: #FFEB3B;
	outline: none;
	border: none;
	border-bottom: 1px solid #FEF9C3;
}

.input-box:focus {
	border-radius: 5px;
	border-width: 2px;
	background: transparent;
	color: #FFEB3B;
	border-color: #FFE0B2;
	outline: none;
	border: none;
	border-bottom: 2px solid #FBBF24;
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
<body class="login-body">
	<%@include file="sidemenu.html"%>
	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
	<input type="hidden" id="id" value="<%=request.getAttribute("id")%>">

	<input type="hidden" id="name"
		value="<%=request.getAttribute("name")%>">
	<div class="home-section">


		<div class="row w-100  ">
			<div class="col-12 d-flex justify-content-center align-items-center">

				<div
					class="card w-100 text-center justify-content-center align-items-center login-card">
					<h4 class="card-title">Add Subject</h4>
					<div class="card-body">
						<form action="AddSubject" method="post">



							<div class="mb-3">
								<input type="text" class="form-control-sm input-box"
									id="subject_name" placeholder="Subject Name"
									name="subject_name" autocomplete="off">
							</div>

							<div class="mb-3">
								<input type="number" class="form-control-sm input-box"
									id="number_of_topics" placeholder="No Of Topics"
									name="no_of_topics" autocomplete="off">
							</div>





							<button type="submit" class="btn btn-success">Add
								Subject</button>
						</form>
					</div>
				</div>


			</div>
		</div>

	</div>

	<script src="sweetalert2.all.min.js"></script>
	<script type="text/javascript">
	var status1 = document.getElementById("status").value;
	var id = document.getElementById("id").value;
	var name = document.getElementById("name").value;
	if (status1 == "success") {
	Swal.fire({
		  title: 'Subject Added Successfully',
		  text: 'Subject Id '+id+' Subject Name: '+name,
		  icon: 'success',
		  confirmButtonText: 'Cool'
		})
	}if(status1 == "failed"){
		Swal.fire({
			  title: 'Unable To Add Subject, Something Went Wrong (Check Input And Try Again)',
			  text: 'Messege: '+name,
			  icon: 'error',
			  confirmButtonText: 'OK'
			})
	}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>