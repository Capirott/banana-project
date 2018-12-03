package com.erick.oobj.api.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;

import com.erick.oobj.api.model.Transaction;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

public interface TransactionRepository extends SoninhoRepository<Transaction, Long, SoninhoFilter> {

	@Query("select sum(t.amount) from Transaction t where t.account.id = ?1")
	BigDecimal getAccountBalanceById(Long id);

}
