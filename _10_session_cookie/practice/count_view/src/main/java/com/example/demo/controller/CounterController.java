package com.example.demo.controller;

import com.example.demo.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("counter")
public class CounterController {
    @ModelAttribute("counter")
    public Counter setUpCounter(){
        return new Counter();
    }

    @GetMapping("/")
    public String get(Counter counter) {
        counter.increment();
        return "/index";
    }
}
