package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showHomePage(){
        List<Customer> list = customerService.findAll();
        return new ModelAndView("home","list",list);
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("/save")
    public String createNewCustomer(Customer customer, Model model){
        customer.setId (customerService.findAll().size()+1);
        customerService.saveCustomer(customer);
        model.addAttribute("customer",new Customer());
        model.addAttribute("success","Created new customer successfully");
        return "create";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditPage(@PathVariable int id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("edit","customer",customer);
    }
}
