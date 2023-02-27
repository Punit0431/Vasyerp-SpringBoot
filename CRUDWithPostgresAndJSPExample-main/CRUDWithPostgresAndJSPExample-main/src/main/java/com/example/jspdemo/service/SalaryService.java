package com.example.jspdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jspdemo.model.Anime;
import com.example.jspdemo.model.Salary;
import com.example.jspdemo.repo.SalaryRepo;

@Service
public class SalaryService {

	@Autowired
	SalaryRepo salaryRepo;
	
	public List<Salary> getAllsalary() {
		List<Salary> salaryList = new ArrayList<>();
		salaryRepo.findAll().forEach(salary -> salaryList.add(salary));
		return salaryList;
	}
	public Salary getsalaryById(Long id) {
        return salaryRepo.findById(id).get();
    }
	public boolean saveOrUpdatesalary(Salary salary) {
        Salary updatedsalary = salaryRepo.save(salary);

        if (salaryRepo.findById(updatedsalary.getSalary_id()) != null) {
            return true;
        }

        return false;
    }
	 public boolean deletesalary(Long id) {
	        salaryRepo.deleteById(id);

	        if (salaryRepo.findById(id) != null) {
	            return true;
	        }

	        return false;
	    }

	
}
