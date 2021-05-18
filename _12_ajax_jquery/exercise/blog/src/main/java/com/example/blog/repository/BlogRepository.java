package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);
    List<Blog> findBlogByNameContaining(String name);


    @Query( value = "call get_blog(:quantity)", nativeQuery = true)
    List<Blog> getBlogList(@Param("quantity") Integer quantity);
}
