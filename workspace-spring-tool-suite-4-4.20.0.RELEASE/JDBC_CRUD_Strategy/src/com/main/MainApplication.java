package com.main;

import java.sql.SQLException;

import com.strategy.Context;
import com.strategy.CustomerStrategy;
import com.strategy.ProductStrategy;
import com.strategy.Strategy;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Strategy customerStrategy = new CustomerStrategy();

		Context context = new Context(customerStrategy);
		context.executeStrategy().forEach(customer->System.out.println(customer));

		Strategy productStrategy = new ProductStrategy();

		Context contextP = new Context(productStrategy);
		contextP.executeStrategy().forEach(product->System.out.println(product));

	}

}
