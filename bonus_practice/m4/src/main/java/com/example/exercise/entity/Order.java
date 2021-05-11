package com.example.exercise.entity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    private String name;

    @Column(columnDefinition = "date")
    private String dateOfOrder;

    

}
