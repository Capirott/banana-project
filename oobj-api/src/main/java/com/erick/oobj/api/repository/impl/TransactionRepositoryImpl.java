package com.erick.oobj.api.repository.impl;

import java.util.List;

import com.erick.oobj.api.model.Transaction;
import com.erick.oobj.api.repository.SoninhoSearchRepository;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

public class TransactionRepositoryImpl extends SoninhoRepositoryImpl<Transaction, SoninhoFilter> implements SoninhoSearchRepository<Transaction, SoninhoFilter>  {

	@Override
	public List<Transaction> findAll(SoninhoFilter filter) {
		return null;
	}

}
