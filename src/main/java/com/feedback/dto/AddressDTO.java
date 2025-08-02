package com.feedback.dto;

public class AddressDTO {

	private Long id;
	private String doorNo;
	private String Street;
	private String city;
	private String state;
	private String Country;
	
	public AddressDTO(Long id, String doorNo, String street, String city, String state, String country) {
		super();
		this.id = id;
		this.doorNo = doorNo;
		Street = street;
		this.city = city;
		this.state = state;
		Country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
	
}
