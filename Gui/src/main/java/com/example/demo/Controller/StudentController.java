package com.example.demo.Controller;

import java.lang.ProcessBuilder.Redirect;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.aspectj.weaver.ast.Var;
import org.hibernate.dialect.MyISAMStorageEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.StudentVo;
import com.example.demo.Repository.StudentRepo;
import com.example.demo.Service.StudentService;


import lombok.experimental.var;



@Controller
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	


	@GetMapping("/ViewStudent")
	public ModelAndView ViewStudent(@ModelAttribute("message") String message,org.springframework.ui.Model model) {
		ModelAndView view =new ModelAndView("ViewStudent");
		view.addObject("studentVo",studentService.getStudents());
		view.addObject("message",message);
		return view;
	}
	
	@GetMapping("/AddStudent")
	public String AddStudent(ModelMap modelMap,@ModelAttribute("message") String msg) {
		modelMap.addAttribute("Addstudent",new StudentVo());
		modelMap.addAttribute("message",msg);
		return "AddStudent";
	}
	@PostMapping("/SaveStudent")
	public String saveStudent(StudentVo studentVo,RedirectAttributes redirectAttributes) {
		if (studentService.saveOrUpdate(studentVo)) {
			redirectAttributes.addFlashAttribute("message","Data Saved");
			return "redirect:/ViewStudent";
		}
		else {
			redirectAttributes.addFlashAttribute("messeage","Data not Saved");
			return "redirect:/AddStudent";
		}
	}
	
	//Edit the single Student data 
	@GetMapping("/EditStudent/{id}")
	public String EditStudent(@PathVariable long id,ModelMap modelMap) {
		modelMap.addAttribute("student",studentService.getStudent(id));
		return "EditStudent";
	}
	
	@PostMapping("/EditSaveStudent")
	public String EditSaveStudent(StudentVo studentVo,RedirectAttributes redirectAttributes) {
		if (studentService.saveOrUpdate(studentVo)) {
			redirectAttributes.addFlashAttribute("message","Student Updated");
			return "redirect:/ViewStudent";
		}
		else {
			redirectAttributes.addFlashAttribute("message","Student not Updated");
			return "redirect:/EditStudent"+studentVo.getStudent_id();
		}
	}
	
	@GetMapping("/DeleteStudent/{id}")
	public String DeleteStudent(@PathVariable Long id,RedirectAttributes redirectAttributes) {
		if (studentService.DeleteStudent(id)) {
			redirectAttributes.addFlashAttribute("message","Student Deleted");
		}
		
		redirectAttributes.addFlashAttribute("message","Student not Deleted");
		return "redirect:/ViewStudent";
		
	}

	
}
