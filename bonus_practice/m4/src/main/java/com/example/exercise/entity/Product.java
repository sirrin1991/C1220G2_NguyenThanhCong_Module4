package com.example.exercise.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    private String name;
    private Double price;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_detail_id",referencedColumnName = "product_detail_id")
    private ProductDetail productDetail;

    @ManyToOne()
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "category_id")
    private Category category;


    @ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orderSet;

    public Product() {
    }

    public Product(Integer id, String name, Double price, ProductDetail productDetail, Category category, Set<Order> orderSet) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productDetail = productDetail;
        this.category = category;
        this.orderSet = orderSet;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
}
