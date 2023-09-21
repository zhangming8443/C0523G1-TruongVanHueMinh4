package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByNameAuthorContaining(String name);


    @Query(value = "select * from blog where name_author like :name ", nativeQuery = true)
    List<Blog> searchByNameAuthor(@Param("name") String nameAuthor);

//    @Query(value = "update blog set status = 1  where id = :id ",nativeQuery = true)
//    void deleteBlog(@Param("id")int id);

}

