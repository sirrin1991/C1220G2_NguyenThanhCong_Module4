package com.example.final_exam.controller;

import com.example.final_exam.model.SaleInformation;
import com.example.final_exam.service.SaleInformationService;
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
public class SaleInformationController {
    @Autowired
    private SaleInformationService saleInformationService;
    @GetMapping
    public ModelAndView showHomePage(){
        return new ModelAndView("/home","sales",saleInformationService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage(){
        return new ModelAndView("/create","sale",new SaleInformation());
    }

    @PostMapping("/save")
    public String saveNewSaleInformation(@Valid @ModelAttribute("sale") SaleInformation saleInformation,
                                         BindingResult bindingResult,
                                         Model model){
        new SaleInformation().validate(saleInformation,bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }
        saleInformationService.save(saleInformation);
        model.addAttribute("msg","Successfully");
        model.addAttribute("sale",new SaleInformation());
        return "/create";
    }
    @GetMapping("/delete/{id}")
    public String showDeleteModal(@PathVariable Integer id,Model model){
       SaleInformation saleInformation = saleInformationService.findById(id);
       if(saleInformation==null){
           return "/error-page";
       }
       model.addAttribute("sale",saleInformation);
       return "/delete";
    }

    @PostMapping("/delete")
    public String deleteSaleInformation(SaleInformation saleInformation,
                                        RedirectAttributes redirectAttributes,
                                        @RequestParam String submit){
        if (submit.equals("Delete")) {
            redirectAttributes.addFlashAttribute("msg", "successfully");
            saleInformationService.delete(saleInformation.getId());
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public ModelAndView showListSearch(@RequestParam String discount,
                                       @RequestParam String startDate,
                                       @RequestParam String endDate){
        List<SaleInformation> sales = saleInformationService.search(discount, startDate, endDate);
        return new ModelAndView("/home","sales",sales);
    }

}
