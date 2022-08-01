package com.surajanbhule.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacher_id;
	
	private String teacher_first_name;
	private String teacher_last_name;
	private String teacher_email;
	private String teacher_phone;
	private String teacher_address;
	@OneToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	public Teacher() {}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_first_name() {
		return teacher_first_name;
	}

	public void setTeacher_first_name(String teacher_first_name) {
		this.teacher_first_name = teacher_first_name;
	}

	public String getTeacher_last_name() {
		return teacher_last_name;
	}

	public void setTeacher_last_name(String teacher_last_name) {
		this.teacher_last_name = teacher_last_name;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_eamil) {
		this.teacher_email = teacher_eamil;
	}

	public String getTeacher_phone() {
		return teacher_phone;
	}

	public void setTeacher_phone(String teacher_phone) {
		this.teacher_phone = teacher_phone;
	}

	public String getTeacher_address() {
		return teacher_address;
	}

	public void setTeacher_address(String teacher_address) {
		this.teacher_address = teacher_address;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
}
