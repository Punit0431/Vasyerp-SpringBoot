package com.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="tb_salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long salary_id;
	
	@Column(name = "salary")
	private long salary;
	
	@OneToOne(mappedBy = "salary")
	@JsonBackReference
	private StudentVo studentVo;

}
