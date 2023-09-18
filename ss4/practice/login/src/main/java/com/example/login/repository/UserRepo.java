package com.example.login.repository;

import com.example.login.model.Login;
import com.example.login.model.User;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("john", "123456", "John", "john@codegym.vn", 18));
        users.add(new User("bill", "123456", "Bill", "bill@codegym.vn", 20));
        users.add(new User("mike", "123456", "Mike", "mike@codegym.vn", 22));
    }

    public static User checkLogin(Login login) {
        for (User user : users) {
            if (user.getAccount().equals(login.getAccount())
                    && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
