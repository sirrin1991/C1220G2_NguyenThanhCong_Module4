package controllers;


import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.List;

@Controller
public class HomeController {
    ProductService productService = new ProductServiceImpl();
    @GetMapping
    public String showHomePage(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("products",products);
        return "home";
    }

    @PostMapping("/search")
    public String searchByName(Product product, Model model){
        String name = product.getName();
        List<Product> products = productService.findByName(name);
        model.addAttribute("products",products);
        return "home";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/save")
    public String createNewProduct(Product product, RedirectAttributes ra){
        product.setId(productService.findAll().size()+1);
        productService.save(product.getId(),product);
        ra.addFlashAttribute("success","Add new product successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String showEditPage(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes ra){
        productService.save(product.getId(),product);
        ra.addFlashAttribute("success","Edited product successfully");
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String showDeletePage(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteProduct(RedirectAttributes ra, Product product, @RequestParam String submit){
        if(submit.equals("Delete")){
            productService.remove(product.getId());
            ra.addFlashAttribute("success","Removed product successfully");
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String showProductInformation(@PathVariable int id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "view";
    }
}
