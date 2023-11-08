package com.vo;

import java.io.Serializable;

public class ProductVO implements Serializable {

	private static final long serialVersionUID = 1614831806948104171L;

	private String name;
	private String origin;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected ProductVO() {

	}

	public ProductVO(String name, String origin, int id) {
		super();
		this.name = name;
		this.origin = origin;
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", origin=" + origin + ", id=" + id + "]";
	}

}
