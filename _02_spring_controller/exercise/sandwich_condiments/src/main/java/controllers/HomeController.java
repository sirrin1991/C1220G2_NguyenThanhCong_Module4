package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping
    public String show(){
        return "index";
    }

    @PostMapping("/submitCondiments")
    public String showCondiments(Model model, @RequestParam(defaultValue = "") String lettuce){
        if(!lettuce.isEmpty()){
            model.addAttribute("lettuce",lettuce);
        }else {
            model.addAttribute("lettuce","Ahihi!!!!");
        }

        return "list";
    }
}
