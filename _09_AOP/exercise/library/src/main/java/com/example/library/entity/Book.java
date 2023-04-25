package com.example.library.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    private String name;

    private Integer quantity;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<PersonalCode> codeSet;

    public Book() {
    }

    public Book(Integer id, String name, Integer quantity, Set<PersonalCode> codeSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.codeSet = codeSet;
    }

    public Set<PersonalCode> getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(Set<PersonalCode> codeSet) {
        this.codeSet = codeSet;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
