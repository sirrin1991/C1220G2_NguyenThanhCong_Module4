package com.example.demowebservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "provinceId")
@Entity
@Table(name = "province")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private int provinceId;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "province")
    private List<Customer> customers;

    public Province() {
    }

    public Province(int provinceId, String name) {
        this.provinceId = provinceId;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return provinceId == province.provinceId &&
                Objects.equals(name, province.name) &&
                Objects.equals(customers, province.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceId, name, customers);
    }
}

