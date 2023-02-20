package com.example.demo.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tb_Course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long course_id;
	
	@Column(name = "Course_name")
	private String course_name;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "Course")
	private Set<Student> students;

}
