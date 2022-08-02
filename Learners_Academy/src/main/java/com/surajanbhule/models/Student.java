package com.surajanbhule.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;
	private String student_first_name;
	private String student_last_name;
	private String student_email;
	private String student_phone;
	private String student_address;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="classes_student",joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name="class_id"))
	private List<Classes> classes_list= new ArrayList<Classes>();
	
	
	public Student() {}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_first_name() {
		return student_first_name;
	}

	public void setStudent_first_name(String student_first_name) {
		this.student_first_name = student_first_name;
	}

	public String getStudent_last_name() {
		return student_last_name;
	}

	public void setStudent_last_name(String student_last_name) {
		this.student_last_name = student_last_name;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getStudent_phone() {
		return student_phone;
	}

	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public List<Classes> getClasses_list() {
		return classes_list;
	}

	public void setClasses_list(List<Classes> classes_list) {
		this.classes_list = classes_list;
	}


	
}
