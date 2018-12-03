package com.erick.oobj.api.repository.query;

import org.springframework.data.repository.NoRepositoryBean;

import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.repository.SoninhoSearchRepository;
import com.erick.oobj.api.repository.filter.AgencyFilter;

@NoRepositoryBean
public interface AgencyRepositoryQuery extends SoninhoSearchRepository<Agency, AgencyFilter> {
	
}
