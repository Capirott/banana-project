package com.erick.oobj.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.erick.oobj.api.model.SoninhoEntity;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

public interface SoninhoService<B extends SoninhoEntity, T, F extends SoninhoFilter> {

	Optional<B> findById(T id);

	List<B> findAll();

	B update(T id, B model);

	void deleteById(T id);

	B save(B entity);
	
	void validate(B entity);
	
	Page<B> filter(F filter, Pageable pageable);
	
}
