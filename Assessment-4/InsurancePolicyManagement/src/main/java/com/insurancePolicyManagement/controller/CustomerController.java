package com.insurancePolicyManagement.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.insurancePolicyManagement.service.CustomerService;
import com.insurancePolicyManagement.dto.request.CustomerRequestDTO;
import com.insurancePolicyManagement.dto.response.CustomerResponseDTO;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO dto){
        return service.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable Long id){
        return service.getCustomerById(id);
    }
}