package com.example.jspdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jspdemo.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

}
