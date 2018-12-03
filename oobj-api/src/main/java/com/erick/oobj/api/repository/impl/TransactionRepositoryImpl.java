package com.erick.oobj.api.repository.impl;

import java.util.List;

import org.springframework.util.StringUtils;

import com.erick.oobj.api.model.Transaction;
import com.erick.oobj.api.repository.filter.TransactionFilter;
import com.erick.oobj.api.repository.query.TransactionRepositoryQuery;

public class TransactionRepositoryImpl extends SoninhoRepositoryImpl<Transaction, TransactionFilter>
		implements TransactionRepositoryQuery {

	@Override
	public List<Transaction> findAll(TransactionFilter filter) {
		StringBuilder hql = new StringBuilder();

		hql.append("select \n");
		hql.append("	new Transaction (\n");
		hql.append("				t.id, \n");
		hql.append("				t.amount, \n");
		hql.append("				t.account, \n");
		hql.append("				ac, \n");
		hql.append("				ad, \n");
		hql.append("				t.transactionType \n");
		hql.append("		     ) \n");
		hql.append("	from Transaction t \n");
		hql.append("	left join t.sourceAccount ac \n");
		hql.append("	left join t.accountDestination ad WHERE 1 = 1 \n");

		if (!StringUtils.isEmpty(filter.getTransactionType())) {
			hql.append("AND lower(t.transactionType) like '%").append(filter.getTransactionType().toLowerCase()).append("%'");
		}
		
		if (!StringUtils.isEmpty(filter.getAccountOwnerName())) {
			hql.append("AND lower(t.account.client.name) like '%").append(filter.getAccountOwnerName().toLowerCase()).append("%'");
		}

		return getEntityManager().createQuery(hql.toString(), Transaction.class).getResultList();
	}

}
