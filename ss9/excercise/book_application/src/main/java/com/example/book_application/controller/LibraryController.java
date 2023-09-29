package com.example.book_application.controller;

import com.example.book_application.model.Book;
import com.example.book_application.model.Borrow;
import com.example.book_application.service.IBookService;
import com.example.book_application.service.IBorrowService;
import com.example.book_application.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/library")
public class LibraryController {
    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private IBookService bookService;


    @GetMapping(value = "")
    public String showBookList(Model model) {
        List<Book> bookList = bookService.showBookList();
        model.addAttribute("book", bookList);
        return "home-page";
    }

    @GetMapping(value = "/detail/{id}")
    public String showDetailBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.findById(id));
        return "/detail";
    }

    @PostMapping(value = "/borrow")
    public String bookBorrow(@ModelAttribute Book book,
                       RedirectAttributes redirectAttributes) {
       Book book1 = bookService.findById(book.getBookId());
        book1.setBookQuantity(book.getBookQuantity() - 1);
        book1.setBookImage(book1.getBookImage());
        int borrowCode = Utilities.randomBorrowCode();
        borrowService.saveBorrowCode(borrowCode, book);
        bookService.save(book1);
        redirectAttributes.addFlashAttribute("message", "Successful book rental, your rental code is: " + borrowCode);
        return "redirect:/library";
    }

    @GetMapping(value = "/borrow-list")
    public String showBorrowList(Model model) {
        List<Borrow> borrowList = borrowService.findAll();
        model.addAttribute("borrowed", borrowList);
        return "borrow-list";
    }

    @GetMapping(value = "/book-return")
    public String showFormBookReturn(Model model) {
        model.addAttribute("borrow", new Borrow());
        return "return-book";
    }

    @PostMapping(value = "/book-return")
    public String bookReturn(@RequestParam int borrowCode,
                             RedirectAttributes redirectAttributes) {
        List<Borrow> borrowList = borrowService.findAll();
        Borrow borrow = null;
        int code = 0;
        for (int i = 0; i < borrowList.size(); i++) {
            if (borrowCode == borrowList.get(i).getBorrowCode()) {
                code = borrowList.get(i).getBorrowCode();
                borrow = borrowList.get(i);
                break;
            }
        }
        if (code == 0 && borrow == null) {
            redirectAttributes.addFlashAttribute("message", "You haven't borrowed any books yet !");
            return "redirect:/library/book-return";
        }
        Book book = borrow.getBook();
        book.setBookQuantity(book.getBookQuantity() + 1);
        bookService.save(book);
        borrowService.removeBorrowCode(borrow.getBorrowId());
        redirectAttributes.addFlashAttribute("message", "Trả thành công");
        return "redirect:/library";
    }
}
