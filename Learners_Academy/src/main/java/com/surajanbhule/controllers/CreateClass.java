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
		String sub_id = req.getParameter("selected_subject");
		System.out.println(sub_id);
		String teach_id = req.getParameter("selected_teacher");
		System.out.println(teach_id);

		String class_name = req.getParameter("class_name");
		String class_durat = req.getParameter("class_duration");
		
		if (sub_id.equals("Select Subject")) {
			RequestDispatcher rd = req.getRequestDispatcher("/create_class.jsp");
			req.setAttribute("status", "empty-subject");
			req.setAttribute("name", "");
			req.setAttribute("id", "0");
			rd.include(req, resp);
		}

		if (teach_id.equals("Select Teacher")) {
			RequestDispatcher rd = req.getRequestDispatcher("/create_class.jsp");
			req.setAttribute("status", "empty-teacher");
			req.setAttribute("name", "");
			req.setAttribute("id", "0");
			rd.include(req, resp);
		}


		if (class_name.isEmpty() || class_durat.isEmpty()||teach_id.equals("Select Teacher")||sub_id.equals("Select Subject")) {
			RequestDispatcher rd = req.getRequestDispatcher("/create_class.jsp");
			req.setAttribute("status", "empty");
			req.setAttribute("name", "");
			req.setAttribute("id", "0");
			rd.include(req, resp);
		}

		
		double call_duration = Double.parseDouble(class_durat);
		int teacher_id = Integer.parseInt(teach_id);
		int subject_id = Integer.parseInt(sub_id);
		Subject subject = session.get(Subject.class, subject_id);

		Teacher teacher = session.get(Teacher.class, teacher_id);

		Classes class1 = new Classes();
		class1.setClass_duration(call_duration);
		class1.setClass_name(class_name);
		class1.setSubject(subject);
		class1.setTeacher(teacher);
		try {
			session.beginTransaction();
			Serializable serializable = session.save(class1);
			int id = (int) serializable;
			session.getTransaction().commit();
			RequestDispatcher rd = req.getRequestDispatcher("/create_class.jsp");
			req.setAttribute("status", "success");
			req.setAttribute("id", id);
			req.setAttribute("name", class_name);
			rd.include(req, resp);
		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("/create_class.jsp");
			req.setAttribute("status", "failed");
			req.setAttribute("name", e);
			req.setAttribute("id", "0");
			rd.include(req, resp);
		}

	}

}
