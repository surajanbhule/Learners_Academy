package com.surajanbhule.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subject_id;
	@Column(name="subject_name")
	private String subject_name;
	@Column(name="number_of_topics")
	private int no_of_topics;
	

	
	
	public Subject() {}


	public int getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}


	public String getSubject_name() {
		return subject_name;
	}


	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}


	public int getNo_of_topics() {
		return no_of_topics;
	}


	public void setNo_of_topics(int no_of_topics) {
		this.no_of_topics = no_of_topics;
	}





	
	
}
