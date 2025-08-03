package com.feedback.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedback.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
	
	Optional<CustomerEntity> findByMobileNo(String mobileNo);
	Optional<CustomerEntity> findByEmail(String email);

	
}
