package com.erick.oobj.api.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.oobj.api.exception.BusinessException;
import com.erick.oobj.api.model.Transaction;
import com.erick.oobj.api.repository.SoninhoRepository;
import com.erick.oobj.api.repository.TransactionRepository;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

@Service 
public class TransactionService extends SoninhoServiceImpl<Transaction, Long, SoninhoFilter> {

	private static final String TRANSACTION_INSUFFICIENT_BALANCE = "transaction.insufficient-balance";
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	protected SoninhoRepository<Transaction, Long, SoninhoFilter> getRepository() {
		return transactionRepository;
	}

	@Override
	public void validate(Transaction entity) {
		BigDecimal accountBalanceById = getAccountBalanceById(entity.getAccount().getId());
		if (accountBalanceById.add(entity.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
			throw new BusinessException(TRANSACTION_INSUFFICIENT_BALANCE);
		}
		super.validate(entity);
	}
	
	public BigDecimal getAccountBalanceById(Long id)  {
		return transactionRepository.getAccountBalanceById(id);
	}

}
