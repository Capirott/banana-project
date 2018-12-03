package com.erick.oobj.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;

import com.erick.oobj.api.model.SoninhoEntity;
import com.erick.oobj.api.repository.SoninhoRepository;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

public abstract class SoninhoServiceImpl<B extends SoninhoEntity, T, F extends SoninhoFilter> implements SoninhoService<B, T, F> {

	protected static final String IGNORED_PROPERTY_ID = "id";

	protected static final int EXPECTED_SIZE = 1;

	protected abstract SoninhoRepository<B, T, F> getRepository();

	@Override
	public B update(T id, B model) {
		validate(model);
		B entity = findOrThrowException(id);
		BeanUtils.copyProperties(model, entity, IGNORED_PROPERTY_ID);
		return this.save(entity);
	}

	protected B findOrThrowException(T id) {
		return this.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(EXPECTED_SIZE));
	}

	@Override
	public Optional<B> findById(T id) {
		return getRepository().findById(id);
	}

	@Override
	public List<B> findAll() {
		return getRepository().findAll();
	}

	@Override
	public B save(B entity) {
		validate(entity);
		return getRepository().save(entity);
	}

	@Override
	public void deleteById(T id) {
		getRepository().deleteById(id);
	}

	@Override
	public void validate(B entity) {

	}
	
	@Override
	public List<B> filter(F filter) {
		return getRepository().findAll(filter);
	}
	
}
