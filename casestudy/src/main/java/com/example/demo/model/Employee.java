package com.example.demo.model;



import com.example.demo.service.impl.EmployeeServiceImpl;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "employee_name")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[A-Z][a-z]*(\\ [A-Z][a-z]*)*$",message = "Không đúng định dạng")
    private String name;

    @Column(name = "employee_birthday")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(((0[1-9]|[12]\\d|3[01])-((0[13578])|(1[02])))|((0[1-9]|[12]\\d|30)-((0[2469])|11)))-((19[4-9]\\d)|200[0-3])$",message = "Tuổi không hợp lệ")
    private String birthday;

    @Column(name = "employee_id_card")
    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(\\d{9}|\\d{12})$",message = "Không đúng định dạng")
    private String idCard;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^(([1-9]+\\d*)|0)\\.?\\d{1,2}$",message = "lương phải là số dương")
    private String salary;

    @NotEmpty(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$",message = "Số điện thoại phải bắt đầu bằng 090 hoặc 091 hoặc +(84)90 hoặc +(84)91")
    private String phone;

    @NotEmpty(message = "Email không được để trống")
    @Pattern(regexp = "^[a-z]+([\\_\\.]?[a-z\\d]+)*@[a-z]{3,7}\\.[a-z]{3}$",message = "Email không đúng định dạng")
    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name = "division_id" , nullable = false, referencedColumnName = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_degree_id",nullable = false,referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(nullable = false,name = "position_id",referencedColumnName = "position_id")
    private Position position;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL )
    private Set<Contract> contractSet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    public Employee() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
