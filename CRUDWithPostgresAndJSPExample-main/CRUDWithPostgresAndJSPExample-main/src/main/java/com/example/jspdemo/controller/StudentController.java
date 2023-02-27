package com.example.jspdemo.controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jspdemo.model.Student;
import com.example.jspdemo.service.CourseService;
import com.example.jspdemo.service.StudentService;

@Controller
public class StudentController {
	
	
	@Autowired
	public StudentService studentService;
	
	@Autowired
	public CourseService courseService;
	
	@GetMapping(value = { "/", "/viewStudentList" })
	public String viewStudentList(@ModelAttribute("message") String message, Model model) {
	
		model.addAttribute("StudentList", studentService.getAllStudents());
//		model.addAttribute("courseList", courseService.getAllcourse());
		model.addAttribute("message", message);

		return "ViewStudentList";
	}
	
	@GetMapping("/addStudent")
    public String addStudent(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("Student", new Student());
        model.addAttribute("message", message);
        model.addAttribute("courseList", courseService.getAllcourse());

        return "AddStudent";
    }
	
	@PostMapping("/saveStudent")
    public String saveStudent(Student student, RedirectAttributes redirectAttributes) {
		if (studentService.saveOrUpdateStudent(student)) {
			System.out.print(courseService.getAllcourse());
        	redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewStudentList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addStudent";
    }

	@GetMapping("/editStudent/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("Student", studentService.getStudentById(id));

		return "EditStudent";
	}
	
	@PostMapping("/editSaveStudent")
	public String editSaveStudent(Student student, RedirectAttributes redirectAttributes) {
		if (studentService.saveOrUpdateStudent(student)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/viewStudentList";
		}

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editStudent/" + student.getStudent_id();
    }
	
	@GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (studentService.deleteStdent(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
            
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewStudentList";
    }

}
