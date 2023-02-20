package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Course;
import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.model.Salary;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.repository.SalaryRepo;
import com.example.demo.repository.StudentRepo;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	 @Autowired
	private StudentRepo studentRepo;
	
	 @Autowired
	private SalaryRepo salaryRepo;
	 
	 @Autowired
	 private ProjectRepo projectRepo;
	 
	 @Autowired
	 private CourseRepo courseRepo;
	
	
	@GetMapping("/employee")
	public List<Employee> getEmployees(){

		return this.employeeRepo.findAll();
	}
	
	@GetMapping("/Course")
	public List<Course> getCourses(){

		return this.courseRepo.findAll();
	}
	
	
	//get Student detail..
	@GetMapping("/students")
	public List<Student> getStudents(){
		return this.studentRepo.findAll();
	}

	// get project detail..
	@GetMapping("/Projects")
	public List<Project> getProject() {
		return this.projectRepo.findAll();
	}
		
	//get Salary detail..
	@GetMapping("/Salary")
	public List<Salary> getSalary(){
		return this.salaryRepo.findAll();
	}
	
	//Get the Employee by id
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeByID(@PathVariable (value = "id") long empId) throws ResourceNotFoundException
	{
		Employee emp = employeeRepo.findById(empId).orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id : "+empId));
		return ResponseEntity.ok().body(emp);
	}
	
	//Save the Employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return this.employeeRepo.save(employee);
	}
	//Update the Employee
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable (value = "id") long empId,@Valid @RequestBody Employee employee) throws ResourceNotFoundException{
		Employee emp = employeeRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee not found for this id : "+empId));
		emp.setEmail(employee.getEmail());	
		emp.setFirstname(employee.getFirstname());
		emp.setLastname(employee.getLastname());
		emp.setSalary(employee.getSalary());
		
		return ResponseEntity.ok(this.employeeRepo.save(emp));
	}
	//Delete the Employee
	@DeleteMapping("/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable (value = "id") long empId) throws ResourceNotFoundException
	{
		Employee emp = employeeRepo.findById(empId).orElseThrow(()->new ResourceNotFoundException("Employee not found for this id : "+empId));
		this.employeeRepo.delete(emp);
		Map<String, Boolean> responseMap = new HashMap<>();
		responseMap.put("deleted", Boolean.TRUE);
		return responseMap;
	}
}
