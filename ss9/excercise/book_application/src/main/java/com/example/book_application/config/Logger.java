package com.example.book_application.config;

import org.aspectj.lang.annotation.After;

public class Logger {
    private static int count = 0;
    @After("execution(* com.example.book_application.controller.LibraryController.showBookList(..))")
    public void showBorrowList(){
        count++;
        System.out.println("Vừa có người truy cập");
    }
    @After("execution(* com.example.book_application.controller.BookController.bookBorrow(..))")
    public void bookBorrow(){
        System.out.println("Vừa có người thuê sách");
    }
    @After("execution(* com.example.book_application.controller.BookController.bookReturn(..))")
    public void bookReturn(){
        System.out.println("Vừa có người trả sách");
    }
}
