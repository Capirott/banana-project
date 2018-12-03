package com.erick.oobj.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.repository.filter.SoninhoFilter;
import com.erick.oobj.api.service.AgencyService;
import com.erick.oobj.api.service.SoninhoService;

@RestController
@RequestMapping("/agencies")
public class AgencyResource extends SoninhoResource<Agency, Long, SoninhoFilter> {

	@Autowired
	private AgencyService serviceRepository;

	@Override
	protected SoninhoService<Agency, Long, SoninhoFilter> getService() {
		return serviceRepository;
	}

}
