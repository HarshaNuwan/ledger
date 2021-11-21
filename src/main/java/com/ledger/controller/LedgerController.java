package com.ledger.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ledger.exception.ResourceNotFoundException;
import com.ledger.model.LedgerEntity;
import com.ledger.repository.LedgerRepository;

@RestController
@RequestMapping(path = "/api/v1/")
public class LedgerController {

	@Autowired
	private LedgerRepository ledgerRepository;

	// get ledger by ledger by id
	@GetMapping("ledger/{ledgerId}")
	public ResponseEntity<LedgerEntity> getLedgerById(@PathVariable(value = "ledgerId") long ledgerId)
			throws ResourceNotFoundException {

		LedgerEntity entity = this.ledgerRepository.findById(ledgerId)
				.orElseThrow(() -> new ResourceNotFoundException("Requested ledger not found..!"));

		return ResponseEntity.ok().body(entity);

	}

	// create new ledger
	@PostMapping("ledger")
	public LedgerEntity createLedger(@RequestBody LedgerEntity ledgerEntity) {
		return this.ledgerRepository.save(ledgerEntity);
	}

	// update ledger
	@PutMapping("ledger/{ledgerId}")
	private ResponseEntity<LedgerEntity> updateLedger(@PathVariable(value = "ledgerId") long ledgerId,
			@Validated @RequestBody LedgerEntity ledgerEntity) throws ResourceNotFoundException {
		LedgerEntity entity = this.ledgerRepository.findById(ledgerId)
				.orElseThrow(() -> new ResourceNotFoundException("Requested ledger not found..!"));

		entity.setAccountNumber(ledgerEntity.getAccountNumber());
		entity.setCurrency(ledgerEntity.getCurrency());

		return ResponseEntity.ok(this.ledgerRepository.save(entity));
	}

	// delete ledger
	@DeleteMapping("ledger/{ledgerId}")
	public Map<String, Boolean> deleteLedger(@PathVariable(value = "ledgerId") long ledgerId)
			throws ResourceNotFoundException {
		LedgerEntity entity = this.ledgerRepository.findById(ledgerId)
				.orElseThrow(() -> new ResourceNotFoundException("Requested ledger not found..!"));

		this.ledgerRepository.delete(entity);
		Map<String, Boolean> response = new HashMap();
		response.put("deleted", Boolean.TRUE);

		return response;
	}

}
