package com.erick.oobj.api.repository.impl;

import java.util.List;

import org.springframework.util.StringUtils;

import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.repository.filter.AgencyFilter;
import com.erick.oobj.api.repository.query.AgencyRepositoryQuery;

public class AgencyRepositoryImpl extends SoninhoRepositoryImpl<Agency, AgencyFilter> implements AgencyRepositoryQuery {

	@Override
	public List<Agency> findAll(AgencyFilter filter) {

		StringBuilder hql = new StringBuilder();
		
		hql.append("select \n");
		hql.append("	new Agency (\n");
		hql.append("				ag.id, \n");
		hql.append("				ag.address, \n");
		hql.append("				ag.name \n");
		hql.append("		     ) \n");
		hql.append("	from Agency ag WHERE 1 = 1 \n");
		
		if (!StringUtils.isEmpty(filter.getName())) {
			hql.append("AND lower(ag.name) like '%").append(filter.getName().toLowerCase()).append("%'");
		}
		
		return getEntityManager().createQuery(hql.toString(), Agency.class).getResultList();
	}

	
}
