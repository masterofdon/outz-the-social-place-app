package com.outz.app.entity.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.GenericGenerator;

import com.outz.app.entity.account.Account;

@Entity
@Table(name="outz_company")
public class Company {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
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
		return this.name;
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