package com.outz.app.entity.item;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.outz.app.entity.account.Account;
import com.outz.app.entity.business.CompanyEntity;

@Entity
@Table(name="outz_menu")
public class Menu {
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	private String menuname;
	
	@ManyToOne
	@JoinColumn(name="creator_account_id")
	private Account creator;
	
	private String creationdate;
	
	private String expirationdate;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<MenuItem> menuitems;
	
	@ManyToOne
	@JoinColumn(name="ownerentity_id")
	@JsonBackReference
	CompanyEntity ownerentity;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="condition_id")
	private MenuCondition condition;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
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

	public MenuCondition getCondition() {
		return condition;
	}

	public void setCondition(MenuCondition condition) {
		this.condition = condition;
	}

	public Set<MenuItem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(Set<MenuItem> menuitems) {
		this.menuitems = menuitems;
	}

	public CompanyEntity getOwnerentity() {
		return ownerentity;
	}

	public void setOwnerentity(CompanyEntity ownerentity) {
		this.ownerentity = ownerentity;
	}
}
