package com.example.book_store.controller;

import com.example.book_store.model.BookEntity;
import com.example.book_store.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/library")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showBookList(Model model){
        List<BookEntity> bookList = bookService.findAllBook();
        model.addAttribute("books", bookList);
        return "list-book";

    }








}
