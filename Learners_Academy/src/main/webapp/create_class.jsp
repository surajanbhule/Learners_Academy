<%@page import="com.surajanbhule.models.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.surajanbhule.models.Subject"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.surajanbhule.util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
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
	margin-top: 60px;
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

select{
	width: 600px;
	height: 37px;
	padding: 10px 20px;
	appearance:none;
	margin: 10px;
	margin-bottom: 20px;
	background: #0F172A;
	color: #6c757d;
	font-size: 14px;
	font-weight: 500;
}

select option{
	background: #0F172A; 
}



select:focus {
	color: #FFEB3B;
	
}

.selected{
display: none;
}


select:after{
	width: 400px;
	height: 37px;
	padding: 10px 20px;
	appearance: none;
	margin: 10px;
	margin-bottom: 20px;
	background: #0F172A;
	color: #6c757d;
	font-size: 14px;
	font-weight: 500;
	outline: none;
	border: none;
	border-bottom: 1px solid #FEF9C3;
	background: transparent;
}
</style>
</head>
<body class="login-body">
	<%@include file="sidemenu.html"%>
		<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
	<input type="hidden" id="id"
		value="<%=request.getAttribute("id")%>">
		
	<input type="hidden" id="name"
		value="<%=request.getAttribute("name")%>">
	<div class="home-section">


		<div class="row w-100  ">
			<div class="col-12 d-flex justify-content-center align-items-center">

				<div
					class="card w-100 text-center justify-content-center align-items-center login-card">
					<h4 class="card-title">Create Class</h4>
					<div class="card-body">
						<form action="CreateClass" method="post">



							<div class="mb-3">
								<input type="text" class="form-control-sm input-box"
									id="class_name" placeholder="Class Name" name="class_name"
									autocomplete="off">
							</div>

							<div class="mb-3">
								<input type="text" class="form-control-sm input-box"
									id="class_duration" placeholder="Class Duration In Minutes" name="class_duration"
									autocomplete="off">
							</div>

							
                            
                            <div class="mb3">
                             	<select name="selected_subject">
                             	    <option selected class="selected">Select Subject</option>
                             	    <%
                             	     Session sess= HibernateUtil.getSessionFactory().openSession();
                             	     String hql="From Subject";
                             	     Query<Subject> query= sess.createQuery(hql);
                             	     List<Subject> list= query.list();
                             	     
                             	     for(Subject s:list){
                                     %>
                             		<option value="<%= s.getSubject_id() %>"><%= s.getSubject_name() %></option>
                             		<% } %>
                             	</select>
                            </div>
                            
                              <div class="mb3">
                             	<select name="selected_teacher">
                             	    <option selected class="selected">Select Teacher</option>
                             	    <%
                             	     Session sess1= HibernateUtil.getSessionFactory().openSession();
                             	     String hql1="From Teacher";
                             	     Query<Teacher> query1= sess.createQuery(hql1);
                             	     List<Teacher> list1= query1.list();
                             	     
                             	     for(Teacher t:list1){
                                     %>
                             		<option value="<%= t.getTeacher_id() %>"><%= t.getTeacher_first_name()+" "+t.getTeacher_last_name() %></option>
                             		<% } %>
                             	</select>
                            </div>
                            
                  <!--              <div class="mb3">
                             	<select name="selected_students" multiple="multiple" class="multiple">
                             	    
                             		<option>Java</option>
                             		<option>Pyhton</option>
                             		<option>Third</option>
                             		<option>Fourth</option>
                             		<option>Fifth</option>
                             	</select>
                            </div> -->


							<button type="submit" class="btn btn-success">Create
								Class</button>
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
		  title: 'Class created Successfully',
		  text: 'Class Id '+id+' Class Name: '+name,
		  icon: 'success',
		  confirmButtonText: 'OK'
		})
	}if(status1 == "failed"){
		Swal.fire({
			  title: 'Unable To Create Class, Something Went Wrong (Check Input And Try Again)',
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


							