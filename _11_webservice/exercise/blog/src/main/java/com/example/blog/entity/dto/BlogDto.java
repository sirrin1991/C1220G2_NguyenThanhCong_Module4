package com.example.blog.entity.dto;

import com.example.blog.entity.Category;

import java.util.Set;

public class BlogDto {
    private Integer id;
    private String name;
    private String postDate;
    private String content;
    public BlogDto() {
    }

    public BlogDto(Integer id, String name, String postDate, String content) {
        this.id = id;
        this.name = name;
        this.postDate = postDate;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
