package com.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dto.AddressDTO;
import com.feedback.dto.CustomerDTO;
import com.feedback.entity.AddressEntity;
import com.feedback.entity.CustomerEntity;
import com.feedback.exception.CustomerDetailsNotValidException;
import com.feedback.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	

		public List<CustomerEntity> getAllCustomer() {
			return custRepo.findAll();
			
		}
		
		public String addCustomer(CustomerEntity customer) throws CustomerDetailsNotValidException {
			CustomerDTO custDTO = prepareEntityToDTO(custRepo.saveAndFlush(validateCustomer(customer)));
			return "Customer with ID : "+custDTO.getCustId()+" Added SuccessFully";
			
		}

		private CustomerEntity validateCustomer(CustomerEntity customer) throws CustomerDetailsNotValidException {
			
			System.out.println(customer);
			    if (customer == null) {
			        throw new CustomerDetailsNotValidException("Customer object is null");
			    }

			    if (customer.getFirstName().trim().isEmpty() || customer.getFirstName() == null || !customer.getFirstName().matches("^[A-Za-z]+$")) {
			        throw new CustomerDetailsNotValidException("Invalid first name");
			    }

			    if (customer.getLastName().trim().isEmpty() || customer.getLastName() == null || !customer.getLastName().matches("^[A-Za-z]+$")) {
			        throw new CustomerDetailsNotValidException("Invalid last name");
			    }

			    if (customer.getAge() <= 18 || customer.getAge() >= 80) {
			        throw new CustomerDetailsNotValidException("Age must be between 18 and 80");
			    }

			    if (customer.getGender() == null || 
			        !(customer.getGender().trim().isEmpty() || customer.getGender().equalsIgnoreCase("male") || customer.getGender().equalsIgnoreCase("female"))) {
			        throw new CustomerDetailsNotValidException("Gender must be 'male' or 'female'");
			    }

			    if (customer.getMobileNo().trim().isEmpty() || customer.getMobileNo() == null || !customer.getMobileNo().matches("^[6-9][\\d]{9}$")) {
			        throw new CustomerDetailsNotValidException("Mobile number must be 10 digits & should be an valid starts with 7-9");
			    }
			    
			    if (custRepo.findByMobileNo(customer.getMobileNo()).isPresent()) {
			        throw new CustomerDetailsNotValidException("Customer Feedback Already Received, For New Feedback try With different Mobile Number!");
			    }
			    
			    if(customer.getEmail() == null || 
			    	    customer.getEmail().trim().isEmpty() || 
			    	    !customer.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.(com|in|co)$")) {
			    	throw new CustomerDetailsNotValidException("Please Provide Valid Email id");
			    }
			    
			    if (custRepo.findByEmail(customer.getEmail()).isPresent()) {
			        throw new CustomerDetailsNotValidException("Customer Feedback Already Received, For New Feedback try With different Email Id end with (.com|.in.co)");
			    }

			    if (customer.getNationality().trim().isEmpty() || customer.getNationality() == null || !customer.getNationality().matches("^[A-Za-z]+$")) {
			        throw new CustomerDetailsNotValidException("Invalid nationality");
			    }

			    AddressEntity address = customer.getAddress();
			    System.out.println(customer);
			    if (address == null) {
			        throw new CustomerDetailsNotValidException("Address is missing");
			    }

			    if (address.getCity().trim().isEmpty() || address.getCity() == null || !address.getCity().matches("^[A-Za-z\\s]+$")) {
			        throw new CustomerDetailsNotValidException("Invalid city");
			    }

			    if (address.getCountry().trim().isEmpty() || address.getCountry() == null || !address.getCountry().matches("^[A-Za-z\\s]+$")) {
			        throw new CustomerDetailsNotValidException("Invalid country");
			    }

			    if (address.getDoorNo().trim().isEmpty() || address.getDoorNo() == null || !address.getDoorNo().matches("^[A-Za-z0-9\\s,]+$")) {
			        throw new CustomerDetailsNotValidException("Invalid door number");
			    }

			    if (address.getState().trim().isEmpty() || address.getState() == null || !address.getState().matches("^[A-Za-z\\s]+$")) {
			        throw new CustomerDetailsNotValidException("Invalid state");
			    }

			    if (address.getStreet().trim().isEmpty() || address.getStreet() == null || !address.getStreet().matches("^[A-Za-z\\s,]+$")) {
			        throw new CustomerDetailsNotValidException("Invalid street");
			    }
			    
			    if(customer.getMessage().trim().isEmpty() || customer.getMessage()==null || !customer.getMessage().matches("^.{10,100}$")) {
			    	 throw new CustomerDetailsNotValidException("Please Provide Feedback with 10-100 words");
			    }
			    
			    return customer;
		}

		private CustomerDTO prepareEntityToDTO(CustomerEntity customer) {
			AddressDTO addDTO = new AddressDTO(customer.getAddress().getId(),customer.getAddress().getDoorNo(),customer.getAddress().getStreet(),customer.getAddress().getCity(),customer.getAddress().getState(),customer.getAddress().getCountry());
			CustomerDTO custDTO = new CustomerDTO(customer.getCustId(),customer.getFirstName(),customer.getLastName(),customer.getAge(),customer.getNationality()
					,customer.getGender(),customer.getEmail(),customer.getMobileNo(),addDTO);
			return custDTO;
		}
	
}
