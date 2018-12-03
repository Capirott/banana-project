package com.erick.oobj.api.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Address {

	@NotNull
	@Size(min = 3, max = 50)
	private String street;

	@NotNull
	@Size(min = 3, max = 50)
	private String city;

	@NotNull
	@Size(min = 3, max = 50)
	private String state;

	@NotNull
	@Size(min = 3, max = 10)
	private String zipcode;

	public Address() {}
	
	public Address(@NotNull @Size(min = 3, max = 50) String street,
			@NotNull @Size(min = 3, max = 50) String city, @NotNull @Size(min = 3, max = 50) String state,
			@NotNull @Size(min = 3, max = 10) String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
