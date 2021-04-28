package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimeController {

    @GetMapping()
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        return "index";
    }
}