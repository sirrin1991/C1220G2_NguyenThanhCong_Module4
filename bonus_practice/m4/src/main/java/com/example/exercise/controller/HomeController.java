package com.example.exercise.controller;

import com.example.exercise.entity.Category;
import com.example.exercise.service.CategoryService;
import com.example.exercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @GetMapping
    public String showHomePage(@PageableDefault(value = 3) Pageable pageable,
                               Model model,
                               @RequestParam Optional<String> categorySearch){
        String afterCheckCategory = "";
        if (!categorySearch.isPresent()) {
            model.addAttribute("categorySearch", afterCheckCategory);
            model.addAttribute("products", productService.findAll(pageable));
        }else if(categorySearch.get().equals("")){
            model.addAttribute("categorySearch", afterCheckCategory);
            model.addAttribute("products", productService.findAll(pageable));
        } else {
            afterCheckCategory = categorySearch.get();
            model.addAttribute("categorySearch", afterCheckCategory);
            model.addAttribute("products", productService.findAllByCategoryName(categorySearch.get(), pageable));
        }
        return "homepage";
    }
}
