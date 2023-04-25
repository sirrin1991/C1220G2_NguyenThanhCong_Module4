package com.example.register_form.entity;

import com.example.register_form.util.validate.UniqueEmail;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Can't not empty")
    @Size(min = 5, max = 45, message = "From 5 to 45 characters")
    private String firstName;

    @NotBlank(message = "Can't not empty")
    @Size(min = 5, max = 45, message = "From 5 to 45 characters")
    private String lastName;

    @NotEmpty(message = "Phone number can not empty")
    @Pattern(regexp = "^\\d{10,11}$", message = "Phone's number has 10 or 11 numbers")
    private String phone;

    @NotEmpty(message = "Email can not empty")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z]{2,}(\\.[a-z]{2,4}){1,2}$",
            message = "Email is invalid ( ex : abc@abc.abc) ")
    @UniqueEmail(message = "Email is existed")
    @Column(unique = true)
    private String email;

    public Register(Integer id, @NotBlank(message = "Can't not empty") @Size(min = 5, max = 45, message = "From 5 to 45 characters") String firstName, @NotBlank(message = "Can't not empty") @Size(min = 5, max = 45, message = "From 5 to 45 characters") String lastName, @NotEmpty(message = "Phone number can not empty") @Pattern(regexp = "^\\d{10,11}$", message = "Phone's number has 10 or 11 numbers") String phone, @NotEmpty(message = "Email can not empty") @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z]{2,}(\\.[a-z]{2,4}){1,2}$",
            message = "Email is invalid ( ex : abc@abc.abc) ") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Register() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
