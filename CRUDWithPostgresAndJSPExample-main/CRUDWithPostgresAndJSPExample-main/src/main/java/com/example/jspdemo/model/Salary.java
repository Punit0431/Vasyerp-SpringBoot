package com.example.jspdemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;





@Entity
@Table(name="Tb_salary")
public class Salary {
	
	public long getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(long salary_id) {
		this.salary_id = salary_id;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long salary_id;
	
	@Column(name = "salary")
	private long salary;
	
	@OneToOne(mappedBy = "salary")
	@JsonBackReference
	private Anime anime;
	
	@OneToMany(mappedBy="salary",cascade=CascadeType.ALL)
	private List<Anime> animes;

}
