package com.insurancePolicyManagement.mapper;


import com.insurancePolicyManagement.dto.response.PolicyResponseDTO;
import com.insurancePolicyManagement.dto.response.CustomerResponseDTO;
import com.insurancePolicyManagement.entity.Policy;

public class PolicyMapper {

    public static PolicyResponseDTO toDTO(Policy policy){

        PolicyResponseDTO dto = new PolicyResponseDTO();

        dto.setId(policy.getId());
        dto.setPolicyNumber(policy.getPolicyNumber());
        dto.setPolicyType(policy.getPolicyType());
        dto.setPremiumAmount(policy.getPremiumAmount());
        dto.setCoverageAmount(policy.getCoverageAmount());
        dto.setStartDate(policy.getStartDate());
        dto.setEndDate(policy.getEndDate());
        dto.setStatus(policy.getStatus());

        CustomerResponseDTO customerDTO = new CustomerResponseDTO();
        customerDTO.setId(policy.getCustomer().getId());
        customerDTO.setName(policy.getCustomer().getName());
        customerDTO.setEmail(policy.getCustomer().getEmail());

        dto.setCustomer(customerDTO);

        return dto;
    }
}