package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private static final int RATE = 23000;
    @GetMapping()
    public String showPage(){
        return "index";
    }


    @PostMapping("/index")
    public String convert(@RequestParam String usd, Model model){
        double result = Integer.parseInt(usd)* 23000;
        model.addAttribute("result",result);
        model.addAttribute("usd",usd);
        return "index";
    }
}
