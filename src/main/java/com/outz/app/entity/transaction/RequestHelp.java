package com.outz.app.entity.transaction;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.outz.app.entity.account.A2User;
import com.outz.app.entity.account.Account;

@Entity
@Table(name="outz_request_help")
public class RequestHelp {

	public enum Status {
		NULL,
		SENT,
		RECEIVED,
		PROCESSING,
		DONE,
		UNKNOWN
	}
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	@JsonBackReference
	private Account owner;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private String creationdate;
	
	private String expirationdate;
	
	private String lastmodifcationdate;
	
	private String enddate;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "outz_help_workers",
	        joinColumns = @JoinColumn(
	                name = "help_id",
	                referencedColumnName = "id"
	        ),
	        inverseJoinColumns = @JoinColumn(
	                name = "worker_id",
	                referencedColumnName = "id"
	        ))
	private Set<A2User> worker;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public String getLastmodifcationdate() {
		return lastmodifcationdate;
	}

	public void setLastmodifcationdate(String lastmodifcationdate) {
		this.lastmodifcationdate = lastmodifcationdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Set<A2User> getWorker() {
		return worker;
	}

	public void setWorker(Set<A2User> worker) {
		this.worker = worker;
	}
	
}
