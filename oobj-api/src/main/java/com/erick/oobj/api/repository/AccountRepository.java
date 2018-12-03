package com.erick.oobj.api.repository;

import com.erick.oobj.api.model.Account;
import com.erick.oobj.api.repository.filter.SoninhoFilter;

public interface AccountRepository extends SoninhoRepository<Account, Long, SoninhoFilter>  {

}
