package com.example.jspdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jspdemo.model.Salary;
@Repository
public interface SalaryRepo extends JpaRepository<Salary, Long>{

}
