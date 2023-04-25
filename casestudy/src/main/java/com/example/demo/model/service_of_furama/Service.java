package com.example.demo.model.service_of_furama;

import com.example.demo.model.contract.Contract;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "service_code")
    @NotEmpty(message = "Không được để trống.")
    @Pattern(regexp = "^(DV-)\\d{4}$", message = "Sai định dạng . ( DV-XXXX ).")
    private String code;

    @Column(name = "service_name")
    @NotEmpty(message = "Không được để trống.")
    @Pattern(regexp = "^[A-Z][a-z]*(\\ [A-Z][a-z]*)*$", message = "Sai định dạng  ( Abc ).")
    private String name;

    @Column(columnDefinition = "int")
    @NotEmpty(message = "Không được để trống.")
    @Pattern(regexp = "^[1-9]+\\d*$", message = "Phải là số nguyên lớn hơn 0.")
    private String area;

    @NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
    private BigDecimal cost;

    @Column(columnDefinition = "int")
    @NotEmpty(message = "Không được để trống.")
    @Pattern(regexp = "^[1-9]+\\d*$", message = "Phải là số nguyên lớn hơn 0.")
    private String maxOfPeople;

    @NotEmpty(message = "Không được để trống")
    private String standard;

    @NotEmpty(message = "Không được để trống")
    private String descriptionOtherConvenience;

    @Column(columnDefinition = "int")
    @NotEmpty(message = "Không được để trống.")
    @Pattern(regexp = "^[1-9]+\\d*$", message = "Phải là số nguyên lớn hơn 0.")
    private String poolArea;

    @Column(columnDefinition = "int")
    @NotEmpty(message = "Không được để trống.")
    @Pattern(regexp = "^[1-9]+\\d*$", message = "Phải là số nguyên lớn hơn 0.")
    private String numberOfFloor;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false, referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false, referencedColumnName = "rent_type_id")
    private RentType rentType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contract;

    private Boolean status;

    public Service() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getMaxOfPeople() {
        return maxOfPeople;
    }

    public void setMaxOfPeople(String maxOfPeople) {
        this.maxOfPeople = maxOfPeople;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }
}
