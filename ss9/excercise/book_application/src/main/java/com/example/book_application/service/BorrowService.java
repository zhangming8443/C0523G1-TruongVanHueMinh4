package com.example.book_application.service;

import com.example.book_application.model.Book;
import com.example.book_application.model.Borrow;
import com.example.book_application.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;

    @Override
    public void saveBorrowCode(int borrowCode, Book book) {
        Borrow borrow =  new Borrow();
        borrow.setBorrowCode(borrowCode);
        borrow.setBook(book);
        borrowRepository.save(borrow);
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public boolean removeBorrowCode(int borrowId) {
        Borrow borrow = findByCode(borrowId);
        if (borrow != null){
            borrowRepository.delete(borrow);
            return true;
        }
        return false;
    }

    @Override
    public Borrow findByCode(int borrowCode) {
        return borrowRepository.findById(borrowCode).get();
    }
}
