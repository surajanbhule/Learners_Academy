package com.surajanbhule.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.surajanbhule.util.ProcessLogin;


public class AdminLogin extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		try {
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			
			String user=ProcessLogin.getUsername();
			String pass=ProcessLogin.getPassword();
			
			System.out.println("username: "+username);
			System.out.println("user: "+user);
			System.out.println("password: "+password);
			System.out.println("pass: "+pass);
			
			if(username.equals(user)&& password.equals(pass)) {
				RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
				rd.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
