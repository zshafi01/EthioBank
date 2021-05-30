package com.simplilearn.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String accountNumber;
	private String types;
	private double balance;
	private Date date;
	@OneToOne(mappedBy = "account")
	ChequeBookRequest chequeBookRequest;
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
	@JsonIgnoreProperties("accounts")
	private Customer customer;
	
	public Account() {
		super();
	}
	
	public Account(long id, String accountNumber, String types, double balance, Date date, 
			ChequeBookRequest chequeBookRequest, Customer customer) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.types = types;
		this.balance = balance;
		this.date = date;
		this.chequeBookRequest = chequeBookRequest;
		this.customer = customer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ChequeBookRequest getChequeBookRequest() {
		return chequeBookRequest;
	}

	public void setChequeBookRequest(ChequeBookRequest chequeBookRequest) {
		this.chequeBookRequest = chequeBookRequest;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



}
