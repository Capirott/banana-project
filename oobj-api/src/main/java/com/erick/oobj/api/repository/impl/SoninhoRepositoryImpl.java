package com.erick.oobj.api.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
}
