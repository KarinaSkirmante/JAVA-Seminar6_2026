package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IStudentCRUDService;

@Controller
@RequestMapping("/student/crud")
public class StudentCRUDController {
	
	
	@Autowired
	private IStudentCRUDService studCrudService;
	
	@GetMapping("/all")//localhost:8080/student/crud/all
	public String getAllStudents(Model model) {
		
		try
		{
			model.addAttribute("package", studCrudService.retrieveAll());
			return "show-all-students-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteStudentById(@PathVariable(name = "id") long id, Model model) {
		try
		{
			studCrudService.deleteById(id);
			model.addAttribute("package", studCrudService.retrieveAll());
			return "show-all-students-page";//tiks paradita show-all-students-page.html lapa
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
	}
	
	//TODO parejie CRUD kontrolieri

}
