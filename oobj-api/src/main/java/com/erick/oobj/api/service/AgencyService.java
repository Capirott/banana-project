package com.erick.oobj.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.repository.AgencyRepository;
import com.erick.oobj.api.repository.SoninhoRepository;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

@Service
public class AgencyService extends SoninhoServiceImpl<Agency, Long, SoninhoFilter> {

	@Autowired
	private AgencyRepository agencyRepository;

	@Override
	
	protected SoninhoRepository<Agency, Long, SoninhoFilter> getRepository() {
		return agencyRepository;
	}

	@Override
	public List<Agency> filter(SoninhoFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
