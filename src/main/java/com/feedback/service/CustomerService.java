package com.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dto.AddressDTO;
import com.feedback.dto.CustomerDTO;
import com.feedback.entity.CustomerEntity;
import com.feedback.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	

		public List<CustomerEntity> getAllCustomer() {
			return custRepo.findAll();
			
		}
		
		public String addCustomer(CustomerEntity customer) {
			CustomerDTO custDTO = prepareEntityToDTO(custRepo.saveAndFlush(customer));
			return "Customer with ID : "+custDTO.getCustId()+" Added SuccessFully";
			
		}

		private CustomerDTO prepareEntityToDTO(CustomerEntity customer) {
			AddressDTO addDTO = new AddressDTO(customer.getAddress().getId(),customer.getAddress().getDoorNo(),customer.getAddress().getStreet(),customer.getAddress().getCity(),customer.getAddress().getState(),customer.getAddress().getCountry());
			CustomerDTO custDTO = new CustomerDTO(customer.getCustId(),customer.getFirstName(),customer.getLastName(),customer.getAge(),customer.getNationality()
					,customer.getGender(),customer.getEmail(),customer.getMobileNo(),addDTO);
			return custDTO;
		}
	
}
