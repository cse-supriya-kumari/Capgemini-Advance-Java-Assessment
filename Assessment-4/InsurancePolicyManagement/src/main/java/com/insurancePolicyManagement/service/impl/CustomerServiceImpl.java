package com.insurancePolicyManagement.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.insurancePolicyManagement.repository.CustomerRepository;
import com.insurancePolicyManagement.entity.Customer;
import com.insurancePolicyManagement.mapper.CustomerMapper;
import com.insurancePolicyManagement.dto.request.CustomerRequestDTO;
import com.insurancePolicyManagement.dto.response.CustomerResponseDTO;
import com.insurancePolicyManagement.service.CustomerService;
import com.insurancePolicyManagement.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {

        Customer customer = CustomerMapper.toEntity(dto);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerMapper.toDTO(savedCustomer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        return CustomerMapper.toDTO(customer);
    }
}