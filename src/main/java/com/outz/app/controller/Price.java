package com.outz.app.controller;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Price implements Serializable{
	
	private static final long serialVersionUID = 4545252731186267766L;
	
	private float amount;
	private String currency;
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}	
}
