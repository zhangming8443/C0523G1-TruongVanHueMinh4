package com.example.validate_form.model;

import javax.validation.constraints.*;

public class User {
    @NotEmpty
    @Size(min = 5, max = 45, message = "Length form 5 to 45")
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45, message = "Length form 5 to 45")
    private String lastName;
    @Pattern(regexp = "^(0\\d{9})$", message = "Invalid phone number")
    private String phone;
    @Min(value = 18, message = "Over 18 year old")
    private int age;

    @Email(message = "Invalid email")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phone, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
