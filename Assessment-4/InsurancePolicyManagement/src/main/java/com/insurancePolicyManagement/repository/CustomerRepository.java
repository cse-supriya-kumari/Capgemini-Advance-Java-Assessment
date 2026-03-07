package com.insurancePolicyManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurancePolicyManagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}