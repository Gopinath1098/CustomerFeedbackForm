package com.feedback.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity {
	
	@Id
	private String custId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String nationality;
	private String gender;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String mobileNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	public AddressEntity address;
	@NotNull
	private String Message;
	
	@PrePersist
	public void generateCustomId() {
        if (this.custId == null) 
            this.custId = "cust-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        }

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "CustomerEntity [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", nationality=" + nationality + ", gender=" + gender + ", email=" + email + ", mobileNo="
				+ mobileNo + ", address=" + address + ", Message=" + Message + "]";
	}	
	
	
	
}
