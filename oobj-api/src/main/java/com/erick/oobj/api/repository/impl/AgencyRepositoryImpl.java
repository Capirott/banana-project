package com.erick.oobj.api.repository.impl;

import java.util.List;

import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.repository.SoninhoSearchRepository;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

public class AgencyRepositoryImpl extends SoninhoRepositoryImpl<Agency, SoninhoFilter> implements SoninhoSearchRepository<Agency, SoninhoFilter> {

	@Override
	public List<Agency> findAll(SoninhoFilter filter) {
		return null;
	}

	
}
