package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping
    public String show() {
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam int firstNumber,
                             @RequestParam int secondNumber,
                             @RequestParam String submit,
                             Model model) {
        double result = 0;
        String operation = "";
        switch (submit) {
            case "Addition(+)":
                result = firstNumber + secondNumber;
                operation = "Addition";
                break;
            case "Subtraction(-)":
                result = firstNumber - secondNumber;
                operation = "Subtraction";
                break;
            case "Multiplication(X)":
                result = firstNumber * secondNumber;
                operation = "Multiplication";
                break;
            case "Division(/)":
                result = (double) firstNumber / secondNumber;
                operation = "Division";
                break;

        }
        addAttribute(model, firstNumber, secondNumber, result, operation);
        return "index";
    }

    private void addAttribute(Model model, int firstNumber, int secondNumber, double result, String operation) {
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        model.addAttribute("result", result);
        model.addAttribute("operation", operation);
    }


}
