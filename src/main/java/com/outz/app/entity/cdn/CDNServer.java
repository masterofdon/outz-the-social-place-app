package com.outz.app.entity.cdn;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="outz_cdn_server")
public class CDNServer {

	public enum Status {
		NULL,
		INITIALIZING,
		UP,
		RESTARTING,
		DOWN,
		UNKNOWN
	}
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	private String serveraddress;
	
	@Enumerated(EnumType.STRING)
	private Status serverstatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServeraddress() {
		return serveraddress;
	}

	public void setServeraddress(String serveraddress) {
		this.serveraddress = serveraddress;
	}

	public Status getServerstatus() {
		return serverstatus;
	}

	public void setServerstatus(Status serverstatus) {
		this.serverstatus = serverstatus;
	}
	
	
}
