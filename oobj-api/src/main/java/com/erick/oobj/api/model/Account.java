package com.erick.oobj.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ACCOUNT", uniqueConstraints={
	    @UniqueConstraint(columnNames = {"ACCOUNT_TYPE", "CLIENT_ID"})
	})
public class Account extends SoninhoEntity {

	@Column(name = "ACCOUNT_TYPE", nullable = false, length = 10)
	@Enumerated (EnumType.STRING)	
	private AccountType accountType;

	@ManyToOne
	@JoinColumn(name = "AGENCY_ID", nullable = false, updatable = false)
	private Agency agency;
	
	@ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false, updatable = false)
	private Client client;

	public AccountType getAccountType() {
		return accountType;
	}

	@OneToMany
	private List<Transaction> transactions;

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}


	public Agency getAgency() {
		return agency;
	}


	public void setAgency(Agency agency) {
		this.agency = agency;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
}
