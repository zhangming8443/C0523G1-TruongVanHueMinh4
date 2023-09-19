package com.example.product_management.controller;

import com.example.product_management.model.Product;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "home";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String create(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 1000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Add new product successfully !");
        return "redirect:/product";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("message", "Update product successfully !");
        return "redirect:/product";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("message", "Delete product successfully !");
        return "redirect:/product";
    }

    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public String showDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String showSearch(@RequestParam String name, Model model, RedirectAttributes redirectAttributes) {
        List<Product> productList1 = new ArrayList<>();
        List<Product> productList = productService.findAll();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name)) {
                productList1.add(productList.get(i));
            }
        }
        model.addAttribute("product", productList1);
        model.addAttribute("name", name);
//        redirectAttributes.addFlashAttribute("product", productList1);
//        redirectAttributes.addFlashAttribute("name", name);
        return "/home";
//        return "redirect:/product";
    }
}
