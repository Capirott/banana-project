package com.erick.oobj.api.repository;

import com.erick.oobj.api.model.Client;
import com.erick.oobj.api.repository.filter.ClientFilter;

public interface ClientRepository extends ClientRepositoryQuery, SoninhoRepository<Client, Long, ClientFilter> {

}
