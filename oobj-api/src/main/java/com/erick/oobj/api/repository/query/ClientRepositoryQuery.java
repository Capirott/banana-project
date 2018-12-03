package com.erick.oobj.api.repository.query;

import org.springframework.data.repository.NoRepositoryBean;

import com.erick.oobj.api.model.Client;
import com.erick.oobj.api.repository.SoninhoSearchRepository;
import com.erick.oobj.api.repository.filter.ClientFilter;

@NoRepositoryBean
public interface ClientRepositoryQuery extends SoninhoSearchRepository<Client, ClientFilter> {
	
}
