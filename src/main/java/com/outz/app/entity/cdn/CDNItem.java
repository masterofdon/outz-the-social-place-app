package com.outz.app.entity.cdn;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="outz_cdn_item")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class CDNItem {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;

	private String cachecode;
	
	private String absoluteURL;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CDNServer server;
	
	private String part;
	
	public CDNItem(){
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCachecode() {
		return cachecode;
	}

	public void setCachecode(String cachecode) {
		this.cachecode = cachecode;
	}

	public String getAbsoluteURL() {
		return absoluteURL;
	}

	public void setAbsoluteURL(String absoluteURL) {
		this.absoluteURL = absoluteURL;
	}

	public CDNServer getServer() {
		return server;
	}

	public void setServer(CDNServer server) {
		this.server = server;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
	
}
