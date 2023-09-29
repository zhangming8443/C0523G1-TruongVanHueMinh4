package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();
    Page<Blog> findAll(Pageable pageable, String searchTitle);

    boolean create(Blog blog);

    Blog findById(int idBlog);

    boolean update(Blog blog);
    void remove(int id);
}
