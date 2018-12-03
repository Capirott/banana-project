package com.erick.oobj.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick.oobj.api.model.Account;
import com.erick.oobj.api.repository.filter.SoninhoFilter;
import com.erick.oobj.api.service.AccountService;
import com.erick.oobj.api.service.SoninhoService;

@RestController
@RequestMapping("/accounts")
public class AccountResource extends SoninhoResource<Account, Long, SoninhoFilter> {

	@Autowired
	private AccountService accountService;

	@Override
	protected SoninhoService<Account, Long, SoninhoFilter> getService() {
		return accountService;
	}

}
