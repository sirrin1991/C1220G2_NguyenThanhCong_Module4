package controllers;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @GetMapping
    public String showPage(Model model){
        model.addAttribute("employee",new Employee());
        return "create";
    }

    @PostMapping("/addEmployee")
    public ModelAndView create(@ModelAttribute("employee") Employee employee){
        return new ModelAndView("employee_info","employee",employee);
    }
}
