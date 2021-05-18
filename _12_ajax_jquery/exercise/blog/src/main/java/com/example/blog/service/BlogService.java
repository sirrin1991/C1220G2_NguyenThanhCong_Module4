package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll(Integer quantity);
    void save(Blog blog);
    void deleteById(Integer id);
    Blog findById (Integer id);
    Page<Blog> findAllBLogByCategoryName(String name, Pageable pageable);
    List<Blog> findAllBlogByName(String name);
}
