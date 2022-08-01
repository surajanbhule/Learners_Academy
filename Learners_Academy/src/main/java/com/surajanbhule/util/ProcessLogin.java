package com.surajanbhule.util;

import org.hibernate.Session;

public class ProcessLogin {
	private static Session session;
	private static Login login;

	static {
		if (session == null) {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			login = session.get(Login.class, 1);
			session.getTransaction().commit();
		}
	}
	
	public static String getUsername() {
		return login.getUsername();
	}
	
	public static String getPassword() {
		return login.getPassword();
	}
}
