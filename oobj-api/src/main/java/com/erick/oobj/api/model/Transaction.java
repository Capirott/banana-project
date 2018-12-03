package com.erick.oobj.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "TRANSACTION")
public class Transaction extends SoninhoEntity {
	
	@Column (precision = 2, nullable = false)
	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID", nullable = false, updatable = false)
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "SOURCE_ACCOUNT_ID", nullable = true, updatable = false)
	private Account sourceAccount;

	@ManyToOne
	@JoinColumn(name = "DESTINATION_ACCOUNT_ID", nullable = true, updatable = false)
	private Account accountDestination;
	
	@Column(name = "TRANSACTION_TYPE", nullable = false, length = 20)
	@Enumerated (EnumType.STRING)
	private TransactionType transactionType;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Account getAccountDestination() {
		return accountDestination;
	}

	public void setAccountDestination(Account accountDestination) {
		this.accountDestination = accountDestination;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	
	
}
