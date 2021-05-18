package com.example.blog.controller;

import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
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
    public ModelAndView showCategoryPage(){
        return new ModelAndView("/category/category_list","categories",categoryService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCategoryCreatePage(){
        return new ModelAndView("/category/create","category",new Category());
    }

    @PostMapping("/create-category")
    public String createCategory(Category category, Model model){
        categoryService.save(category);
        model.addAttribute("category",new Category());
        model.addAttribute("msg","successfully");
        return "/category/create";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showCategoryEditPage(@PathVariable Integer id){
        return new ModelAndView("/category/edit","category",categoryService.findById(id));
    }

    @PostMapping("/edit-category")
    public String editCategory(Category category, RedirectAttributes ra){
        categoryService.save(category);
        ra.addFlashAttribute("msg","Edited successfully");
        return "redirect:/category";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showCategoryDeletePage(@PathVariable Integer id){
        return new ModelAndView("/category/delete","category",categoryService.findById(id));
    }

    @PostMapping("/delete-category")
    public String deleteCategory(Category category, RedirectAttributes ra,@RequestParam String submit){
        if(submit.equals("Delete")){
            categoryService.deleteById(category.getId());
            ra.addFlashAttribute("msg","Delete successfully");
        }
        return "redirect:/category";
    }

}
