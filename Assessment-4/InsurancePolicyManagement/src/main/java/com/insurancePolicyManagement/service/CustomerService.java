package com.insurancePolicyManagement.service;


import java.util.List;
import com.insurancePolicyManagement.dto.request.CustomerRequestDTO;
import com.insurancePolicyManagement.dto.response.CustomerResponseDTO;

public interface CustomerService {

    CustomerResponseDTO createCustomer(CustomerRequestDTO dto);

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO getCustomerById(Long id);
}
