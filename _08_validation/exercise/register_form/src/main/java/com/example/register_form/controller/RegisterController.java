package com.example.register_form.controller;


import com.example.register_form.entity.Register;
import com.example.register_form.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @GetMapping
    public ModelAndView showRegisterForm() {
        return new ModelAndView("register", "register", new Register());
    }

    @PostMapping("/create")
    public String createRegister(@Valid Register register, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            registerService.save(register);
            return "result";
        }
    }
}
