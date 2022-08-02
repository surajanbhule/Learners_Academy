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
import javax.persistence.OneToOne;

@Entity
public class Classes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int class_id;
	private String class_name;
	private double class_duration;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_id")
	private Teacher teacher;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="subject_id")
	private Subject subject;
	@ManyToMany(mappedBy = "classes_list")
	private List<Student> student_list= new ArrayList<Student>();
	
	public Classes() {}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	

	public double getClass_duration() {
		return class_duration;
	}

	public void setClass_duration(double class_duration) {
		this.class_duration = class_duration;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Student> getStudent_list() {
		return student_list;
	}

	public void setStudent_list(List<Student> student_list) {
		this.student_list = student_list;
	}


	
	
}
