package com.surajanbhule.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.surajanbhule.models.Classes;
import com.surajanbhule.models.Subject;
import com.surajanbhule.models.Teacher;
import com.surajanbhule.util.HibernateUtil;


public class CreateClass extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		int subject_id=Integer.parseInt(req.getParameter("selected_subject"));
		int teacher_id=Integer.parseInt(req.getParameter("selected_teacher"));
		
		String class_name=req.getParameter("class_name");
		double call_duration=Double.parseDouble(req.getParameter("class_duration"));
		
		Subject subject = session.get(Subject.class, subject_id);
		
		Teacher teacher = session.get(Teacher.class, teacher_id);
		
		Classes class1= new Classes();
		class1.setClass_duration(call_duration);
		class1.setClass_name(class_name);
		class1.setSubject(subject);
		class1.setTeacher(teacher);
		
		session.beginTransaction();
		Serializable serializable=session.save(class1);
		int id=(int)serializable;
		session.getTransaction().commit();
		RequestDispatcher rd = req.getRequestDispatcher("/create_class.jsp");
		req.setAttribute("status", "success");
		req.setAttribute("id", id);
		req.setAttribute("name", class_name);
		rd.include(req, resp);
	   
	}
	

}
