package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Salary;

@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long>{

}
