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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tb_Project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long project_id;
	
	@Column(name = "Project_name")
	private String Project_name;
	
	@Column(name = "Definition")
	private String Project_def;
	
	@OneToMany (mappedBy="project",cascade=CascadeType.ALL)
	private List<Student> students;

}
