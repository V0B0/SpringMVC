package ru.V0B0.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "lastname", required = false) String lastName,
                            Model model)  {

//        System.out.println("Hello " + name + " " + lastName);
        model.addAttribute("message", "Hello " + name + " " + lastName);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage () {
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam("v1") int value1,
                       @RequestParam("v2") int value2,
                       @RequestParam("action") String action,
                       Model model) {
        double request = 0;
        switch (action) {
            case "multiplication":
                request = value1 * value2;
                break;
            case "addition":
                request = value1 + value2;
                break;
            case "subtraction":
                request = value1 - value2;
                break;
            case "division":
                request = value1 / (double) value2;
                break;
        }
        model.addAttribute("request", String.valueOf(request));
        return "first/calc";
    }
}
