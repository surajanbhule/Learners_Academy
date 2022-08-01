package com.surajanbhule.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.surajanbhule.models.Teacher;
import com.surajanbhule.util.HibernateUtil;


public class Test extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session= HibernateUtil.getSessionFactory().openSession();
		
		Teacher t1 = new Teacher();
		t1.setTeacher_first_name("Ram");
		t1.setTeacher_last_name("Singh");
		t1.setTeacher_phone("123456");
		t1.setTeacher_address("abc street pune");
		t1.setTeacher_email("ram@teacher.com");
		
	}
	
	

}
