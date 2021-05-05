package com.blog.blog_app.controller;

import com.blog.blog_app.entity.Blog;
import com.blog.blog_app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public ModelAndView showPage(){
        List<Blog> list = blogService.findAll();
        return new ModelAndView("home","list",list);
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage(){
        return new ModelAndView("create","blog",new Blog());
    }

    @PostMapping("/save")
    public String createNewBlog(Blog blog, Model model){
        blogService.saveBlog(blog);
        model.addAttribute("blog",new Blog());
        model.addAttribute("success","Created new blog successfully");
        return "create";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showViewPage(@PathVariable int id){
        Blog blog = blogService.findById(id);
        return new ModelAndView("view","blog",blog);
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditPage(@PathVariable int id){
        Blog blog = blogService.findById(id);
        return new ModelAndView("edit","blog",blog);
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog, RedirectAttributes ra){
        blogService.saveBlog(blog);
        ra.addFlashAttribute("success","Updated blog successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeletePage(@PathVariable int id){
        Blog blog = blogService.findById(id);
        return new ModelAndView("delete","blog",blog);
    }

    @PostMapping("/delete")
    public String deleteBlog(Blog blog, RedirectAttributes ra, @RequestParam String submit){
        if (submit.equals("Delete")){
            blogService.deleteBlogById(blog.getId());
            ra.addFlashAttribute("success","Deleted blog successfully");
        }
        return "redirect:/";

    }
}
