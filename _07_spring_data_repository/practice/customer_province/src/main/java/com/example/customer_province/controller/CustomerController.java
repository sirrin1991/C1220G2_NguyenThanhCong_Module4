package com.example.customer_province.controller;


import com.example.customer_province.entity.Customer;
import com.example.customer_province.entity.Province;
import com.example.customer_province.service.CustomerService;
import com.example.customer_province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    ProvinceService provinceService;

    @ModelAttribute("province")
    public List<Province> getProvince(){
        return provinceService.findAll();
    }

    @GetMapping
    public String showCustomerList(@PageableDefault(value = 3) Pageable pageable,
                                         @RequestParam Optional<String> name,
                                   Model model){
        String nameSearch ="";
        if(name.isPresent()){
            nameSearch = name.get();
            model.addAttribute("name",nameSearch);
            model.addAttribute("customers",customerService.findByFirstNameContaining(name.get(),pageable));
        }else {
            model.addAttribute("name",nameSearch);
            model.addAttribute("customers",customerService.findAll(pageable));
        }
        return "/customer/list";
    }

    @GetMapping("/add")
    public ModelAndView showCreateCustomerPage(){
        return new ModelAndView("/customer/create","customer",new Customer());
    }

    @PostMapping("/add-new-customer")
    public String createNewCustomer(Model model,Customer customer){
        customerService.saveCustomer(customer);
        model.addAttribute("success","Created new customer successfully");
        model.addAttribute("customer",new Customer());
        return "/customer/create";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditCustomerPage(@PathVariable int id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("/customer/edit","customer",customer);
    }

    @PostMapping("/edit-customer")
    public String editCustomer(Customer customer, RedirectAttributes ra){
        customerService.saveCustomer(customer);
        ra.addFlashAttribute("success","Updated customer successfully");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteCustomerPage(@PathVariable int id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("/customer/delete","customer",customer);
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(Customer customer,RedirectAttributes ra,@RequestParam String submit){
        if(submit.equals("Delete")){
            customerService.deleteCustomer(customer.getId());
            ra.addFlashAttribute("success","deleted customer successfully");
        }
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showViewCustomerPage(@PathVariable int id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("/customer/view","customer",customer);
    }


}
