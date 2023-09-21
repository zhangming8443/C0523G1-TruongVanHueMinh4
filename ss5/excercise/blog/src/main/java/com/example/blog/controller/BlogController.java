package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showBlogPage(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blog", blogList);
        return "home-page";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blogging";
    }

    @RequestMapping(value = "/confirm-create", method = RequestMethod.POST)
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("message", "Wrote a new blog successfully !");
        return "redirect:/blog";
    }

    @RequestMapping(value = "/{idBlog}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable int idBlog, Model model) {
        model.addAttribute("blog", blogService.findById(idBlog));
        return "update-blog";
    }

    @RequestMapping(value = "/confirm-update", method = RequestMethod.POST)
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.update(blog.getIdBlog(), blog);
        redirectAttributes.addFlashAttribute("message", "Updated blog successfully !");
        return "redirect:/blog";
    }

    @RequestMapping(value = "/{idBlog}/delete", method = RequestMethod.GET)
    public String showFormDelete(@PathVariable int idBlog, Model model){
//        Blog blog = blogService.findById(idBlog);
        blogService.remove(idBlog) ;
//        model.addAttribute("blog", blogService.findById(idBlog));
        return "redirect:/blog";
    }




}
