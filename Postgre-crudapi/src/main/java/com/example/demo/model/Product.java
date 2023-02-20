package com.example.demo.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tbl_Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	
	@Column(name = "Name")
	private String product_name;
	
	@Column(name = "Price")
	private String  price;
	
	@Column(name = "Quantity")
	private String qty;
	
}