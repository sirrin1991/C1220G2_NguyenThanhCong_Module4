package com.example.additemtocart.controller;

import com.example.additemtocart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public ModelAndView showHomePage(){
        return new ModelAndView("home","products",productService.findAll());

    }
}
