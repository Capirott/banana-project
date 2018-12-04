package com.erick.oobj.api.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.repository.filter.AgencyFilter;
import com.erick.oobj.api.repository.query.AgencyRepositoryQuery;

public class AgencyRepositoryImpl extends SoninhoRepositoryImpl<Agency, AgencyFilter> implements AgencyRepositoryQuery {

	@Override
	public Page<Agency> findAll(AgencyFilter filter, Pageable pageable) {

		StringBuilder hql = new StringBuilder();
		StringBuilder from = new StringBuilder();
		
		hql.append("select \n");
		hql.append("	new Agency (\n");
		hql.append("				ag.id, \n");
		hql.append("				ag.address, \n");
		hql.append("				ag.name \n");
		hql.append("		     ) \n");
		from.append("	from Agency ag WHERE 1 = 1 \n");
		
		if (!StringUtils.isEmpty(filter.getName())) {
			from.append("AND lower(ag.name) like '%").append(filter.getName().toLowerCase()).append("%'");
		}
		hql.append(from);		

		TypedQuery<Agency> createQuery = getEntityManager().createQuery(hql.toString(), Agency.class);
		addQueryPageableConditions(createQuery, pageable);
		List<Agency> resultList = createQuery.getResultList();
		return new PageImpl<>(resultList, pageable, getTotal(from));
	}

	
}
