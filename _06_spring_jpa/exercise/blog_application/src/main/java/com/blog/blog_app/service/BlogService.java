package com.blog.blog_app.service;

import com.blog.blog_app.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void saveBlog(Blog blog);
    void deleteBlogById(int id);
}
