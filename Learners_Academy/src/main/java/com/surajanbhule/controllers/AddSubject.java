package com.surajanbhule.controllers;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.surajanbhule.models.Subject;
import com.surajanbhule.util.HibernateUtil;

public class AddSubject extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subject_name=req.getParameter("subject_name");
		String topics=req.getParameter("no_of_topics");
		if(subject_name.isEmpty()||topics.isEmpty()) {
			RequestDispatcher rd =req.getRequestDispatcher("/add_subject.jsp");
			req.setAttribute("status", "empty");
			req.setAttribute("name", "");
			req.setAttribute("id", "0");
			rd.include(req, resp);
		}
		Session session=HibernateUtil.getSessionFactory().openSession();
		int no_of_topics= Integer.parseInt(topics);
		Subject subject = new Subject();
		subject.setNo_of_topics(no_of_topics);
		subject.setSubject_name(subject_name);
		try {
		session.beginTransaction();
		Serializable serializable=session.save(subject);
		session.getTransaction().commit();
		
		RequestDispatcher rd =req.getRequestDispatcher("/add_subject.jsp");
		int id=(int)serializable;
		req.setAttribute("id", id);
		req.setAttribute("name", subject_name);
		req.setAttribute("status", "success");
		rd.include(req, resp);
		}catch (Exception e) {
			RequestDispatcher rd =req.getRequestDispatcher("/add_subject.jsp");
			req.setAttribute("status", "failed");
			req.setAttribute("name", e);
			req.setAttribute("id", "0");
			rd.include(req, resp);
		}
		
	}
	

}
