package com.outz.app.entity.item;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.outz.app.entity.business.CompanyEntity;

@Entity
@Table(name="outz_item")
public class Item {
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.app.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@OneToOne
	@JoinColumn(name="ownerentity_id")
	@JsonBackReference
	private CompanyEntity ownerentity;
	
	@ManyToMany(mappedBy="items",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<MenuItem> menuitems;
	
	private String name;
	
	private String imageurl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CompanyEntity getOwnerentity() {
		return ownerentity;
	}

	public void setOwnerentity(CompanyEntity ownerentity) {
		this.ownerentity = ownerentity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
}
