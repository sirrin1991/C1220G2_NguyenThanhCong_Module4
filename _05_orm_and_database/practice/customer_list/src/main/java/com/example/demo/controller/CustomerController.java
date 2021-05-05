package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

    @PostMapping("/edit")
    public String editCustomer(Customer customer, RedirectAttributes ra){
        customerService.saveCustomer(customer);
        ra.addFlashAttribute("success","updated customer successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeletePage(@PathVariable int id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("delete","customer",customer);
    }

    @PostMapping("/delete")
    public String deleteCustomer(Customer customer, @RequestParam String submit,RedirectAttributes ra){
        if(submit.equals("Delete")){
            customerService.deleteCustomer(customer.getId());
            ra.addFlashAttribute("success","Deleted customer successfully");
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public ModelAndView viewCustomer(@PathVariable int id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("view","customer",customer);
    }
}
