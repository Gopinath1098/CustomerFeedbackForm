package com.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.entity.CustomerEntity;
import com.feedback.service.CustomerService;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	CustomerService custServ;
	
	@GetMapping("get")
	public ResponseEntity<?> get(){
		return new ResponseEntity<String>("GetMapping", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("allCustomer")
	public ResponseEntity<List<CustomerEntity>> getCustomerList(){
		return new ResponseEntity<List<CustomerEntity>>(custServ.getAllCustomer(), HttpStatus.ACCEPTED);
	}
	
}
