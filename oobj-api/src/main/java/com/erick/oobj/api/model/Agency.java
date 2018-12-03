package com.erick.oobj.api.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AGENCY")
public class Agency extends SoninhoEntity {

	@NotNull
	@Embedded
	private Address address;

	@NotNull
	@Size(min = 3, max = 50)
	private String name;

	public Agency () {}
	
	public Agency(@NotNull Address address, @NotNull @Size(min = 3, max = 50) String name) {
		super();
		this.address = address;
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

}
