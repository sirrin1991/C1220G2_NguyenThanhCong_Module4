package com.example.blog.service;

import com.example.blog.entity.Category;


import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void save(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);
}
