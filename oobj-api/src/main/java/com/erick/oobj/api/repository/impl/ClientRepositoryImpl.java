package com.erick.oobj.api.repository.impl;

import java.util.List;

import org.springframework.util.StringUtils;

import com.erick.oobj.api.model.Client;
import com.erick.oobj.api.repository.filter.ClientFilter;
import com.erick.oobj.api.repository.query.ClientRepositoryQuery;

public class ClientRepositoryImpl extends SoninhoRepositoryImpl<Client, ClientFilter> implements ClientRepositoryQuery {

	@Override
	public List<Client> findAll(ClientFilter filter) {
	
		StringBuilder hql = new StringBuilder();
		
		hql.append("select \n");
		hql.append("	new Client (\n");
		hql.append("				cl.id, \n");
		hql.append("				cl.name, \n");
		hql.append("				cl.address, \n");
		hql.append("				cl.phoneNumber, \n");
		hql.append("				cl.cpf \n");
		hql.append("		     ) \n");
		hql.append("	from Client cl WHERE 1 = 1 \n");
		
		if (!StringUtils.isEmpty(filter.getName())) {
			hql.append("AND lower(cl.name) like '%").append(filter.getName().toLowerCase()).append("%'");
		}
		
		if (!StringUtils.isEmpty(filter.getCpf())) {
			hql.append("AND cl.cpf like '%").append(filter.getCpf()).append("%'");
		}
		
		return getEntityManager().createQuery(hql.toString(), Client.class).getResultList();
	}

}
