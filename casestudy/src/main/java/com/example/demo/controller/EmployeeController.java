package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.model.employee.*;
import com.example.demo.service.impl.*;
import com.example.demo.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EducationDegreeServiceImpl educationDegreeService;
    @Autowired
    private PositionServiceImpl positionService;
    @Autowired
    private DivisionServiceImpl divisionService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private EmployeeValidation employeeValidation;

    @ModelAttribute("divisions")
    public List<Division> getAllDivision() {
        return divisionService.findAll();
    }

    @ModelAttribute("positions")
    public List<Position> getAllPosition() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public List<EducationDegree> getAllEducationDegree() {
        return educationDegreeService.findAll();
    }

    @GetMapping
    public ModelAndView showEmployeeListPage(Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        return new ModelAndView("/employee/employee-list", "employees", employees);
    }

    @GetMapping("/create")
    public ModelAndView showCreateEmployeePage() {
        return new ModelAndView("/employee/create", "employee", new Employee());
    }

    @PostMapping("/save")
    public String saveNewEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                  BindingResult bindingResult,
                                  Model model) {
        employeeValidation.validate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/employee/create";
        }
        User user = new User();
        user.setEmail(employee.getEmail());
        user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils(employee.getIdCard()));
        Role roleEntity = roleService.findByName("ROLE_MEMBER");
        Role roleEntity2 = roleService.findByName("ROLE_ADMIN");
        Set<Role> roleSet = new HashSet<>();
        if (employee.getPosition().getId() == 1 || employee.getPosition().getId() == 2) {
            roleSet.add(roleEntity2);
        }
        roleSet.add(roleEntity);
        user.setRoles(roleSet);
        employee.setUser(user);
        employeeService.save(employee);
        model.addAttribute("msg", "Successfully");
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditEmployeePage(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        return new ModelAndView("/employee/edit", "employee", employee);
    }

    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        employeeValidation.validate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/employee/edit";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Successfully");
        return "redirect:/employee";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        return new ModelAndView("/employee/view", "employee", employee);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteEmployeePage(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        return new ModelAndView("/employee/delete", "employee", employee);
    }

    @PostMapping("/delete")
    public String deleteCustomer(Employee employee, @RequestParam String submit, RedirectAttributes redirectAttributes) {
        if (submit.equals("Delete")) {
            redirectAttributes.addFlashAttribute("msg", "successfully");
            employeeService.delete(employee.getId());
        }
        return "redirect:/employee";
    }

}
