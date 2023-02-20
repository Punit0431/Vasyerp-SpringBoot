package com.example.demo.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tb_Student")
public class Student{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long student_id;
	
	@Column(name = "student_name")
	private String student_name;
	
	@Column(name = "Stream")
	private String stream;
	
	@Column(name = "Contact_no")
	private String mob;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id",referencedColumnName = "project_id")
	private Project project;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "Course",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> Course;
	
	
}
