package com.example.exercise.controller;

import com.example.exercise.entity.Category;
import com.example.exercise.entity.Product;
import com.example.exercise.service.CategoryService;
import com.example.exercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> getListCategory(){
        return categoryService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateProductPage(){
        return new ModelAndView("/product/create-product","product",new Product());
    }
    @PostMapping("/create")
    public String createNewProduct(Product product, Model model){
        productService.saveProduct(product);
        model.addAttribute("msg","success");
        model.addAttribute("product",new Product());
        return "/product/create-product";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditProductPage(@PathVariable Integer id){
        return new ModelAndView("/product/edit-product","product",productService.findById(id));
    }
    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes ra){
        productService.saveProduct(product);
        ra.addFlashAttribute("msg","successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteProductPage(@PathVariable Integer id){
        return new ModelAndView("/product/delete-product","product",productService.findById(id));
    }

    @PostMapping("/delete")
    public String deleteProduct(Product product, RedirectAttributes ra,@RequestParam String submit){
        if(submit.equals("Delete")){
            productService.deleteProduct(product.getId());
            ra.addFlashAttribute("msg","successfully");
        }
        return "redirect:/";
    }
}
