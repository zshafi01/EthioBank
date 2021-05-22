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
public class Recipents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name="account_id",referencedColumnName = "id")
	private Account account;
	
	@OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	
	public Recipents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Recipents(long id, Account account, Customer customer) {
		super();
		this.id = id;
		this.account = account;
		this.customer = customer;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
