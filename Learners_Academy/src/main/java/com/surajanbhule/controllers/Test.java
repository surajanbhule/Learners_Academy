package com.surajanbhule.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.surajanbhule.models.Classes;
import com.surajanbhule.models.Student;
import com.surajanbhule.models.Subject;
import com.surajanbhule.models.Teacher;
import com.surajanbhule.util.HibernateUtil;

public class Test extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Teacher t1 = new Teacher();
		t1.setTeacher_first_name("Ram");
		t1.setTeacher_last_name("Singh");
		t1.setTeacher_phone("123456");
		t1.setTeacher_address("abc street pune");
		t1.setTeacher_email("ram@teacher.com");

		Teacher t2 = new Teacher();
		t2.setTeacher_first_name("Shyam");
		t2.setTeacher_last_name("Singh");
		t2.setTeacher_phone("345678");
		t2.setTeacher_address("xyz street mumbai");
		t2.setTeacher_email("shyam@teacher.com");

		Teacher t3 = new Teacher();
		t3.setTeacher_first_name("Om");
		t3.setTeacher_last_name("Singh");
		t3.setTeacher_phone("678954");
		t3.setTeacher_address("jkl street kanpur");
		t3.setTeacher_email("om@teacher.com");

		Subject s1 = new Subject();
		s1.setSubject_name("Java");
		s1.setNo_of_topics(20);

		Subject s2 = new Subject();
		s2.setSubject_name("Python");
		s2.setNo_of_topics(20);

		Subject s3 = new Subject();
		s3.setSubject_name("Javascript");
		s3.setNo_of_topics(20);

		s1.getTeacher_list().add(t1);
		s1.getTeacher_list().add(t2);

		s2.getTeacher_list().add(t2);
		s2.getTeacher_list().add(t3);

		s3.getTeacher_list().add(t1);
		s3.getTeacher_list().add(t3);

		t1.getSubject_list().add(s1);
		t1.getSubject_list().add(s2);

		t2.getSubject_list().add(s2);
		t2.getSubject_list().add(s3);

		t3.getSubject_list().add(s1);
		t3.getSubject_list().add(s3);
		
		Student stud1=new Student();
		stud1.setStudent_first_name("Suraj");
		stud1.setStudent_last_name("Anbhule");
		stud1.setStudent_email("suraj@gmail.com");
		stud1.setStudent_phone("9689462739");
		stud1.setStudent_address("Parite Madha Solapur");
		
		Student stud2=new Student();
		stud2.setStudent_first_name("Sujata");
		stud2.setStudent_last_name("Bhosale");
		stud2.setStudent_email("sujata@gmail.com");
		stud2.setStudent_phone("7559485422");
		stud2.setStudent_address("Ropale Pandharpur Solapur");
		
		Student stud3=new Student();
		stud3.setStudent_first_name("Shalini");
		stud3.setStudent_last_name("Sah");
		stud3.setStudent_email("shalini@gmail.com");
		stud3.setStudent_phone("9323498263");
		stud3.setStudent_address("Tembhurni Tembhurni Solapur");
		
		Classes class1= new Classes();
		class1.setClass_name("Java Super");
		class1.setClass_duration(150);
		class1.setClass_time(11.00);
		class1.setSubject(s1);
		class1.setTeacher(t1);
		
		Classes class2= new Classes();
		class2.setClass_name("Python Super");
		class2.setClass_duration(150);
		class2.setClass_time(1.00);
		class2.setSubject(s2);
		class2.setTeacher(t2);
		
		Classes class3= new Classes();
		class3.setClass_name("Javascript Super");
		class3.setClass_duration(150);
		class3.setClass_time(3.00);
		class3.setSubject(s3);
		class3.setTeacher(t3);
		
		class1.getStudent_list().add(stud1);
		class1.getStudent_list().add(stud2);
		class1.getStudent_list().add(stud3);
		
		class2.getStudent_list().add(stud1);
		class2.getStudent_list().add(stud2);
		class2.getStudent_list().add(stud3);
		
		class3.getStudent_list().add(stud1);
		class3.getStudent_list().add(stud2);
		class3.getStudent_list().add(stud3);
		
		stud1.getClasses_list().add(class1);
		stud1.getClasses_list().add(class2);
		stud1.getClasses_list().add(class3);
		
		stud2.getClasses_list().add(class1);
		stud2.getClasses_list().add(class2);
		stud2.getClasses_list().add(class3);
		
		stud3.getClasses_list().add(class1);
		stud3.getClasses_list().add(class2);
		stud3.getClasses_list().add(class3);

		session.beginTransaction();
		session.save(class1);
		session.save(class2);
		session.save(class3);
		session.getTransaction().commit();

	}

}
