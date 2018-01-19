package com.outz.app.entity.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.outz.app.entity.business.CompanyEntity;

@Entity
@Table(name="outz_menucondition")
public class MenuCondition {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.app.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="ownerentity_id")
	CompanyEntity ownerentity;

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

	public CompanyEntity getOwnerentity() {
		return ownerentity;
	}

	public void setOwnerentity(CompanyEntity ownerentity) {
		this.ownerentity = ownerentity;
	}
	
}
