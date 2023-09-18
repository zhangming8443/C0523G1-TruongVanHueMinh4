package com.example.email.controller;

import com.example.email.model.Email;
import com.example.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/email")
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("email", new Email());
        model.addAttribute("language", emailService.showLanguage());
        model.addAttribute("pageSize", emailService.showPageSize());
        return "home";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String submit(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        emailService.updateEmail(email);
        redirectAttributes.addFlashAttribute("message", "Update success !");
        return "redirect:/email";
    }

}
