package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showBlogPage(Model model, @RequestParam(defaultValue = "0", required = false) int page,
                               @RequestParam(defaultValue = "", required = false) String searchTitle) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("dateBlog").descending());
        Page<Blog> blogPage = blogService.findAll(pageable, searchTitle);
        model.addAttribute("blog", blogPage);
        model.addAttribute("searchTitle", searchTitle);
        return "home-page";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", categoryList);
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
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("blog", blogService.findById(idBlog));
        model.addAttribute("category", categoryList);

        return "update-blog";
    }

    @RequestMapping(value = "/confirm-update", method = RequestMethod.POST)
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.update(blog)) {
            redirectAttributes.addFlashAttribute("message", "Updated blog successfully !");
            return "redirect:/blog";
        } else {
            redirectAttributes.addFlashAttribute("message", "Blog not exist !");
            return "redirect:/" + blog.getIdBlog() + "/update";
        }
    }

    @RequestMapping(value = "/{idBlog}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int idBlog, Model model) {
        blogService.remove(idBlog);
        return "redirect:/blog";
    }


}
