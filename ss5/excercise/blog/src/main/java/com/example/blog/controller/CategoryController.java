package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showListCategory(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("category", categoryList);
        return "category-list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "create-category";
    }

    @RequestMapping(value = "/confirm-create", method = RequestMethod.POST)
    public String create(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.create(category);
        redirectAttributes.addFlashAttribute("message", "Created new category successfully !");
        return "redirect:/category";
    }

    @RequestMapping(value = "/{idCategory}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable int idCategory, Model model) {
        model.addAttribute("category", categoryService.findByiD(idCategory));

        return "update-category";
    }

    @RequestMapping(value = "/confirm-update", method = RequestMethod.POST)
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        if (categoryService.update(category)) {
            redirectAttributes.addFlashAttribute("message", "Updated category successfully !");
            return "redirect:/category";
        } else {
            redirectAttributes.addFlashAttribute("message", "Category not exist !");
            return "redirect:/" + category.getIdCategory() + "/update";
        }
    }

    @RequestMapping(value = "/{idCategory}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int idCategory) {
        categoryService.delete(idCategory);
        return "redirect:/category";
    }


}
