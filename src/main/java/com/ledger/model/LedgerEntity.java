package com.ledger.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ledger")
public class LedgerEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ledgerId;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "currency")
	private String currency;

	@ManyToOne
	private BankEntity bank;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ledger_id")
	private Set<TransactionEntity> transactions;

	public LedgerEntity() {
		// TODO Auto-generated constructor stub
	}

	public LedgerEntity(long ledgerId, String accountNumber, String currency) {
		super();
		this.ledgerId = ledgerId;
		this.accountNumber = accountNumber;
		this.currency = currency;
	}

	public long getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(long ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Set<TransactionEntity> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<TransactionEntity> transactions) {
		this.transactions = transactions;
	}

	public void setBank(BankEntity bank) {
		this.bank = bank;
	}
	
	public BankEntity getBank() {
		return bank;
	}


}
