package com.simplilearn.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ChequeBookRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private Account account;
	private String description;
	private boolean isApproved;

	public ChequeBookRequest() {
		super();
	}

	public ChequeBookRequest(long id, Customer customer, Account account, String description, boolean isApproved) {
		super();
		this.id = id;
		this.customer = customer;
		this.account = account;
		this.description = description;
		this.isApproved = isApproved;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}
