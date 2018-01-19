package com.outz.app.entity.base;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.outz.app.entity.place.OuterLocation;

@Entity
@Table(name="outz_address")
public class Address {

	public enum AddressType {
		NULL,
		COMMERCIAL,
		NONPROFIT,
		GOVERMENTAL,
		UNKNOWN
	}
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.app.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	private String name;
	
	private String googleplaceid;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private OuterLocation location;
	
	@Enumerated(EnumType.STRING)
	private AddressType addresstype;

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

	public String getGoogleplaceid() {
		return googleplaceid;
	}

	public void setGoogleplaceid(String googleplaceid) {
		this.googleplaceid = googleplaceid;
	}

	public OuterLocation getLocation() {
		return location;
	}

	public void setLocation(OuterLocation location) {
		this.location = location;
	}

	public AddressType getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(AddressType addresstype) {
		this.addresstype = addresstype;
	}
	
}
