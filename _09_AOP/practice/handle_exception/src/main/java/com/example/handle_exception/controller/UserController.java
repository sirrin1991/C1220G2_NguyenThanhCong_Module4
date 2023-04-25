package com.example.handle_exception.controller;

import com.example.handle_exception.model.User;
import com.example.handle_exception.service.UserService;
import com.example.handle_exception.util.DuplicateEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String showCreatePage(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

//    @PostMapping("/create")
//    public ModelAndView createUser(User user) {
//        try {
//            userService.save(user);
//            return new ModelAndView("redirect:/");
//        } catch (DuplicateEmailException e) {
//            return new ModelAndView("list");
//        }
//    }

    @ExceptionHandler(DuplicateEmailException.class)
    public String showException() {
        return "list";
    }

    @PostMapping("/create")
    public ModelAndView createUser(User user) throws DuplicateEmailException {
        userService.save(user);
        return new ModelAndView("/create", "user", new User());
    }


}
