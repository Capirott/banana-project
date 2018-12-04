package com.erick.oobj.api.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.erick.oobj.api.model.Client;
import com.erick.oobj.api.repository.filter.ClientFilter;
import com.erick.oobj.api.repository.query.ClientRepositoryQuery;

public class ClientRepositoryImpl extends SoninhoRepositoryImpl<Client, ClientFilter> implements ClientRepositoryQuery {

	@Override
	public Page<Client> findAll(ClientFilter filter, Pageable pageable) {
	
		StringBuilder hql = new StringBuilder();
		StringBuilder from = new StringBuilder();
		hql.append("select \n");
		hql.append("	new Client (\n");
		hql.append("				cl.id, \n");
		hql.append("				cl.name, \n");
		hql.append("				cl.address, \n");
		hql.append("				cl.phoneNumber, \n");
		hql.append("				cl.cpf \n");
		hql.append("		     ) \n");
		from.append("	from Client cl WHERE 1 = 1 \n");
		
		if (!StringUtils.isEmpty(filter.getName())) {
			from.append("AND lower(cl.name) like '%").append(filter.getName().toLowerCase()).append("%'");
		}
		
		if (!StringUtils.isEmpty(filter.getCpf())) {
			from.append("AND cl.cpf like '%").append(filter.getCpf()).append("%'");
		}
		hql.append(from);		
		TypedQuery<Client> createQuery = getEntityManager().createQuery(hql.toString(), Client.class);
		addQueryPageableConditions(createQuery, pageable);
		List<Client> resultList = createQuery.getResultList();
		return new PageImpl<>(resultList, pageable, getTotal(from));
	}

}
