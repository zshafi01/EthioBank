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
	
	

//	@JoinColumn(name="accountId", referencedColumnName = "chequeId")
	

	private String description;
	private boolean isApproved;
	public ChequeBookRequest() {
		super();
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
