package com.outz.app.entity.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.outz.app.entity.item.MenuItem;

@Entity
@Table(name="outz_orderitem")
public class OrderItem {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.app.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@OneToOne
	private MenuItem item;
	
	private String extras;
	
	private int quantity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MenuItem getItem() {
		return item;
	}

	public void setItem(MenuItem item) {
		this.item = item;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
