package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("")
    private String showCalculator() {
        return "/home";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam String calculate, @RequestParam double number1, @RequestParam double number2, Model model) {
        String result = calculatorService.calculate(calculate, number1, number2);
        model.addAttribute("result", result);
        return "/home";
    }
}
