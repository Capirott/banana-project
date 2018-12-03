package com.erick.oobj.api.repository.filter;

public class TransactionFilter extends SoninhoFilter {

	private String transactionType;

	private String accountOwnerName;
	
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getAccountOwnerName() {
		return accountOwnerName;
	}

	public void setAccountOwnerName(String accountOwnerName) {
		this.accountOwnerName = accountOwnerName;
	}

}
