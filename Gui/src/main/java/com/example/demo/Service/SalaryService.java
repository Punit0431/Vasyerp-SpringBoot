package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Salary;
import com.example.demo.Model.StudentVo;
import com.example.demo.Repository.SalaryRepo;

@Service
public class SalaryService {
	
	@Autowired
	private SalaryRepo salaryRepo;
	
	//Get All Student DEtails from Student Table..
		public List<Salary> getSalary(){
			List<Salary> studentVo = new ArrayList<>();
//			SalaryRepo.
		}

}
