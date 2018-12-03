package com.erick.oobj.api.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLIENT")
public class Client extends SoninhoEntity {

	@NotNull
	@Size(min = 3, max = 50)
	private String name;

	@Column(length = 11, nullable = false)
	private String cpf;

	@Column(length = 10, nullable = false)
	private String phoneNumber;

	@NotNull
	@Embedded
	private Address address;

	public Client() {
	}

	public Client(String name, String cpf, String phoneNumber,Address address) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Client(Long id, String name, Address address, String phoneNumber, String cpf) {
		super();
		this.setId(id);
		this.name = name;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
