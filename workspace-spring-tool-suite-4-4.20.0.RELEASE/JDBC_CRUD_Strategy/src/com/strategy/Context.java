package com.strategy;

import java.sql.SQLException;
import java.util.ArrayList;

public class Context {
	
	/*
	 * questo costruttore prevede in input un'interfaccia Padre 
	 * di due Strategies (customer e product)
	 * 
	 * l'applicazione invocante potrà usare(istanziare, new Conetxt) tale costruttore
	 * passandogli in input qualsiasi strategia Figlia (CustomerStrategy o ProductStrategy)
	 *  
	 * a seconda della Strategia Figlia passata in input dall'applicazione invocante 
	 * la Strategy Padre si trasformerà nel corretto figlio (POLIMORFISMO)
	 */

	private Strategy strategy;

	public Context(Strategy strategy) {    //costruttore creato da noi

		this.strategy = strategy;

	}
	
	public ArrayList<Object> executeStrategy() throws ClassNotFoundException, SQLException {
		
		/*
		 * quando viene invocato tale metodo (executeStrategy) strategy ha già assunto
		 * (in fase di invocazione del costruttore da parte dell'applicazione invocante)
		 * la forma della Strategy Figlia opportuna
		 * 
		 * Se la Strategy Figlia è CustomerStrategy verrà 
		 * invocato il metodo findAllObjects di CustomerStrategy
		 * 
		 * Se la Strategy Figlia è ProductStrategy verrà 
		 * invocato il metodo findAllObjects di ProductStrategy
		 */
		return strategy.findAllObjects();
	}
	

}
