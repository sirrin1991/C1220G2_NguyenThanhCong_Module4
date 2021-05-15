package com.example.demowebservice.controller;

import com.example.demowebservice.model.Customer;
import com.example.demowebservice.model.Province;
import com.example.demowebservice.service.CustomerService;
import com.example.demowebservice.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;


    @GetMapping("/")
    public ResponseEntity<List<Customer>> getHomePage(){
        List<Customer> listCustomer = customerService.findAll();
        if(listCustomer.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listCustomer,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/create-customer")
    public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/create-province")
    public ResponseEntity<Province> addNewProvince(Province province){
        provinceService.saveProvince(province);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list-province")
    public ResponseEntity<List<Province>> getProvinceList(){
        List<Province> list = provinceService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
