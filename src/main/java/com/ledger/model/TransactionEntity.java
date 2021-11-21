package com.ledger.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;

	@Column(name = "date")
	private Date date;

	@Column(name = "details")
	private String details;

	@Column(name = "debit")
	private double debit;

	@Column(name = "credit")
	private double credit;

	@Column(name = "balance")
	private double balance;

	@ManyToOne
	private LedgerEntity ledger;

	public TransactionEntity() {
		// TODO Auto-generated constructor stub
	}

	public TransactionEntity(long transactionId, Date date, String details, double debit, double credit,
			double balance) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.details = details;
		this.debit = debit;
		this.credit = credit;
		this.balance = balance;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public double getDebit() {
		return debit;
	}

	public void setDebit(double debit) {
		this.debit = debit;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
