package com.example.customer_province.controller;


import com.example.customer_province.entity.Province;
import com.example.customer_province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    ProvinceService provinceService;

    @GetMapping
    public ModelAndView showProvinceList(){
        return new ModelAndView("/province/list_province","list",provinceService.findAll());
    }

    @GetMapping("/add")
    public ModelAndView showCreateProvincePage(){
        return new ModelAndView("/province/create_province","province",new Province());
    }

    @PostMapping("/add-new-province")
    public String createProvince(Province province, Model model){
        provinceService.saveProvince(province);
        model.addAttribute("success","Create new province successfully");
        model.addAttribute("province",new Province());
        return "/province/create_province";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable int id){
        return new ModelAndView("/province/delete","province",provinceService.findById(id));
    }

    @PostMapping("/delete-province")
    public String deleteProvince(Province province, RedirectAttributes ra, @RequestParam String submit){
        if(submit.equals("Delete")){
            provinceService.deleteProvince(province.getProvinceId());
            ra.addFlashAttribute("success","deleted province successfully");
        }
        return "redirect:/province";
    }

}
