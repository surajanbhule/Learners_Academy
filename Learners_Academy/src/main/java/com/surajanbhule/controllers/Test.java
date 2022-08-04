package com.surajanbhule.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		
		
		String sql="DELETE FROM teacher_subject WHERE teacher_id="+1;
		SQLQuery<?> query=session.createSQLQuery(sql);
		 System.out.println(" deleted");
		 session.beginTransaction();
		 int i=query.executeUpdate();
		 session.getTransaction().commit();
	    System.out.println(i+" deleted");
	   
	}

}
