package com.surajanbhule.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;


import com.surajanbhule.models.Classes;
import com.surajanbhule.models.Student;
import com.surajanbhule.models.Subject;
import com.surajanbhule.models.Teacher;
import com.surajanbhule.util.HibernateUtil;
import com.surajanbhule.util.Login;

public class Test extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Subject s=new Subject();
		s.setSubject_name("Java");
		
		Teacher t = new Teacher();
		t.setTeacher_first_name("Teacher Name");
	    Classes class1=new Classes();
	    class1.setClass_name("Demo");
	    class1.setClass_duration(150);
	    class1.setSubject(s);
	    class1.setTeacher(t);
	    
	    session.beginTransaction();
	    session.save(class1);
	    session.getTransaction().commit();

	}

}
