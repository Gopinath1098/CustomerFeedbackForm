package com.feedback.dto;

import com.feedback.entity.AddressEntity;


public class CustomerDTO {

	private String custId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String nationality;
	private String gender;
	private String email;
	private String mobileNo;
	private AddressDTO address;
	
	
	
	public CustomerDTO(String custId, String firstName, String lastName, int age, String nationality, String gender,
			String email, String mobileNo, AddressDTO address) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.nationality = nationality;
		this.gender = gender;
		this.email = email;
		this.mobileNo = mobileNo;
		this.address = address;
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
	public void setAge(int age) {
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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	
	
}
