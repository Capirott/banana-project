package com.erick.oobj.api.repository.query;

import org.springframework.data.repository.NoRepositoryBean;

import com.erick.oobj.api.model.Transaction;
import com.erick.oobj.api.repository.SoninhoSearchRepository;
import com.erick.oobj.api.repository.filter.TransactionFilter;

@NoRepositoryBean
public interface TransactionRepositoryQuery extends SoninhoSearchRepository<Transaction,TransactionFilter> {
	
}
