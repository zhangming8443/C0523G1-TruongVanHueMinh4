package com.example.blog.dto;

import com.example.blog.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;

public class BlogDto implements Validator {
    private int idBlog;
    private String nameAuthor;
    private String title;
    private String content;
    private String dateBlog;
    private String emailAuthor;
    private String image;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(int idBlog, String nameAuthor, String title, String content, String dateBlog, String emailAuthor, String image, Category category) {
        this.idBlog = idBlog;
        this.nameAuthor = nameAuthor;
        this.title = title;
        this.content = content;
        this.dateBlog = dateBlog;
        this.emailAuthor = emailAuthor;
        this.image = image;
        this.category = category;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(String dateBlog) {
        this.dateBlog = dateBlog;
    }

    public String getEmailAuthor() {
        return emailAuthor;
    }

    public void setEmailAuthor(String emailAuthor) {
        this.emailAuthor = emailAuthor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
