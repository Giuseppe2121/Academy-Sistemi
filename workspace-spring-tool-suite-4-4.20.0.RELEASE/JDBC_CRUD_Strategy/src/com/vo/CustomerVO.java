package com.vo;

import java.io.Serializable;

public class CustomerVO implements Serializable {

	private static final long serialVersionUID = 6734456282361730936L;

	private String name;
	private String country;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CustomerVO(String name, String country, int id) {
		super();
		this.name = name;
		this.country = country;
		this.id = id;
	}

	protected CustomerVO() {

	}

	@Override
	public String toString() {
		return "CustomerVO [name=" + name + ", country=" + country + ", id=" + id + "]";
	}

}
