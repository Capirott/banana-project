package com.erick.oobj.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.oobj.api.exception.BusinessException;
import com.erick.oobj.api.model.Account;
import com.erick.oobj.api.model.Agency;
import com.erick.oobj.api.model.Client;
import com.erick.oobj.api.repository.AccountRepository;
import com.erick.oobj.api.repository.SoninhoRepository;
import com.erick.oobj.api.repository.filter.AccountFilter;

@Service
public class AccountService extends SoninhoServiceImpl<Account, Long, AccountFilter> {

	private static final String CLIENT_NOT_FOUND = "client.not-found";

	private static final String AGENCY_NOT_FOUND = "agency.not-found";

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AgencyService agencyService;

	@Autowired
	private ClientService clientService;

	@Override
	protected SoninhoRepository<Account, Long, AccountFilter> getRepository() {

		return accountRepository;
	}

	@Override
	public void validate(Account entity) {

		Optional.ofNullable(entity).map(Account::getAgency).map(Agency::getId).flatMap(agencyService::findById)
				.orElseThrow(() -> new BusinessException(AGENCY_NOT_FOUND));

		Optional.ofNullable(entity).map(Account::getClient).map(Client::getId).flatMap(clientService::findById)
				.orElseThrow(() -> new BusinessException(CLIENT_NOT_FOUND));

	}

	@Override
	public List<Account> filter(AccountFilter filter) {
		return accountRepository.findAll(filter);
	}
}
