package com.surajanbhule.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.surajanbhule.models.Subject;
import com.surajanbhule.models.Teacher;
import com.surajanbhule.util.HibernateUtil;


public class DeleteTeacher extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int teacher_id= Integer.parseInt(req.getParameter("teacher_id"));
		String teacher_name=req.getParameter("teacher_name");
		
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Teacher teacher=session.get(Teacher.class, teacher_id);
			
			String sql="DELETE FROM teacher_subject WHERE teacher_id="+teacher_id;
			SQLQuery<?> query=session.createSQLQuery(sql);
			
			session.beginTransaction();
			query.executeUpdate();
			session.getTransaction().commit();
			
			session.beginTransaction();
			session.delete(teacher);
			session.getTransaction().commit();;
			
			RequestDispatcher rd = req.getRequestDispatcher("/teacher_list.jsp");
			req.setAttribute("status", "delete");
			req.setAttribute("id", teacher_id);
			req.setAttribute("name", teacher_name);
			rd.include(req, resp);
					
			}catch (Exception e) {
				RequestDispatcher rd = req.getRequestDispatcher("/teacher_list.jsp");
				req.setAttribute("status", "not-delete");
				req.setAttribute("id", teacher_id);
				req.setAttribute("name", e);
				rd.include(req, resp);
						
			}
	}
	

}
