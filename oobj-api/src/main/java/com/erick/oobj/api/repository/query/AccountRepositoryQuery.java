package com.erick.oobj.api.repository.query;

import org.springframework.data.repository.NoRepositoryBean;

import com.erick.oobj.api.model.Account;
import com.erick.oobj.api.repository.SoninhoSearchRepository;
import com.erick.oobj.api.repository.filter.AccountFilter;

@NoRepositoryBean
public interface AccountRepositoryQuery extends SoninhoSearchRepository<Account, AccountFilter> {
	
}
