package com.outz.app.entity.account;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.outz.app.entity.View;

@Entity
@Table(name="outz_account_holder")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AccountHolder {

	public enum State {	
		UNKNOWN,
		REGISTERED,
		VERIFIED,
		ACTIVE,
		PASSIVE,
		LOCKED,
		REMOVED
	}
	
	@Id
	@JsonView(View.Base.class)
	protected String id;
	
	@Enumerated(EnumType.STRING)
    private State state;
	
	@JsonView(View.AdminExtended.class)
	protected String creationDate;
	
	@JsonView(View.AdminExtended.class)
	protected String expirationDate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
}
