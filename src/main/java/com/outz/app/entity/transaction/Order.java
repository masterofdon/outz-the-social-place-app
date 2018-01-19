package com.outz.app.entity.transaction;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.outz.app.entity.account.Account;

@Entity
@Table(name="outz_order")
public class Order {

	public enum Status {
		NULL,
		SENT,
		RECEIVED,
		PREPARING,
		DELIVERING,
		DELIVERED,
		CANCELLED,
		ONHOLD,
		UNKNOWN
	}
	
	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.app.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	@ManyToOne
	@JsonBackReference
	private Account owner;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
	        name = "outz_order_orderitems",
	        joinColumns = @JoinColumn(
	                name = "order_id",
	                referencedColumnName = "id"
	        ),
	        inverseJoinColumns = @JoinColumn(
	                name = "orderitem_id",
	                referencedColumnName = "id"
	        )
	)
	private Set<OrderItem> orderitem;
	
	@Enumerated(EnumType.STRING)
	private Status status;

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

	public Set<OrderItem> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(Set<OrderItem> orderitem) {
		this.orderitem = orderitem;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
