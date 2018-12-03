package com.erick.oobj.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.repository.AgencyRepository;
import com.erick.oobj.api.repository.SoninhoRepository;
import com.erick.oobj.api.repository.filter.AgencyFilter;

@Service
public class AgencyService extends SoninhoServiceImpl<Agency, Long, AgencyFilter> {

	@Autowired
	private AgencyRepository agencyRepository;

	@Override
	
	protected SoninhoRepository<Agency, Long, AgencyFilter> getRepository() {
		return agencyRepository;
	}
	
}
