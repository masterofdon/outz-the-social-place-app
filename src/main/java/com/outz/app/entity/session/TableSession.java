package com.outz.app.entity.session;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.outz.app.entity.place.PlaceTable;
import com.outz.app.entity.transaction.Transaction;

@Entity
@Table(name="outz_tablesession")
public class TableSession {

	public enum Status {
		NULL,
		STARTED,
		FINISHED,
		UNKNOWN
	}
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@OneToOne
	private Transaction initiatortxn;
	
	@OneToOne
	private PlaceTable tableid;
	
	@Enumerated(EnumType.STRING)
	private Status currentstatus;
	
	private String creationdate;
	
	private String expirationdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Transaction getInitiatortxn() {
		return initiatortxn;
	}

	public void setInitiatortxn(Transaction initiatortxn) {
		this.initiatortxn = initiatortxn;
	}

	public PlaceTable getTableid() {
		return tableid;
	}

	public void setTableid(PlaceTable tableid) {
		this.tableid = tableid;
	}

	public Status getCurrentstatus() {
		return currentstatus;
	}

	public void setCurrentstatus(Status currentstatus) {
		this.currentstatus = currentstatus;
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
	
}
