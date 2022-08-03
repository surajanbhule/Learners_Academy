package com.surajanbhule.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.surajanbhule.models.Subject;
import com.surajanbhule.models.Teacher;
import com.surajanbhule.util.HibernateUtil;


public class AddTeacher extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session =HibernateUtil.getSessionFactory().openSession();
		String first_name=req.getParameter("teacher_first_name");
		String last_name=req.getParameter("teacher_last_name");
		String email=req.getParameter("teacher_email");
		String phone=req.getParameter("teacher_phone");
		String address=req.getParameter("teacher_address");
		
		String[] values=req.getParameterValues("selected_subjects");
		PrintWriter out=resp.getWriter();
		List<Subject> subject_list= new ArrayList<Subject>();
		int i=0;
		
		for(String value:values) {
			int id= Integer.parseInt(value);
			Subject subject= session.get(Subject.class, id);
			subject_list.add(subject);
		}
		
		Teacher teacher = new Teacher();
		teacher.setTeacher_first_name(first_name);
		teacher.setTeacher_last_name(last_name);
		teacher.setTeacher_address(address);
		teacher.setTeacher_email(email);
		teacher.setTeacher_phone(phone);
		
		 teacher.setSubject_list(subject_list);
		
		try {
		session.beginTransaction();
		Serializable serializable=session.save(teacher);
		int id=(int)serializable;
		session.getTransaction().commit();
		RequestDispatcher rd= req.getRequestDispatcher("/add_teacher.jsp");
		req.setAttribute("status", "success");
		req.setAttribute("name", first_name+" "+last_name);
		req.setAttribute("id", id);
		rd.include(req, resp);
		}catch (Exception e) {
			RequestDispatcher rd =req.getRequestDispatcher("/add_teacher.jsp");
			req.setAttribute("status", "failed");
			req.setAttribute("name", e);
			req.setAttribute("id", "0");
			rd.include(req, resp);
		}
	}
	

}
