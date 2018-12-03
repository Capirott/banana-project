package com.erick.oobj.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erick.oobj.api.model.Transaction;
import com.erick.oobj.api.repository.filter.SoninhoFilter;
import com.erick.oobj.api.service.SoninhoService;
import com.erick.oobj.api.service.TransactionService;

@Controller
@RequestMapping("/transactions")
public class TransactionResource extends SoninhoResource<Transaction, Long, SoninhoFilter> {

	@Autowired
	private TransactionService transactionService;
	
	@Override
	protected SoninhoService<Transaction, Long, SoninhoFilter> getService() {
		return transactionService;
	}

}
