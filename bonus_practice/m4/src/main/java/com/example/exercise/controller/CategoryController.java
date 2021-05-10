package com.example.exercise.controller;

import com.example.exercise.entity.Category;
import com.example.exercise.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ModelAndView showListCategory(){
        return new ModelAndView("/category/list-category","categories",categoryService.findAll());
    }
    @GetMapping("/create-category")
    public ModelAndView showCreateCategoryPage(){
        return new ModelAndView("/category/create-category","category",new Category());
    }
    @PostMapping("/create")
    public String createNewCategory(Category category, Model model){
        categoryService.save(category);
        model.addAttribute("msg","successfully");
        model.addAttribute("category",new Category());
        return "/category/create-category";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditCategoryPage(@PathVariable Integer id){
        return new ModelAndView("/category/edit-category","category",categoryService.findById(id));
    }

    @PostMapping("/edit")
    public String editCategory(Category category , RedirectAttributes ra){
        categoryService.save(category);
        ra.addFlashAttribute("msg","successfully");
        return "redirect:/category";
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteCategoryPage(@PathVariable Integer id){
        return new ModelAndView("/category/delete-category","category",categoryService.findById(id));
    }
    @PostMapping("/delete")
    public String deleteCategory(Category category , RedirectAttributes ra, @RequestParam String submit){
        if(submit.equals("Delete")){
            categoryService.deleteById(category.getId());
            ra.addFlashAttribute("msg","successfully");
        }
        return "redirect:/category";
    }
}
