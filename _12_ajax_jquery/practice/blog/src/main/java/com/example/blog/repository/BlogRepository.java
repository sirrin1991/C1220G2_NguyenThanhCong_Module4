package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);
    List<Blog> findBlogByNameContaining(String name);
}
