package com.example.demo.controller;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> getCustomerTypeList() {
        return customerTypeService.findAll();
    }

    @GetMapping
    public ModelAndView showCustomerList(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("/customer/customer-list", "customers",
                customerService.getListCustomer(pageable));
    }

    @GetMapping("/create")
    public ModelAndView showCreateCustomerPage() {
        return new ModelAndView("/customer/create", "customer", new Customer());
    }

    @PostMapping("/save")
    public String addNewCustomer(Customer customer, Model model) {
        model.addAttribute("msg", "successfully");
        model.addAttribute("customer", new Customer());
        customerService.save(customer);
        return "/customer/create";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditPage(@PathVariable Integer id) {
        return new ModelAndView("/customer/edit", "customer", customerService.findById(id));
    }

    @PostMapping("/update")
    public String updateCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "successfully");
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteCustomerModal(@PathVariable Integer id) {
        return new ModelAndView("/customer/delete", "customer", customerService.findById(id));
    }

    @PostMapping("/delete")
    public String deleteCustomer(Customer customer, @RequestParam String submit, RedirectAttributes redirectAttributes) {
        if (submit.equals("Delete")) {
            redirectAttributes.addFlashAttribute("msg", "successfully");
            customerService.delete(customer.getId());
        }
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public ModelAndView searchPage(@RequestParam String searchCode,
                                   @RequestParam String searchName,
                                   @RequestParam String searchAddress) {
        List<Customer> customers = customerService.searchCustomer(searchCode, searchName, searchAddress);
        return new ModelAndView("/customer/search", "customers", customers);
    }

}
