package com.example.blog.repository;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByCategory_Name(String name, Pageable pageable);
    Page<Blog> findAllByNameContaining(String name ,Pageable pageable);


}
