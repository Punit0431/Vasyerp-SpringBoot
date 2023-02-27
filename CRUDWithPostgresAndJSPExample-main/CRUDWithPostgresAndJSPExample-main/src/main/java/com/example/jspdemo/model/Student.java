package com.example.jspdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.ManyToAny;


import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
@Table(name = "student")
public class Student {
	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getStud_name() {
		return stud_name;
	}

	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private long student_id;
	
	@JsonBackReference
	@Column(name = "student_name")
	private String stud_name;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "course",joinColumns = {@JoinColumn(name = "student_id",referencedColumnName="student_id")}, inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName="course_id")})
	List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
