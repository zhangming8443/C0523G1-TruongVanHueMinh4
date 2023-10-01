package com.example.book_store.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<BookDto, Integer> bookMap = new HashMap<>();

    public CartDto() {
    }

    public void addProduct(BookDto productDto) {
        if (bookMap.containsKey(productDto)) {
            Integer currentValue = bookMap.get(productDto);
            bookMap.replace(productDto, currentValue + 1);

        } else {
            bookMap.put(productDto, 1);
        }
    }

    public void deleteProduct(BookDto productDto) {
        bookMap.remove(productDto);
    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<BookDto, Integer> entry : bookMap.entrySet()) {
            payment += entry.getKey().getBookPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<BookDto, Integer> entry : bookMap.entrySet()) {
            payment += entry.getKey().getBookPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public Map<BookDto, Integer> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<BookDto, Integer> bookMap) {
        this.bookMap = bookMap;
    }
}
