package com.erick.oobj.api.repository;

import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

public interface AgencyRepository extends SoninhoRepository<Agency, Long, SoninhoFilter> {
	
}
