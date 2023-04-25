package com.example.final_exam.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="sale")
public class SaleInformation implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temp_id")
    private Integer id;

    @NotEmpty(message = "Title can't be empty.")
    @Pattern(regexp = "^[A-Z][a-z]*(\\ [A-Z][a-z]*)*$",message = "Invalid format (Abc Abc).")
    private String title;

    private String startDate;

    private String endDate;

    @NotEmpty(message = "Discount can't be empty")
    private String discount;

    private String description;

    public SaleInformation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SaleInformation.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SaleInformation saleInformation = (SaleInformation) target;
        try{
            if(Integer.parseInt(saleInformation.getDiscount()) < 10000){
                errors.rejectValue("discount","invalid");
            }
        }catch (Exception e){
            errors.rejectValue("discount", "number.format");
        }

//        String startDate = saleInformation.getStartDate();
//        String endDate = saleInformation.getStartDate();
//        String[] st = startDate.split("-");
//        String[] ed = endDate.split("-");
//
    }
}
