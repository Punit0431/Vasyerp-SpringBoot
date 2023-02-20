package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.example.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long>{
	// List<Student> findBystream(String stream,Pageable pageable);
}
