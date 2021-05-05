package com.blog.blog_app.entity;

import javax.persistence.*;

@Entity
@Table(name="blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    private String blogName;
    private String content;

    public Blog() {
    }

    public Blog(int id, String blogName, String content) {
        this.id = id;
        this.blogName = blogName;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
