package com.example.jspdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.jspdemo.model.Salary;
import com.example.jspdemo.service.SalaryService;

@Controller
public class SalaryController {
	
	@Autowired
	SalaryService salaryService;
	
	@GetMapping({ "/", "/viewsalaryList" })
	public String viewsalaryList(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("salaryList", salaryService.getAllsalary());
		model.addAttribute("message", message);

		return "ViewsalaryList";
	}

	@GetMapping("/addsalary")
	public String addsalary(@ModelAttribute("message") String message, Model model) {
		model.addAttribute("salary", new Salary());
		model.addAttribute("message", message);

		return "Addsalary";
	}
	
	@PostMapping("/savesalary")
    public String savesalary(Salary salary, RedirectAttributes redirectAttributes) {
        if (salaryService.saveOrUpdatesalary(salary)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewsalaryList";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/Addsalary";
    }

	@GetMapping("/editsalary/{id}")
	public String editsalary(@PathVariable Long id, Model model) {
		model.addAttribute("salary", salaryService.getsalaryById(id));

		return "Editsalary";
	}

	@PostMapping("/editSavesalary")
	public String editSavesalary(Salary salary, RedirectAttributes redirectAttributes) {
		if (salaryService.saveOrUpdatesalary(salary)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/viewsalaryList";
		}

		redirectAttributes.addFlashAttribute("message", "Edit Failure");
		return "redirect:/editsalary/" + salary.getSalary_id();
	}
	

    @GetMapping("/deletesalary/{id}")
    public String deletesalary(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (salaryService.deletesalary(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewsalaryList";
    }


}
