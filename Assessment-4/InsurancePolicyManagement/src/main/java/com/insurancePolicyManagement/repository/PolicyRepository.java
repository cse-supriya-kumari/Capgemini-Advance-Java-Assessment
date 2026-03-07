package com.insurancePolicyManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.insurancePolicyManagement.entity.Policy;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface PolicyRepository extends JpaRepository<Policy,Long>{

    List<Policy> findByPolicyType(String policyType);

    List<Policy> findByCustomerId(Long customerId);

    List<Policy> findByPremiumAmountBetween(double min,double max);

    @Query("SELECT p FROM Policy p WHERE p.customer.email = :email")
    List<Policy> findPoliciesByCustomerEmail(String email);
}
