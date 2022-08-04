
<%@page import="com.surajanbhule.util.Login"%>
<%@page import="com.surajanbhule.util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Learning Academy</title>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
<%

 String uname=(String)session.getAttribute("uname");
 String pass=(String)session.getAttribute("pass");
 System.out.println(uname);
 System.out.println(pass);
 if(uname==null||pass==null){
	 uname="";
	 pass="";
 }
 if(uname.equals("surajanbhule69@gmail.com")&&pass.equals("Suraj@2595")){
	 response.sendRedirect("/home.jsp");
 }
 
 Session sess= HibernateUtil.getSessionFactory().openSession();
 Login login=sess.get(Login.class, 1);
 if(!login.getUsername().isEmpty()){
	 login.setUsername("surajanbhule69@gmail.com");
	 login.setPassword("admin@123");
	 sess.beginTransaction();
	 sess.save(login);
	 sess.getTransaction().commit();
 }
%>
	<input type="hidden" id="status"
		value="<%= request.getAttribute("status") %>">
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

							<button type="submit" class="btn btn-outline-success">Login</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	
	<script src="sweetalert2.all.min.js"></script>
	<script type="text/javascript">
	var status1 = document.getElementById("status").value;
	if (status1 == "failed") {
	Swal.fire({
		  title: 'Login Failed',
		  text: 'Please check username or password',
		  icon: 'error',
		  confirmButtonText: 'OK'
		})
	}
	if (status1 == "logout") {
		Swal.fire({
			  title: 'Logout Successfully',
			  text: 'Login again to access admin panel',
			  icon: 'success',
			  confirmButtonText: 'OK'
			})
		}
	if (status1 == "not-login") {
		Swal.fire({
			  title: 'Unable To Access',
			  text: 'Please login first!',
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