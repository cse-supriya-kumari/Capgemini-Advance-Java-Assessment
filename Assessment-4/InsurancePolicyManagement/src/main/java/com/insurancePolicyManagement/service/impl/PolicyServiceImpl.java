package com.insurancePolicyManagement.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.insurancePolicyManagement.repository.PolicyRepository;
import com.insurancePolicyManagement.repository.CustomerRepository;
import com.insurancePolicyManagement.entity.Policy;
import com.insurancePolicyManagement.entity.Customer;

import com.insurancePolicyManagement.mapper.PolicyMapper;
import com.insurancePolicyManagement.dto.request.PolicyRequestDTO;
import com.insurancePolicyManagement.dto.response.PolicyResponseDTO;

import com.insurancePolicyManagement.service.PolicyService;

import com.insurancePolicyManagement.exception.PolicyNotFoundException;
import com.insurancePolicyManagement.exception.CustomerNotFoundException;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        Policy policy = new Policy();

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setStatus("ACTIVE");
        policy.setCustomer(customer);

        Policy savedPolicy = policyRepository.save(policy);

        return PolicyMapper.toDTO(savedPolicy);
    }

    @Override
    public PolicyResponseDTO getPolicyById(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        return PolicyMapper.toDTO(policy);
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByType(String type) {

        List<Policy> policies = policyRepository.findByPolicyType(type);

        return policies.stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max) {

        List<Policy> policies = policyRepository.findByPremiumAmountBetween(min, max);

        return policies.stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelPolicy(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setStatus("CANCELLED");

        policyRepository.save(policy);
    }
    @Override
    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        Policy updatedPolicy = policyRepository.save(policy);

        return PolicyMapper.toDTO(updatedPolicy);
    }
    @Override
    public Page<PolicyResponseDTO> getAllPolicies(
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Policy> policies = policyRepository.findAll(pageable);

        return policies.map(PolicyMapper::toDTO);
    }
    
}
