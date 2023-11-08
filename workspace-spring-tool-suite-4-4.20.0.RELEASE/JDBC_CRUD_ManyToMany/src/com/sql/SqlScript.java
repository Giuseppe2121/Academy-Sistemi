package com.sql;

public interface SqlScript {
	
	public String sqlCustomerInsert = "insert into customer (name, country) values (?,?)";
	
	public String sqlProductInsert = "insert into product (name,origin) values (?,?)";
	
	public String sqlJoinInsert = "insert into customer_product (customer_id,product_id) values (?,?)";
	
	public String sqlFindMaxCustomerId = "select max(id) from customer";
	
	public String sqlFindMaxProductId = "select max(id) from product";
	
	public String sqlFindCustomersNameByProduct = "select customer.name from customer LEFT JOIN customer_product on customer.id=customer_product.customer_id where customer_product.product_id=?";


}
