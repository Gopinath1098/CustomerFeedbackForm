package com.feedback.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.entity.CustomerEntity;
import com.feedback.exception.CustomerDetailsNotValidException;
import com.feedback.exception.ErrorResponse;
import com.feedback.service.CustomerService;

@RestController
@CrossOrigin("http://localhost:7000")
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	CustomerService custServ;
	
	@GetMapping("allCustomer")
	public ResponseEntity<List<CustomerEntity>> getCustomerList(){
		return new ResponseEntity<>(custServ.getAllCustomer(), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("addCustomer")
	public ResponseEntity<Map<String, String>> addCustomer(@RequestBody CustomerEntity customer) {
		Map<String, String> response = new HashMap<>();
		response.put("message", custServ.addCustomer(customer));
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	
}
