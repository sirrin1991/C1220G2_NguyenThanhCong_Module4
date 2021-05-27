package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id",nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="service_id",referencedColumnName = "service_id",nullable = false)
    private Service service;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id",nullable = false)
    private Employee employee;

    @ManyToMany
    @JoinTable(
            name = "contract_detail",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "attach_service_id")
    )
    private Set<AttachService> attachServiceSet;

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<AttachService> getAttachServiceSet() {
        return attachServiceSet;
    }

    public void setAttachServiceSet(Set<AttachService> attachServiceSet) {
        this.attachServiceSet = attachServiceSet;
    }
}
