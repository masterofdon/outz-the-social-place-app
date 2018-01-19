package com.outz.app.entity.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="outz_request_order")
public class RequestOrder {

	@Id
	@GenericGenerator(
			name = "outz-random-15",
	        strategy = "com.outz.app.utils.StringSequenceIdentifier"
    )
	@GeneratedValue(generator = "outz-random-15")
	private String id;
	
	private String creationdate;
	
	private String expirationdate;
	
	@OneToOne
	private Transaction txnid;
	
	@OneToOne
	@JoinColumn(name="order_id")
	private Order order;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Transaction getTxnid() {
		return txnid;
	}

	public void setTxnid(Transaction txnid) {
		this.txnid = txnid;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
