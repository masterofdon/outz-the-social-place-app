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
import com.outz.app.controller.Price;
import com.outz.app.entity.business.CompanyEntity;

@Entity
@Table(name="outz_menuitem")
public class MenuItem {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.webm.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	private String name;

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Item> items;
	
	@ManyToOne
	@JoinColumn(name="ownerentity_id")
	@JsonBackReference
	CompanyEntity ownerentity;
	
	@ManyToMany(mappedBy="menuitems",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonBackReference
	private Set<Menu> menu;

	private Price price;
	
	@OneToOne
	@JoinColumn(name="category_id")
	private MenuItemCategory category;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public CompanyEntity getOwnerentity() {
		return ownerentity;
	}

	public void setOwnerentity(CompanyEntity ownerentity) {
		this.ownerentity = ownerentity;
	}

	public MenuItemCategory getCategory() {
		return category;
	}

	public void setCategory(MenuItemCategory category) {
		this.category = category;
	}
}
