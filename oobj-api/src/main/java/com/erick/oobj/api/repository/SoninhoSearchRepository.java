package com.erick.oobj.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import com.erick.oobj.api.model.SoninhoEntity;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

@NoRepositoryBean
public interface SoninhoSearchRepository<B extends SoninhoEntity, T extends SoninhoFilter> {
	Page<B> findAll(T filter, Pageable pageable); 
}
