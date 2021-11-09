package com.orderManagement.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class SubscribedProduct {
	
	@EmbeddedId
	SubscribedProductId subscribedproduct;
	
	Integer quantity;

	
	public SubscribedProductId getSubscribedproduct() {
		return subscribedproduct;
	}

	public void setSubscribedproduct(SubscribedProductId subscribedproduct) {
		this.subscribedproduct = subscribedproduct;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	

	public SubscribedProduct(SubscribedProductId subscribedproduct, Integer quantity) {
		super();
		this.subscribedproduct = subscribedproduct;
		this.quantity = quantity;
	}

	public SubscribedProduct() {
		// TODO Auto-generated constructor stub
	}
	
	

}
