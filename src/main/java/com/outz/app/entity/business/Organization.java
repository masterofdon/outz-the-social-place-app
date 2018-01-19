package com.outz.app.entity.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.outz.app.entity.account.Account;
import com.outz.app.entity.base.Address;

@Entity
@Table(name="outz_organization")
public class Organization {

	@Id
	private String id;
	
	private String name;
	
	@OneToOne
	private Address hqaddress;
	
	@OneToOne
	private Account contact;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getHqaddress() {
		return hqaddress;
	}

	public void setHqaddress(Address hqaddress) {
		this.hqaddress = hqaddress;
	}

	public Account getContact() {
		return contact;
	}

	public void setContact(Account contact) {
		this.contact = contact;
	}
	
	
}
