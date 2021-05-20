package com.example.blog.entity;


import javax.persistence.*;


@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(columnDefinition = "date")
    private String postDate;
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String name, String postDate, String content, Category category) {
        this.id = id;
        this.name = name;
        this.postDate = postDate;
        this.content = content;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
