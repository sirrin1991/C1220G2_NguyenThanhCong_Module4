package com.example.blog.service.impl;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll(Integer quantity) {
        return blogRepository.getBlogList(quantity);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllBLogByCategoryName(String name, Pageable pageable) {
        return blogRepository.findAllByCategory_Name(name,pageable);
    }

    @Override
    public List<Blog> findAllBlogByName(String name) {
        return blogRepository.findBlogByNameContaining(name);
    }
}
