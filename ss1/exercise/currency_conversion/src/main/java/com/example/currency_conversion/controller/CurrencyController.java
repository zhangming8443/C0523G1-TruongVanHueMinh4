package com.example.currency_conversion.controller;

import com.example.currency_conversion.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("")
    public String showConversion() {
        return "conversion";
    }

    @PostMapping("/currency_conversion")
    public String currencyConversion(@RequestParam double rate, @RequestParam double usd, Model model) {
        double vnd = currencyService.currencyConversion(rate, usd);
        model.addAttribute("vnd", vnd);
        return "conversion";
    }

}
