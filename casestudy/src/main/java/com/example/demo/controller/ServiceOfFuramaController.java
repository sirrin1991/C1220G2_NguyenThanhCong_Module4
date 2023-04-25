package com.example.demo.controller;

import com.example.demo.model.service_of_furama.Service;
import com.example.demo.model.service_of_furama.ServiceValidator;
import com.example.demo.service.IRentTypeService;
import com.example.demo.service.IServiceOfFuramaService;
import com.example.demo.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceOfFuramaController {
    @Autowired
    private IServiceOfFuramaService serviceOfFuramaService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private ServiceValidator serviceValidator;

    @ModelAttribute
    public void getServiceTypeAndRentType(Model model) {
        model.addAttribute("serviceTypes", serviceTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
    }


    @GetMapping
    public ModelAndView showServicePage() {
        List<Service> services = serviceOfFuramaService.findAll();
        return new ModelAndView("/service/list", "services", services);
    }

    @GetMapping("/create")
    public ModelAndView showCreateServicePage() {
        return new ModelAndView("/service/create", "service", new Service());
    }

    @PostMapping("/save")
    public String saveService(@Valid @ModelAttribute("service") Service service,
                              BindingResult bindingResult, Model model) {
        serviceValidator.validate(service, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/service/create";
        }
        service.setStatus(true);
        serviceOfFuramaService.save(service);
        model.addAttribute("msg", "Successfully");
        model.addAttribute("service", new Service());
        return "/service/create";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditServicePage(@PathVariable Integer id) {
        return new ModelAndView("/service/edit", "service", serviceOfFuramaService.findById(id));
    }

    @PostMapping("/update")
    public String updateService(@Valid @ModelAttribute("service") Service service,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        serviceValidator.validate(service, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/service/edit";
        }
        serviceOfFuramaService.save(service);
        redirectAttributes.addFlashAttribute("msg", "Successfully");
        return "redirect:/service";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showServiceInformation(@PathVariable Integer id) {
        return new ModelAndView("/service/view", "service", serviceOfFuramaService.findById(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteServiceModal(@PathVariable Integer id) {
        return new ModelAndView("/service/delete", "service", serviceOfFuramaService.findById(id));
    }

    @PostMapping("delete")
    public String deleteService(Service service, RedirectAttributes redirectAttributes, @RequestParam String submit) {
        if (submit.equals("Delete")) {
            redirectAttributes.addFlashAttribute("msg", "successfully");
            serviceOfFuramaService.deleteById(service.getId());
        }
        return "redirect:/service";
    }
}
