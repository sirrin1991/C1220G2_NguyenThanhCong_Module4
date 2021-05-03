package controllers;


import model.EmailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping
    public String show(Model model){
        model.addAttribute("emailSetting",new EmailSetting());
        List<String> listLanguage =new ArrayList<>();
        listLanguage.add("English");
        listLanguage.add("Vietnamese");
        listLanguage.add("Japanese");
        listLanguage.add("Chinese");
        model.addAttribute("listLanguage",listLanguage);

        List<Integer> listPageSize = new ArrayList<>();
        listPageSize.add(5);
        listPageSize.add(10);
        listPageSize.add(15);
        listPageSize.add(25);
        listPageSize.add(50);
        listPageSize.add(100);
        model.addAttribute("listPageSize",listPageSize);

        return "index";
    }

    @PostMapping("/save")
    public ModelAndView showInformation(@ModelAttribute EmailSetting emailSetting){
        return new ModelAndView("info","emailSetting",emailSetting);
    }

}
