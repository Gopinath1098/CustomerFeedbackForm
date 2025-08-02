package com.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedback.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
