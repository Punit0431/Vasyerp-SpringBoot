package com.example.jspdemo.model;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long course_id;
	
	@Column(name = "Course_name")
	private String courseName;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	private Set<Student> students;
	
	@ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
	Set<Student> students;

}
