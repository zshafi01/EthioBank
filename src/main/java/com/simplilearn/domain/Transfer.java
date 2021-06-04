package com.simplilearn.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String transferFrom;
	private String transferTo;
	private double amount;
	private String phone;
	private Date Transferdate;
	private String memo;
	
//	@OneToOne(cascade = CascadeType.REMOVE)
//	@JoinColumn(name = "userId", referencedColumnName = "id")
//	private User user;
	
	private String customerid;
	
	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transfer(long id, String transferFrom, String transferTo, double amount, String phone, Date transferdate,
			String memo) {
		super();
		this.id = id;
		this.transferFrom = transferFrom;
		this.transferTo = transferTo;
		this.amount = amount;
		this.phone = phone;
		Transferdate = transferdate;
		this.memo = memo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransferFrom() {
		return transferFrom;
	}

	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}

	public String getTransferTo() {
		return transferTo;
	}

	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getTransferdate() {
		return Transferdate;
	}

	public void setTransferdate(Date transferdate) {
		Transferdate = transferdate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


	
}