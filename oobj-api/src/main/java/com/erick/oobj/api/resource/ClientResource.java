package com.erick.oobj.api.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.erick.oobj.api.model.Address;
import com.erick.oobj.api.model.Client;
import com.erick.oobj.api.repository.filter.ClientFilter;
import com.erick.oobj.api.service.ClientService;
import com.erick.oobj.api.service.SoninhoService;

@RestController
@RequestMapping("/clients")
public class ClientResource extends SoninhoResource<Client, Long, ClientFilter> {

	@Autowired
	private ClientService clientService;

	@Override
	protected SoninhoService<Client, Long, ClientFilter> getService() {
		return clientService;
	}

	@PutMapping("/{id}/address")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @Valid @RequestBody Address address) {

		clientService.update(id, address);
	}
	
}
