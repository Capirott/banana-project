package com.erick.oobj.api.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.erick.oobj.api.model.Account;
import com.erick.oobj.api.repository.filter.AccountFilter;
import com.erick.oobj.api.repository.query.AccountRepositoryQuery;

public class AccountRepositoryImpl extends SoninhoRepositoryImpl<Account, AccountFilter>
		implements AccountRepositoryQuery {

	@Override
	public Page<Account> findAll(AccountFilter filter, Pageable pageable) {
		StringBuilder hql = new StringBuilder();
		StringBuilder from = new StringBuilder();

		hql.append("select \n");
		hql.append("	new Account (\n");
		hql.append("				ac.id, \n");
		hql.append("				ac.accountType, \n");
		hql.append("				ac.agency, \n");
		hql.append("				ac.client \n");
		hql.append("		     ) \n");
		from.append("	from Account ac WHERE 1 = 1 \n");

		if (!StringUtils.isEmpty(filter.getClientName())) {
			from.append("AND lower(ac.client.name) like '%").append(filter.getClientName().toLowerCase()).append("%'");
		}
		hql.append(from);		
		TypedQuery<Account> createQuery = getEntityManager().createQuery(hql.toString(), Account.class);
		addQueryPageableConditions(createQuery, pageable);
		List<Account> resultList = createQuery.getResultList();
		return new PageImpl<>(resultList, pageable, getTotal(from));
	}

}
