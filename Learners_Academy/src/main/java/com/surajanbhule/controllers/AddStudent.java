package com.surajanbhule.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.surajanbhule.models.Classes;
import com.surajanbhule.models.Student;
import com.surajanbhule.util.HibernateUtil;


public class AddStudent extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session= HibernateUtil.getSessionFactory().openSession();
		String first_name=req.getParameter("student_first_name");
		String last_name=req.getParameter("student_last_name");
		String address=req.getParameter("student_address");
		String email=req.getParameter("student_email");
		String phone=req.getParameter("student_phone");
		
		int class_id= Integer.parseInt(req.getParameter("selected_class"));
		Classes class1= session.get(Classes.class, class_id);
		
		List<Classes> list=new ArrayList<Classes>();
		list.add(class1);
		
		Student student = new Student();
		student.setStudent_first_name(first_name);
		student.setStudent_last_name(last_name);
		student.setStudent_email(email);
		student.setStudent_address(address);
		student.setStudent_phone(phone);
		student.setClasses_list(list);
		
		try {
		session.beginTransaction();
		Serializable serializable=session.save(student);
		int id=(int)serializable;
		session.getTransaction().commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("/add_student.jsp");
		req.setAttribute("status","success");
		req.setAttribute("id", id);
		req.setAttribute("name", first_name+" "+last_name);
		rd.include(req, resp);
		}catch (Exception e) {
			RequestDispatcher rd =req.getRequestDispatcher("/add_student.jsp");
			req.setAttribute("status", "failed");
			req.setAttribute("name", e);
			req.setAttribute("id", "0");
			rd.include(req, resp);
		}
		
	}
	
	
}
