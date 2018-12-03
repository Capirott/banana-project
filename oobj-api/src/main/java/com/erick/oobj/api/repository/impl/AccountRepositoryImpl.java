package com.erick.oobj.api.repository.impl;

import java.util.List;

import org.springframework.util.StringUtils;

import com.erick.oobj.api.model.Account;
import com.erick.oobj.api.repository.filter.AccountFilter;
import com.erick.oobj.api.repository.query.AccountRepositoryQuery;

public class AccountRepositoryImpl extends SoninhoRepositoryImpl<Account, AccountFilter>
		implements AccountRepositoryQuery {
	@Override
	
	public List<Account> findAll(AccountFilter filter) {
		StringBuilder hql = new StringBuilder();

		hql.append("select \n");
		hql.append("	new Account (\n");
		hql.append("				ac.id, \n");
		hql.append("				ac.accountType, \n");
		hql.append("				ac.agency, \n");
		hql.append("				ac.client \n");
		hql.append("		     ) \n");
		hql.append("	from Account ac WHERE 1 = 1 \n");

		if (!StringUtils.isEmpty(filter.getClientName())) {
			hql.append("AND lower(ac.client.name) like '%").append(filter.getClientName().toLowerCase()).append("%'");
		}

		return getEntityManager().createQuery(hql.toString(), Account.class).getResultList();
	}

}
