package controllers;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.util.List;

@Controller
public class HomeController {
    CustomerService customerService = new CustomerServiceImpl();
    @GetMapping
    public String show(Model model){
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "index";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute Customer customer ,RedirectAttributes redirectAttributes){
        customer.setId(customerService.findAll().size() + 1);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success","success");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditPage(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateCustomer(Customer customer, RedirectAttributes redirectAttributes){
        customerService.update(customer.getId(),customer);
        redirectAttributes.addFlashAttribute("success","success");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String showDeletePage(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(Customer customer, @RequestParam String submit,RedirectAttributes redirectAttributes){
       if(submit.equals("Delete")){
           customerService.remove(customer.getId());
           redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
       }
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String showViewCustomer(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "view";
    }
}
