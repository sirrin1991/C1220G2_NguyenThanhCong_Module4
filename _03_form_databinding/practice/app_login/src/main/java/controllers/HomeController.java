package controllers;
import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.UserRepositoryImpl;


@Controller
public class HomeController {
    UserRepositoryImpl userService = new UserRepositoryImpl();

    @GetMapping
    public ModelAndView show() {
        return new ModelAndView("index", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView showInfo(@ModelAttribute Login login) {

        User user = userService.checkLogin(login);
        if (user != null){
            return new ModelAndView("info","user",user);
        }
        return new ModelAndView("info","mess","Login Fail");
    }
}
