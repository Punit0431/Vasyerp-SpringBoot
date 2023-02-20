package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	
	//Get all the Employee list from Repository...
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		employeeRepo.findAll().forEach(E->employees.add(E));
		return employees;
	}
	
	//Get Employee By Id ..
	public Employee getEmpById(Long id) {
		return employeeRepo.findById(id).get();
	}
	
	//save and update the employee details..
	public boolean saveorUpdate() {
		Employee employee2 = employeeRepo
	}
}
