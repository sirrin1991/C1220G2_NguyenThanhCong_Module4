package com.example.phone_ajax.controller;

import com.example.phone_ajax.model.Phone;
import com.example.phone_ajax.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/")
    public ModelAndView getListPhone(){
        return new ModelAndView("/home","phones",phoneService.findAll());
    }

    @GetMapping("/create")
    public String  showListPhone(){
        return "/create";

    }

    @PostMapping("/create")
    @ResponseBody
    public Phone createSmartphone(@RequestBody Phone phone) {
        System.out.println(phone.toString());
        return phoneService.save(phone);
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public Phone showDeletePage(@PathVariable Integer id){
        phoneService.delete(id);
        return phoneService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditPage(@PathVariable Integer id){
        return new ModelAndView("/edit","phone",phoneService.findById(id));
    }

    @PostMapping("/edit")
    public String editPhone(Phone phone, RedirectAttributes redirectAttributes){
        phoneService.save(phone);
        return "redirect:";
    }

}