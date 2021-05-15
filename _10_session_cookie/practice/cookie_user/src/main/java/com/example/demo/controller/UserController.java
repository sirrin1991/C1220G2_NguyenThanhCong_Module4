package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {
    @ModelAttribute
    public User getUser(){
        return new User();
    }

    @GetMapping("/login")
    public String showLoginPage(@CookieValue(value = "cookieUser", defaultValue = "")String cookieUser,
                                Model model){
        Cookie cookie = new Cookie("cookieUser",cookieUser);
        model.addAttribute("cookieValue",cookie);
        return "/login";
    }
    @PostMapping("/dologin")
    public ModelAndView doLogin(User user,
                                HttpServletResponse response) {
        String msg;
        if("abc".equals(user.getEmail())&&"123".equals(user.getPassword())){
            msg = user.getEmail();
            Cookie cookie = new Cookie("infor",msg);
            response.addCookie(cookie);
        }else {
            msg ="Failed to login";
        }
        return new ModelAndView("/login","msg",msg);
    }

}
