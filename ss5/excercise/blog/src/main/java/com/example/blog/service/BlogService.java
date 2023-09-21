package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public boolean create(Blog blog) {
        Blog newBlog = blogRepository.save(blog);
        return newBlog != null;
    }

    @Override
    public Blog findById(int idBlog) {
        return blogRepository.findById(idBlog).get();
    }

    @Override
    public boolean update(int idBlog, Blog blog) {
        Blog blogUpdate = blogRepository.findById(idBlog).orElse(null);
        if (blogUpdate != null) {
            blogUpdate.setTitle(blog.getTitle());
            blogUpdate.setNameAuthor(blog.getNameAuthor());
            blogUpdate.setContent(blog.getContent());
            blogUpdate.setDateBlog(blog.getDateBlog());
            blogUpdate.setEmailAuthor(blog.getEmailAuthor());
            blogUpdate.setImage(blog.getImage());

            blogRepository.save(blogUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void remove(int idBlog) {

            blogRepository.deleteById(idBlog);


    }
}
