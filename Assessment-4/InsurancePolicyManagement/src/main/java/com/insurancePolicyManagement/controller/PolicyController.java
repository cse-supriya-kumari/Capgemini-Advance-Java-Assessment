package com.insurancePolicyManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurancePolicyManagement.dto.request.PolicyRequestDTO;
import com.insurancePolicyManagement.dto.response.PolicyResponseDTO;
import com.insurancePolicyManagement.service.PolicyService;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

	@Autowired
	private PolicyService service;

	@PostMapping
	public PolicyResponseDTO createPolicy(@RequestBody PolicyRequestDTO dto) {
		return service.createPolicy(dto);
	}
	@GetMapping
	public Page<PolicyResponseDTO> getAllPolicies(
	        @RequestParam(defaultValue="0") int page,
	        @RequestParam(defaultValue="5") int size,
	        @RequestParam(defaultValue="premiumAmount") String sortBy,
	        @RequestParam(defaultValue="asc") String direction){

	    return service.getAllPolicies(page,size,sortBy,direction);
	}

	@GetMapping("/{id}")
	public PolicyResponseDTO getPolicy(@PathVariable Long id) {
		return service.getPolicyById(id);
	}
	@PutMapping("/{id}")
	public PolicyResponseDTO updatePolicy(
	        @PathVariable Long id,
	        @RequestBody PolicyRequestDTO dto){

	    return service.updatePolicy(id, dto);
	}

	@GetMapping("/type/{type}")
	public List<PolicyResponseDTO> getByType(@PathVariable String type) {
		return service.getPoliciesByType(type);
	}

	@GetMapping("/premium")
	public List<PolicyResponseDTO> getByPremiumRange(@RequestParam double min, @RequestParam double max) {
		return service.getPoliciesByPremiumRange(min, max);
	}

	@DeleteMapping("/{id}")
	public void cancelPolicy(@PathVariable Long id) {
		service.cancelPolicy(id);
	}
}