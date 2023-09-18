package com.example.email.service;

import com.example.email.model.Email;

import java.util.List;

public interface IEmailService {
    Email display();
    List<String> showLanguage();
    List<Integer> showPageSize();
    void  updateEmail(Email email);
}
