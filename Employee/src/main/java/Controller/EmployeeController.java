package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Repository.EmpRepo;

@RestController
@RequestMapping("/Emp")
public class EmployeeController {

	@Autowired
	private EmpRepo empRepo;
	
	@PostMapping("/SaveEmployees")
}
