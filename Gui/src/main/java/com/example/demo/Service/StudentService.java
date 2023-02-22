package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.StudentVo;
import com.example.demo.Repository.StudentRepo;

import jakarta.persistence.Id;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepo studentRepo; 	
	
	//Get All Student DEtails from Student Table..
	public List<StudentVo> getStudents(){
		List<StudentVo> studentVo = new ArrayList<>();
		studentRepo.findAll().forEach(t -> studentVo.add(t));
		
		return studentVo;
	}
	
	//Get the single student data from the student table....
	public StudentVo getStudent(Long id) {
		return studentRepo.findById(id).get();
	}
	
	//Submit And Update the student data to the Student table....
	public boolean saveOrUpdate(StudentVo studentVo) {
		StudentVo updatestudent = studentRepo.save(studentVo);
		
		if(studentRepo.findById(updatestudent.getStudent_id()) != null) {
			return true;
		}
		return false;
	}
	
	public boolean DeleteStudent(long id) {
		studentRepo.deleteById(id);
		if(studentRepo.findById(id) != null) {
			return true;
		}
		return false;
	}

}
