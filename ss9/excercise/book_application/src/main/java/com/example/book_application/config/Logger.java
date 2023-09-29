package com.example.book_application.config;

import org.aspectj.lang.annotation.After;

public class Logger {
    private static int count = 0;
    @After("execution(* com.example.book_application.controller.LibraryController.showBookList(..))")
    public void showBorrowList(){
        count++;
        System.out.println("Someone just visited");
    }
    @After("execution(* com.example.book_application.controller.BookController.bookBorrow(..))")
    public void bookBorrow(){
        System.out.println("Someone just rented the book");
    }
    @After("execution(* com.example.book_application.controller.BookController.bookReturn(..))")
    public void bookReturn(){
        System.out.println("Someone just returned the book");
    }
}
