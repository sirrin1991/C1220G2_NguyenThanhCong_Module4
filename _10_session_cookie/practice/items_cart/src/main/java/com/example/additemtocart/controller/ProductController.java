package com.example.additemtocart.controller;

import com.example.additemtocart.model.Cart;
import com.example.additemtocart.model.Product;
import com.example.additemtocart.service.ProductService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;
    @ModelAttribute("cart")
    public Cart getUpCart(){
        return new Cart();
    }

    @GetMapping("/create")
    public ModelAndView showCreateProductPage(){
        return new ModelAndView("/product/create","product",new Product());
    }
    @PostMapping("/save")
    public String addNewProduct(Product product , Model model){
        productService.save(product);
        model.addAttribute("msg","Created product successfully");
        model.addAttribute("product", new Product());
        return "/product/create";
    }
    @GetMapping("/{id}/view")
    public ModelAndView showProductInformationPage(@PathVariable Integer id){
        return new ModelAndView("/product/view","product",productService.findById(id));
    }
    @PostMapping("/{id}/view")
    public String addProductToCart(@PathVariable Integer id,Cart cart,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        if(product == null){
            return "/error-page";
        }else {
            cart.addToCart(product);
            model.addAttribute("msg","Add " + product.getName() + " to cart successfully : " + cart.getQuantity(product));
        }
        return "/product/view";
    }

    @GetMapping("/cart-info")
    public String showCartInformation(Cart cart,Model model){
        double totalCost = cart.getTotalCost();
        model.addAttribute("totalCost",totalCost);
        model.addAttribute("carts",cart.getCart());
        return "/product/cart-info";
    }

    @GetMapping("/{id}/delete")
    public String deleteProductInCart(@PathVariable Integer id,Cart cart,Model model){
        Product product = productService.findById(id);
        cart.removeProduct(product);
        model.addAttribute("carts",cart.getCart());
        return "redirect:/product/cart-info";
    }

    @GetMapping("/{id}/edit")
    public String showEditProductInCartPage(@PathVariable Integer id,@ModelAttribute("cart") Cart cart,
                                            Model model){
        Product product = productService.findById(id);
        String nameProduct = product.getName();
        Integer quantityProduct = cart.getQuantity(product);
        model.addAttribute("idProduct",id);
        model.addAttribute("nameProduct",nameProduct);
        model.addAttribute("quantityProduct",quantityProduct);
        return "/product/edit-product-in-cart";
    }
    @PostMapping("/edit-product-in-cart")
    public String editProductQuantityInCart(@RequestParam Integer id,
                                            @RequestParam (defaultValue = "0") Integer productQuantity, Cart cart){
        Product product = productService.findById(id);
        if(productQuantity < 0){
            return "error-page";
        }else if (productQuantity==0){
            cart.removeProduct(product);
        }else {
            cart.changeQuantity(product,productQuantity);
        }
        return "redirect:/product/cart-info";
    }
}
