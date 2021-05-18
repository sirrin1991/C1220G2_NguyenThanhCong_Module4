package com.example.blog.controller;


import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class HomeController {
    private  Integer noRecord = 2;
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView showHomePage(){
        return new ModelAndView("/homepage","blogs",blogService.findAll(2));
    }

    @GetMapping("/search/{nameBlog}")
    public ModelAndView showSearchList(@PathVariable String nameBlog){
        if("".equals(nameBlog)){
            return new ModelAndView("/blog/search","blogs",blogService.findAll(2));
        }
        return new ModelAndView("/blog/search","blogs",blogService.findAllBlogByName(nameBlog));
    }

    @GetMapping("/more-blog")
    public ModelAndView getMore(){
        noRecord += 2;
        return new ModelAndView("/blog/more","blogs",blogService.findAll(noRecord));
    }

}
