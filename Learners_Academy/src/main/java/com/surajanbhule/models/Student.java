package com.surajanbhule.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
	
	private int student_id;
	private String student_first_name;
	private String student_last_name;
	private String student_email;
	private String student_phone;
	private String student_address;
	private Set<Classes> classes_list= new HashSet();
	
	
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

	public Set<Classes> getClasses_list() {
		return classes_list;
	}

	public void setClasses_list(Set<Classes> classes_list) {
		this.classes_list = classes_list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classes_list, student_address, student_email, student_first_name, student_id,
				student_last_name, student_phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(classes_list, other.classes_list)
				&& Objects.equals(student_address, other.student_address)
				&& Objects.equals(student_email, other.student_email)
				&& Objects.equals(student_first_name, other.student_first_name) && student_id == other.student_id
				&& Objects.equals(student_last_name, other.student_last_name)
				&& Objects.equals(student_phone, other.student_phone);
	}
	
	
	
}
