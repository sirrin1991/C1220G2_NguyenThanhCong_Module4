package com.example.blog.controller;


import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/create")
    public String showCreateBlogPage(Model model){
        model.addAttribute("blog",new Blog());
        return "/blog/create";
    }

    @PostMapping("/create-blog")
    public String createNewBlog(Blog blog,Model model){
        blogService.save(blog);
        model.addAttribute("msg","Saved");
        model.addAttribute("blog",new Blog());
        return "/blog/create";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditBlogPage(@PathVariable Integer id){
        return new ModelAndView("/blog/edit","blog",blogService.findById(id));
    }

    @PostMapping("/edit-blog")
    public String editBlog( Blog blog , RedirectAttributes ra){
        blogService.save(blog);
        ra.addFlashAttribute("msg","Edited successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteBlogPage(@PathVariable Integer id){
        return new ModelAndView("/blog/delete","blog",blogService.findById(id));
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(Blog blog , RedirectAttributes ra){
        blogService.deleteById(blog.getId());
        ra.addFlashAttribute("msg","Deleted successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showBlogView(@PathVariable Integer id){
        return new ModelAndView("/blog/view","blog",blogService.findById(id));
    }


}
