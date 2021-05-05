package com.blog.blog_app.repository;

import com.blog.blog_app.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
}
