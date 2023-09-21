package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    boolean create(Blog blog);

    Blog findById(int idBlog);

    boolean update(int idBlog, Blog blog);
    void remove(int id);
}
