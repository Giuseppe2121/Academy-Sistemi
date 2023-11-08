package com.bean;

import java.io.Serializable;

public class CustomerProduct implements Serializable {
	
	//non DTO e VO perchè erano uguali, quindi creiamo un package .bean e possiamo utilizzarlo in entrambe le maniere(sia come DTO sia come VO)

	private static final long serialVersionUID = 7876096765966871737L;

	private int customerId;
	private int productId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	protected CustomerProduct() {

	}

	public CustomerProduct(int customerId, int productId) {
		super();
		this.customerId = customerId;
		this.productId = productId;
	}

}
