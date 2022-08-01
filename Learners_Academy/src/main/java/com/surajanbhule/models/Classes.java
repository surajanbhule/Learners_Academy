package com.surajanbhule.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Classes {
	
	private int class_id;
	private String class_name;
	private double class_time;
	private double class_duration;
	private Teacher teacher;
	private Subject subject;
	private Set<Student> student_list= new HashSet();
	
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

	public double getClass_time() {
		return class_time;
	}

	public void setClass_time(double class_time) {
		this.class_time = class_time;
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

	public Set<Student> getStudent_list() {
		return student_list;
	}

	public void setStudent_list(Set<Student> student_list) {
		this.student_list = student_list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(class_duration, class_id, class_name, class_time, student_list, subject, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classes other = (Classes) obj;
		return Double.doubleToLongBits(class_duration) == Double.doubleToLongBits(other.class_duration)
				&& class_id == other.class_id && Objects.equals(class_name, other.class_name)
				&& Double.doubleToLongBits(class_time) == Double.doubleToLongBits(other.class_time)
				&& Objects.equals(student_list, other.student_list) && Objects.equals(subject, other.subject)
				&& Objects.equals(teacher, other.teacher);
	}
	
	
	
}
