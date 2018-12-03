package com.erick.oobj.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erick.oobj.api.model.Transaction;
import com.erick.oobj.api.repository.filter.TransactionFilter;
import com.erick.oobj.api.service.SoninhoService;
import com.erick.oobj.api.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends SoninhoResource<Transaction, Long, TransactionFilter> {

	@Autowired
	private TransactionService transactionService;
	
	@Override
	protected SoninhoService<Transaction, Long, TransactionFilter> getService() {
		return transactionService;
	}

}
