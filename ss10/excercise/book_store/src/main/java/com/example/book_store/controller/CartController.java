package com.example.book_store.controller;

import com.example.book_store.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("cart")
public class CartController {
    @GetMapping("")
    public String showCart(Model model, @SessionAttribute(value = "cart", required = false)
    CartDto cartDto) {
        model.addAttribute("cart", cartDto);
        return "cart-list";
    }

}
