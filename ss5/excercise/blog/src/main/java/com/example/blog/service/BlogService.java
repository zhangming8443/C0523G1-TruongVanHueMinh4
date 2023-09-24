package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAllByCategory() {
        return null;
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
    public boolean update(Blog blog) {
//        Blog blogUpdate = blogRepository.findById(idBlog).orElse(null);
//        if (blogUpdate != null) {
//            blogUpdate.setTitle(blog.getTitle());
//            blogUpdate.setNameAuthor(blog.getNameAuthor());
//            blogUpdate.setContent(blog.getContent());
//            blogUpdate.setDateBlog(blog.getDateBlog());
//            blogUpdate.setEmailAuthor(blog.getEmailAuthor());
//            blogUpdate.setImage(blog.getImage());
//
//            blogRepository.save(blogUpdate);
//            return true;
//        }
//        return false;
        if (findById(blog.getIdBlog()) == null) {
            return false;
        } else {
            blogRepository.save(blog);
            return true;
        }
    }

    @Override
    public void remove(int idBlog) {

        blogRepository.deleteById(idBlog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String searchTitle) {
        return blogRepository.findAllByTitleContaining(pageable, searchTitle);
    }
}
