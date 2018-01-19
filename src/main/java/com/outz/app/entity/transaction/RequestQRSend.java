package com.outz.app.entity.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.outz.app.entity.account.Account;

@Entity
@Table(name="outz_request_qrsend")
public class RequestQRSend {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.app.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	private String qrcode;
	
	private String creationdate;
	
	private String expirationdate;
	
	private String requestid;
	
	@OneToOne
	private Account owner;

	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(String expirationdate) {
		this.expirationdate = expirationdate;
	}

	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}	
}
