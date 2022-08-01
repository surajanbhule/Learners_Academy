
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Learning Academy</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
	integrity="sha512-1sCRPdkRXhBV2PBLUdRb4tMg1w2YPf37qatUFeS7zlBy7jJI8Lf4VHwWfZZfpXtYSLy85pkm9GaYVYMfw5BC1A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<style type="text/css">
.card {
	margin-top: 25%;
	border: thin;
	border-color: #FFE0B2;
	background: #19123b;
	color: #FFEB3B;
	padding: 5px;
}

.input-box {
	width: 400px;
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

body {
	background: #1F2937;
}
</style>
</head>
<body class="login-body">
	<div class="container mt-5">
		<div class="row w-100  ">
			<div class="col-12 d-flex justify-content-center align-items-center">

				<div
					class="card w-50 text-center justify-content-center align-items-center login-card">
					<h2 card="title text-center ">
						<i class="fa-solid fa-user-graduate"></i> Learners Academy
					</h2>
					<div class="card-body  ">
						<form action="AdminLogin" method="post">
							<div class="mb-3">
								<i class="fa-solid fa-envelope"></i> <input type="email"
									class="form-control-sm input-box" id="email"
									placeholder="email@example.com" name="username">
							</div>

							<div class="mb-3">
								<i class="fa-solid fa-key"></i><input type="password"
									class="form-control-sm input-box" id="password"
									placeholder="password" name="password">
							</div>

							<button type="submit" class="btn btn-success">Login</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>