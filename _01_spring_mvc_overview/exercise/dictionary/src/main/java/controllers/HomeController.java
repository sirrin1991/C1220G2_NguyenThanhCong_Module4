package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;
import service.Service;

@Controller
public class HomeController {
    Service service = new DictionaryService();
    @GetMapping()
    public String showHomePage(){
        return "index";
    }

    @PostMapping("/index")
    public String translate(@RequestParam String english, Model model){
        String result = service.findValue(english);
        if (result != null){
            model.addAttribute("english",english);
            model.addAttribute("result",result);
        }else {
            model.addAttribute("notfound","NOT FOUND");
            model.addAttribute("english",english);
        }
        return "index";
    }
}
