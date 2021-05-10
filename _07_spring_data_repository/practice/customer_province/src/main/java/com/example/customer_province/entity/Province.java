package com.example.customer_province.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "province")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private int provinceId;

    private String name;

    @OneToMany(mappedBy = "province",cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Province() {
    }

    public Province(int provinceId, String name, List<Customer> customers) {
        this.provinceId = provinceId;
        this.name = name;
        this.customers = customers;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
