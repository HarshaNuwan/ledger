package com.ledger.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class BankEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bankId;

	@Column(name = "bank_name")
	private String bankName;

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "bank_id")
	private Set<LedgerEntity> ledgers;

	public BankEntity() {
		// TODO Auto-generated constructor stub
	}

	public BankEntity(long bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Set<LedgerEntity> getLedgers() {
		return ledgers;
	}

	public void setLedgers(Set<LedgerEntity> ledgers) {
		this.ledgers = ledgers;
	}

}
