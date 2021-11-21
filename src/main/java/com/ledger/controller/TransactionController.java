package com.ledger.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ledger.model.TransactionEntity;
import com.ledger.repository.TransactionRepository;

@RestController
@RequestMapping("/api/v1/")	
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@PostMapping("transaction")
	public TransactionEntity createTransaction(@RequestBody TransactionEntity transactionEntity) {
		return this.transactionRepository.save(transactionEntity);
	}
	
	@GetMapping("transaction/{date}/{accountNumber}")
	public List<TransactionEntity> findAllByDate(@PathVariable(value = "date") Date date, @PathVariable(value = "accountNumber") String accountNumber){
		
		//need to implement
		return null;
	}
	
	@GetMapping("transaction/balance/{ledgerId}")
	public double checkBalanace(@PathVariable(value = "ledgerId") long ledgerId) {
		
		// need to implement
		return 0.0;
	}
}
