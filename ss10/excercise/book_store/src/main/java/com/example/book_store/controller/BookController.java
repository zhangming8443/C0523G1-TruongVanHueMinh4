package com.example.book_store.controller;

import com.example.book_store.dto.BookDto;
import com.example.book_store.dto.CartDto;
import com.example.book_store.model.BookEntity;
import com.example.book_store.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/library")
@SessionAttributes("cart")
public class BookController {
    @Autowired
    private IBookService bookService;

    @ModelAttribute("cart")
    public CartDto initCartDto() {
        return new CartDto();
    }

    @GetMapping("")
    public String showBookList(Model model) {
        List<BookEntity> bookList = bookService.findAllBook();
        model.addAttribute("books", bookList);
        return "list-book";
    }

    @GetMapping("/add")
    public String addToCart(@PathVariable Integer idBook, @SessionAttribute(value = "cart", required = false)
    CartDto cartDto) {
        BookEntity book = bookService.findById(idBook);
        if (book != null) {
            BookDto bookDto = new BookDto();
            BeanUtils.copyProperties(book, bookDto);
            cartDto.addBook(bookDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{index}")
    public String decreaseQuantity(@PathVariable Integer index, HttpSession session) {
        // Lấy đối tượng CartDto từ session
        CartDto cartDto = (CartDto) session.getAttribute("cart");
        if (cartDto != null) {
            cartDto.decreaseQuantity(index);
        }

        return "redirect:/cart";
    }

    @GetMapping("/delete")
    public String deleteToCart(@RequestParam Integer idBook, @SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        BookEntity book = bookService.findById(idBook);
        if (book != null) {
            BookDto productDto = new BookDto();
            BeanUtils.copyProperties(book, productDto);
            cartDto.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/detail/{idBook}")
    public String detail(Model model, @PathVariable Integer idBook) {
        model.addAttribute("book", bookService.findById(idBook));
        return "detail";
    }


}
