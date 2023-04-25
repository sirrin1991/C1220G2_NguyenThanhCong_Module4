package com.example.demo.controller;

import com.example.demo.model.contract.Contract;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.service_of_furama.Service;
import com.example.demo.service.ContractService;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IServiceOfFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceOfFuramaService serviceOfFuramaService;

    @ModelAttribute
    public void setUpCustomerAndService(Model model, Pageable pageable) {
        model.addAttribute("services", serviceOfFuramaService.findAll());
        model.addAttribute("customers", customerService.getListCustomer(pageable).getContent());
    }

    @GetMapping
    public ModelAndView showContractList() {
        return new ModelAndView("/contract/list", "contracts", contractService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateContractPage() {
        return new ModelAndView("/contract/create", "contract", new Contract());
    }

    @PostMapping("/save")
    public String saveNewContract(Contract contract, Principal principal, Model model) {
        String email = principal.getName();
        Employee employee = employeeService.findEmployeeByEmail(email);
        contract.setEmployee(employee);
        contractService.save(contract);
        Service service = contract.getService();
        service.setStatus(false);
        serviceOfFuramaService.save(service);
        return "redirect:/contract";
    }
}
