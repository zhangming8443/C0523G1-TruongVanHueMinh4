package com.example.email.service;

import com.example.email.model.Email;
import com.example.email.repository.IEmailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepo emailRepo;

    @Override
    public Email display() {
        return emailRepo.display();
    }

    @Override
    public List<String> showLanguage() {
        return emailRepo.showLanguage();
    }

    @Override
    public List<Integer> showPageSize() {
        return emailRepo.showPageSize();
    }

    @Override
    public void updateEmail(Email email) {
        emailRepo.updateEmail(email);
    }
}
