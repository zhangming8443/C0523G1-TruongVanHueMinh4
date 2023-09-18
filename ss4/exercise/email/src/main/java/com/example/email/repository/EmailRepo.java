package com.example.email.repository;

import com.example.email.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepo implements IEmailRepo {
    private static final List<String> languageList = new ArrayList<>();
    private static final List<Integer> pageSize = new ArrayList<>();
    private static final Email emailUpdate = new Email();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);

    }

    @Override
    public Email display() {
        return null;
    }

    @Override
    public List<String> showLanguage() {
        return languageList;
    }

    @Override
    public List<Integer> showPageSize() {
        return pageSize;
    }

    @Override
    public void updateEmail(Email email) {
        emailUpdate.setLanguage(email.getLanguage());
        emailUpdate.setPageSize(email.getPageSize());
        emailUpdate.setSpamFilter(email.isSpamFilter());
        emailUpdate.setSignature(email.getSignature());
    }
}
