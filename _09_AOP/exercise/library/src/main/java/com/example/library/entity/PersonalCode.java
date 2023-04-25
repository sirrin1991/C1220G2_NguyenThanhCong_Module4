package com.example.library.entity;

import javax.persistence.*;

@Entity
@Table(name = "code")
public class PersonalCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private Integer id;

    private String codeForBook;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    public PersonalCode() {
    }

    public PersonalCode(Integer id, String codeForBook, Book book) {
        this.id = id;
        this.codeForBook = codeForBook;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeForBook() {
        return codeForBook;
    }

    public void setCodeForBook(String codeForBook) {
        this.codeForBook = codeForBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
