package com.example.email.repository;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailRepo {
    Email display();
    List<String> showLanguage();
    List<Integer> showPageSize();
    void  updateEmail(Email email);

}
