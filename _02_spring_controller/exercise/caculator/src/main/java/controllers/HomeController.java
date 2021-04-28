package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping
    public String show(){
        return "index";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam int firstNumber,
                             @RequestParam int secondNumber,
                             @RequestParam String submit,
                             Model model){
        double result = 0;
        switch (submit){
            case "Addition(+)":
                result = firstNumber + secondNumber;

                break;
            case "Subtraction(-)":
                result = firstNumber - secondNumber;

                break;
            case "Multiplication(X)":
                result = firstNumber * secondNumber;

                break;
            case "Division(/)":
                try{
                    result = (double) firstNumber / secondNumber;
                    addAttribute(model,firstNumber,secondNumber,result);
                }catch (ArithmeticException e){
                    e.printStackTrace();
                }finally {
                    model.addAttribute("result","Can not division by zero");
                }

                break;
        }
        addAttribute(model,firstNumber,secondNumber,result);
        return "index";
    }

    private void addAttribute(Model model,int firstNumber,int secondNumber, double result){
        model.addAttribute("firstNumber",firstNumber);
        model.addAttribute("secondNumber",secondNumber);
        model.addAttribute("result",result);
        model.addAttribute("operation", "addition");
    }
}
