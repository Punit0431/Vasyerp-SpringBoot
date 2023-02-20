package com.example.demo.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_Employee1")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long emp_id;
	
	@Column(name = "First_name")
	private String firstname;
	
	@Column(name = "Last_name")
	private String lastname;
	
	@Column(name = "Email")
	private String email;
	
	@OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_prod_fk",referencedColumnName = "emp_id")
	private List<Product> product;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sal_id", referencedColumnName = "sal_id")
    private Salary salary;
}
