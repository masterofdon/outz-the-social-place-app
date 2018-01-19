package com.outz.app.entity.transaction;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.outz.app.entity.account.Account;

@Entity
@Table(name="outz_txn")
public class Transaction {

	public enum Action {
		NULL,
		CREATESESSION,
		ENTERSESSION,
		GIVEORDER,
		MAKEPAYMENT,
		ENDSESSION,
		UNKNOWN
	}
	
	public enum Status {
		NULL,
		START,
		FINISHED,
		CONTROLLED,
		UNKNOWN
	}
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.app.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@OneToOne
	private Account creator;
	
	@Enumerated(EnumType.STRING)
	private Action action;
	
	private String creationdate;
	
	private String expirationdate;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}

	public String getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
