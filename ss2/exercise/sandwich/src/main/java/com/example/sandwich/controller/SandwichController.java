package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @GetMapping("")
    public String showList(){
        return "list";
    }

    @PostMapping("/save")
    public String save(@RequestParam("property") String condiment, Model model) {
        model.addAttribute("property", condiment);
        return "list";
    }

}
