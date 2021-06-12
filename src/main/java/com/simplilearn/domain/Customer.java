package com.simplilearn.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;
import java.util.regex.Pattern;

@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@JsonIgnoreProperties("customer")
	private User user;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String ssn;
	@OneToOne(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
	private ChequeBookRequest chequeBookRequest;
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("customer")
	private List<Account> accounts;
	
	public Customer() {
		super();
	}

	public Customer(long id, User user, String firstName, String lastName, String email, String phone, String address,
			String ssn, ChequeBookRequest chequeBookRequest, List<Account> accounts) {
		super();
		this.id = id;
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.ssn = ssn;
		this.chequeBookRequest = chequeBookRequest;
		this.accounts = accounts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public ChequeBookRequest getChequeBookRequest() {
		return chequeBookRequest;
	}

	public void setChequeBookRequest(ChequeBookRequest chequeBookRequest) {
		this.chequeBookRequest = chequeBookRequest;
	}


	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
	