package com.outz.app.entity.place;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.outz.app.entity.business.CompanyEntity;

@Entity
@Table(name="outz_placetable")
public class PlaceTable {

	
	public enum Status {
		NULL,
		EMPTY,
		OCCUPIED,
		UNKNOWN
	}
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String qrcode;
	
	@ManyToOne()
	@JoinColumn(name="companyentity_id")
	@JsonBackReference
	private CompanyEntity ownercompanyentity;
	
	@OneToOne
	@Cascade(value = { org.hibernate.annotations.CascadeType.ALL })
	private InnerLocation location;
	
	@OneToOne
	private PlaceTableCategory category;
	
	@Enumerated(EnumType.STRING)
	private Status status;

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

	public CompanyEntity getOwnercompanyentity() {
		return ownercompanyentity;
	}

	public void setOwnercompanyentity(CompanyEntity ownercompanyentity) {
		this.ownercompanyentity = ownercompanyentity;
	}

	public InnerLocation getLocation() {
		return location;
	}

	public void setLocation(InnerLocation location) {
		this.location = location;
	}

	public PlaceTableCategory getCategory() {
		return category;
	}

	public void setCategory(PlaceTableCategory category) {
		this.category = category;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
