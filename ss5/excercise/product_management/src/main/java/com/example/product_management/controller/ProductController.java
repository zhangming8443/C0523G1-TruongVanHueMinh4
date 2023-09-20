package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "home";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @RequestMapping(value = "/confirm-create", method = RequestMethod.POST)
    public String create(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("message", "Created product successfully !");
        return "redirect:/product";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @RequestMapping(value = "/confirm-update", method = RequestMethod.POST)
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Updated product successfully !");
        return "redirect:/product";
    }

    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public String showDetailView(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted product successfully !");
        return "redirect:/product";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String showListSearch(@RequestParam String name, Model model){
        List<Product> productList = productService.findByName(name);
        model.addAttribute("product", productList);
        model.addAttribute("name", name);
        return "/home";
    }

}