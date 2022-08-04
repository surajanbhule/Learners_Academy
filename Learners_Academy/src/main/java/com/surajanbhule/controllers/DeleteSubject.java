package com.surajanbhule.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.surajanbhule.models.Subject;
import com.surajanbhule.util.HibernateUtil;



public class DeleteSubject extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int subject_id= Integer.parseInt(req.getParameter("subject_id"));
		String subject_name=req.getParameter("subject_name");
		
		try {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Subject subject=session.get(Subject.class, subject_id);
				
		session.beginTransaction();
		session.delete(subject);
		session.getTransaction().commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("/subject_list.jsp");
		req.setAttribute("status", "delete");
		req.setAttribute("id", subject_id);
		req.setAttribute("name", subject_name);
		rd.include(req, resp);
				
		}catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("/subject_list.jsp");
			req.setAttribute("status", "not-delete");
			req.setAttribute("id", subject_id);
			req.setAttribute("name", subject_name);
			rd.include(req, resp);
					
		}
	}
	

}
