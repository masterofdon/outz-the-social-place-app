package com.outz.app.entity.account;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonView;
import com.outz.app.entity.View;

@Entity
@Table(name="outz_account")
public class Account {

	@Id
	@JsonView(View.Base.class)
	protected String id;
	
	private String deviceid;
	
	@OneToOne
	private AccountHolder accountHolder;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
}
