package com.erick.oobj.api.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.erick.oobj.api.model.Transaction;
import com.erick.oobj.api.repository.filter.TransactionFilter;
import com.erick.oobj.api.repository.query.TransactionRepositoryQuery;

public class TransactionRepositoryImpl extends SoninhoRepositoryImpl<Transaction, TransactionFilter>
		implements TransactionRepositoryQuery {

	@Override
	public Page<Transaction> findAll(TransactionFilter filter, Pageable pageable) {
		StringBuilder hql = new StringBuilder();
		StringBuilder from = new StringBuilder();

		hql.append("select \n");
		hql.append("	new Transaction (\n");
		hql.append("				t.id, \n");
		hql.append("				t.amount, \n");
		hql.append("				t.account, \n");
		hql.append("				ac, \n");
		hql.append("				ad, \n");
		hql.append("				t.transactionType \n");
		hql.append("		     ) \n");
		from.append("	from Transaction t \n");
		from.append("	left join t.sourceAccount ac \n");
		from.append("	left join t.accountDestination ad WHERE 1 = 1 \n");

		if (!StringUtils.isEmpty(filter.getTransactionType())) {
			from.append("AND lower(t.transactionType) like '%").append(filter.getTransactionType().toLowerCase()).append("%'");
		}
		
		if (!StringUtils.isEmpty(filter.getAccountOwnerName())) {
			from.append("AND lower(t.account.client.name) like '%").append(filter.getAccountOwnerName().toLowerCase()).append("%'");
		}

		hql.append(from);		
		
		TypedQuery<Transaction> createQuery = getEntityManager().createQuery(hql.toString(), Transaction.class);
		addQueryPageableConditions(createQuery, pageable);
		List<Transaction> resultList = createQuery.getResultList();
		return new PageImpl<>(resultList, pageable, getTotal(from));
	}

}
