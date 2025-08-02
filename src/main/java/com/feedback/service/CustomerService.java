package com.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.entity.CustomerEntity;
import com.feedback.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	

		public List<CustomerEntity> getAllCustomer() {
			return custRepo.findAll();
			
		}
	
}
