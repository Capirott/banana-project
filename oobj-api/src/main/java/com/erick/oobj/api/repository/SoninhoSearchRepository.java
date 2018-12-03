package com.erick.oobj.api.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import com.erick.oobj.api.model.SoninhoEntity;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

@NoRepositoryBean
public interface SoninhoSearchRepository<B extends SoninhoEntity, T extends SoninhoFilter> {
	List<B> findAll(T filter); 
}
