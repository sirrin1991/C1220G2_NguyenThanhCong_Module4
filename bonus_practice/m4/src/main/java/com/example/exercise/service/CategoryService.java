package com.example.exercise.service;

import com.example.exercise.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void deleteById(Integer id);
    void save(Category category);
    Category findById(Integer id);
}
