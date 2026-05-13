package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Professor;
import lv.venta.model.enums.Degree;
import lv.venta.service.IFilterService;

@Controller
@RequestMapping("/filter")
public class FilterController {
	
	@Autowired
	private IFilterService filterService;
	
	@GetMapping("/professor/degree/{inputdegree}")//localhost:8080/filter/professor/degree/phd
	public String getProfessorsByDegree(@PathVariable(name = "inputdegree") Degree inputdegree, Model model) {
		try
		{
			ArrayList<Professor> professorsFromDB = filterService.filterProfessorsByDegree(inputdegree);
			model.addAttribute("package", professorsFromDB);
			return "show-multiple-professors-page";
		}
		catch (Exception e) {
			model.addAttribute("package", e.getMessage());
			return "error-page";
		}
		
	}

}
