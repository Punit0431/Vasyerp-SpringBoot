package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.example.demo.model.Salary;


public interface SalaryRepo extends JpaRepository<Salary,Long>{
	
}
