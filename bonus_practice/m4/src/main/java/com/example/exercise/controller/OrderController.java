package com.example.exercise.controller;

import com.example.exercise.entity.Order;
import com.example.exercise.entity.Product;
import com.example.exercise.service.OrderService;
import com.example.exercise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @ModelAttribute("products")
    public List<Product> getProductList(){
        return productService.getProductList();
    }

    @GetMapping
    public ModelAndView showOrderList(){
        return new ModelAndView("order/list-order","orders",orderService.findAll());
    }
    @GetMapping("/{id}/view")
    public ModelAndView showOrderInformation(@PathVariable Integer id){
        return new ModelAndView("order/view-order","order",orderService.findById(id));
    }

    @GetMapping("/create-order")
    public ModelAndView showCreateOrderPage(){
        return new ModelAndView("/order/create-order","order",new Order());
    }

    @PostMapping("/create")
    public String createNewOrder(Order order, RedirectAttributes redirectAttributes ){
        orderService.save(order);
        redirectAttributes.addFlashAttribute("msg","successfully");
        return "redirect:/order";
    }
}
