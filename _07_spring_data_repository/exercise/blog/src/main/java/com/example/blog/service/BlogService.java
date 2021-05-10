package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);
    void deleteById(Integer id);
    Blog findById (Integer id);
    Page<Blog> findAllBLogByCategoryName(String name, Pageable pageable);
    Page<Blog> findAllBlogByName(String name, Pageable pageable);
}
