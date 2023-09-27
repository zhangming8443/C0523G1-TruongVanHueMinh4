package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showListBook(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("book", bookList);
        return "list";
    }

    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public String showDetailBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

    @RequestMapping(value = "/{id}/borrow", method = RequestMethod.POST)
    public String borrowBook(@ModelAttribute Book book, @PathVariable int id, RedirectAttributes redirectAttributes) {
        long code = bookService.generateBorrowCode();
        bookService.borrowBook(id, code);
        redirectAttributes.addFlashAttribute("message", "Đã mượn sách thành công với mã số là: " + code);
        return "redirect:/book";
    }
}
