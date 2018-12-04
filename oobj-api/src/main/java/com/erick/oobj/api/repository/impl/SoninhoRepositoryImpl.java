package com.erick.oobj.api.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import com.erick.oobj.api.model.SoninhoEntity;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

@NoRepositoryBean
public abstract class SoninhoRepositoryImpl<B extends SoninhoEntity, F extends SoninhoFilter> {

	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	protected Long total(StringBuilder from) {
		return getTotal(from);
	}

	//~ This is not supposed to be here.
	protected Long getTotal(StringBuilder from) {
		StringBuilder count = new StringBuilder("select count(*) ");
		count.append(from);
		Long resultList = (Long) getEntityManager().createQuery(count.toString()).getSingleResult();
		return resultList;
	}
	
	//~ This is not supposed to be here.
	protected void addQueryPageableConditions(TypedQuery<B> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int registeryPerPageTotal = pageable.getPageSize();
		int firstPageRegistery = currentPage * registeryPerPageTotal;
		query.setFirstResult(firstPageRegistery);
		query.setMaxResults(registeryPerPageTotal);
	}
}
