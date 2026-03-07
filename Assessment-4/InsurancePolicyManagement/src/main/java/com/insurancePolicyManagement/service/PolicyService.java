package com.insurancePolicyManagement.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.insurancePolicyManagement.dto.request.PolicyRequestDTO;
import com.insurancePolicyManagement.dto.response.PolicyResponseDTO;

public interface PolicyService {

    PolicyResponseDTO createPolicy(PolicyRequestDTO dto);

    PolicyResponseDTO getPolicyById(Long id);

    List<PolicyResponseDTO> getPoliciesByType(String type);

    List<PolicyResponseDTO> getPoliciesByPremiumRange(double min,double max);

    void cancelPolicy(Long id);
    PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto);
    
    Page<PolicyResponseDTO> getAllPolicies(
            int page,
            int size,
            String sortBy,
            String direction);
}