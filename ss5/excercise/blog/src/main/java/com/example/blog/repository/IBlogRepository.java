package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContaining(Pageable pageable,String title);

    List<Blog> findAllByCategory(Category category);

//    @Query(value = "select * from blog where id_category =:id", nativeQuery = true)
//
//    List<Blog> searchBlogByCategory(@Param("categoryId") int id);



//    @Query(value = "select * from blog where name_author like :name ", nativeQuery = true)
//    List<Blog> searchByNameAuthor(@Param("nameAuthor") String nameAuthor);


}

