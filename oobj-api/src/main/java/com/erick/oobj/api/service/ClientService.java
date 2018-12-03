package com.erick.oobj.api.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.oobj.api.model.Address;
import com.erick.oobj.api.model.Client;
import com.erick.oobj.api.repository.ClientRepository;
import com.erick.oobj.api.repository.SoninhoRepository;
import com.erick.oobj.api.repository.filter.ClientFilter;

@Service
public class ClientService extends SoninhoServiceImpl<Client, Long, ClientFilter> {

	@Autowired
	private ClientRepository clientRepository;

	public void update(Long id, @Valid Address address) {
		Client entity = findOrThrowException(id);
		BeanUtils.copyProperties(address, entity.getAddress(), IGNORED_PROPERTY_ID);
		clientRepository.save(entity);
	}

	@Override
	protected SoninhoRepository<Client, Long, ClientFilter> getRepository() {
		return clientRepository;
	}

}
