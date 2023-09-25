package com.example.validate_form.controller;


import com.example.validate_form.dto.UserDto;
import com.example.validate_form.model.User;
import com.example.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showForm(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("user", userList);
        return "list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @RequestMapping(value = "/confirm-create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.create(user);
        redirectAttributes.addFlashAttribute("message", "Created successfully !");
        return "redirect:/user";
    }
}
