package com.example.blog.repository;


import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
