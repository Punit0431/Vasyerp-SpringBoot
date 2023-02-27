package com.example.jspdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jspdemo.model.Anime;
import com.example.jspdemo.model.Student;
import com.example.jspdemo.repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepo studentRepo;
	
	public List<Student> getAllStudents() {
		List<Student> StudentList = new ArrayList<>();
		studentRepo.findAll().forEach(s -> StudentList.add(s));
		studentRepo.findAll();

		return StudentList;
	}
	public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }
	
	public boolean saveOrUpdateStudent(Student student) {
        Student updatedStudent = studentRepo.save(student);

        if (studentRepo.findById(updatedStudent.getStudent_id()) != null) {
            return true;
        }

        return false;
    }
	public boolean deleteStdent(Long id) {
        studentRepo.deleteById(id);

        if (studentRepo.findById(id) != null) {
            return true;
        }

        return false;
    }
}
