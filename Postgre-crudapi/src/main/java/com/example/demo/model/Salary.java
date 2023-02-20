package com.example.demo.model;




import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Salary")

public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sal_id;
	
	@Column(name = "salary")
	private long salary;
	
	
	@OneToOne(mappedBy = "salary")
	@JsonBackReference
	private Employee employee;
	
}

