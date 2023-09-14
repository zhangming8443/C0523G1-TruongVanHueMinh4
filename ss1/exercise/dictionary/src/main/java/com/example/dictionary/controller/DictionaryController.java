package com.example.dictionary.controller;

import com.example.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("")
    public String showDictionary() {
        return "dictionary";
    }

    @PostMapping("/look_up")
    public String lookUpDictionary(@RequestParam String english, Model model) {
        String result = dictionaryService.lookUp(english);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
