package com.surajanbhule.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession= req.getSession();
		httpSession.setAttribute("uname", "");
		httpSession.setAttribute("pass", "");
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		req.setAttribute("status", "logout");
		rd.include(req, resp);
	}
	

}
