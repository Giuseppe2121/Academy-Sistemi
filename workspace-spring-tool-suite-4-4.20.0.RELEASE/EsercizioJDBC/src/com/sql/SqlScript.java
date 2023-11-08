package com.sql;

public interface SqlScript {
	
	public String sqlProductInsert = "insert into product (name,origin) values (?,?)";
	
	public String sqlProductFilter = "select * from product where product.name like ?";

}
