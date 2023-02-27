package com.example.jspdemo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jspdemo.model.Anime;
import com.example.jspdemo.model.Course;
import com.example.jspdemo.repo.CourseRepo;


@Service
public class CourseService {
	
	@Autowired
	public CourseRepo courseRepo;

	public List<Course> getAllcourse() {
		List<Course> CourseList = new ArrayList<>();
		courseRepo.findAll().forEach(c -> CourseList.add(c));

		return CourseList;
	}
	
	public Course getcourseById(Long id) {
        return courseRepo.findById(id).get();
    }
	
	 public boolean saveOrUpdatecourse(Course course) {
	        Course updatedcourse = courseRepo.save(course);

	        if (courseRepo.findById(updatedcourse.getCourse_id()) != null) {
	            return true;
	        }

	        return false;
	    }
	public boolean deletecourse(Long id) {
        courseRepo.deleteById(id);

        if (courseRepo.findById(id) != null) {
            return true;
        }

        return false;
    }
}
