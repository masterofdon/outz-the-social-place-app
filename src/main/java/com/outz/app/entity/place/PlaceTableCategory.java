package com.outz.app.entity.place;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.outz.app.entity.business.CompanyEntity;

@Entity
@Table(name="outz_placetablecategory")
public class PlaceTableCategory {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@Column(unique=true)
	private String categoryname;
	
	@Column(unique=true)
	private int categorylevel;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="companyentity_id")
	@JsonBackReference
	private CompanyEntity ownercompanyentity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public int getCategorylevel() {
		return categorylevel;
	}

	public void setCategorylevel(int categorylevel) {
		this.categorylevel = categorylevel;
	}

	public CompanyEntity getOwnercompanyentity() {
		return ownercompanyentity;
	}

	public void setOwnercompanyentity(CompanyEntity ownercompanyentity) {
		this.ownercompanyentity = ownercompanyentity;
	}
}
