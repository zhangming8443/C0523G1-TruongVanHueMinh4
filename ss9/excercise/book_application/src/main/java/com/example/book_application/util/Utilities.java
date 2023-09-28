package com.example.book_application.util;

public class Utilities {
    public static int randomBorrowCode() {
        int borrowCode = (int) (Math.random() * 90000) + 10000;
        System.out.println("số random dc: " + borrowCode);
        return borrowCode;
    }
}
