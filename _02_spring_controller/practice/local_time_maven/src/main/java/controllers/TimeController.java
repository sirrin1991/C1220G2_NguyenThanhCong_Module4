package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeController {
    @GetMapping
    public String showPage(){
        return "index";
    }
}
