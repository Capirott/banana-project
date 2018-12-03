package com.erick.oobj.api.repository.impl;

import java.util.List;

import com.erick.oobj.api.model.Account;
import com.erick.oobj.api.repository.SoninhoSearchRepository;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

public class AccountRepositoryImpl extends SoninhoRepositoryImpl<Account, SoninhoFilter> implements SoninhoSearchRepository<Account, SoninhoFilter> {
	@Override
	public List<Account> findAll(SoninhoFilter filter) {
		return null;
	}

}
