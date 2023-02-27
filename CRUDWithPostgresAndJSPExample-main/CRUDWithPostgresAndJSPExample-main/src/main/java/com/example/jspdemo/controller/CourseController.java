package com.example.jspdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jspdemo.model.Anime;
import com.example.jspdemo.model.Course;
import com.example.jspdemo.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	public CourseService courseService;
	
	@GetMapping(value = {"/", "/viewCourseList"})
    public String viewCourseList(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("CourseList", courseService.getAllcourse());
        model.addAttribute("message", message);

        return "ViewCourseList";
    }
	
	@GetMapping("/addCourse")
    public String addCourse(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("message", message);

        return "AddCourse";
    }
	
	@PostMapping("/saveCourse")
	public String saveCourse(Course course, RedirectAttributes redirectAttributes) {
		if (courseService.saveOrUpdatecourse(course)) {

			redirectAttributes.addFlashAttribute("message", "Save Success");
			return "redirect:/viewCourseList";
		}

		redirectAttributes.addFlashAttribute("message", "Save Failure");
		return "redirect:/addCourse";
	}

	@GetMapping("/editCourse/{id}")
	public String editCourse(@PathVariable Long id, Model model) {
		model.addAttribute("course", courseService.getcourseById(id));

		return "EditCourse";
	}

	@PostMapping("/editSaveCourse")
	public String editSaveCourse(Course course, RedirectAttributes redirectAttributes) {
		if (courseService.saveOrUpdatecourse(course)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/viewCourseList";
		}

		redirectAttributes.addFlashAttribute("message", "Edit Failure");
		return "redirect:/editCourse/" +course.getCourse_id();
	}
	
	@GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (courseService.deletecourse(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewCourseList";
    }

}
