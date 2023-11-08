package com.main;

import com.business.GestioneEccezioni;
import com.business.Operazione;
import com.exception.EtaException;

public class MainApplication {

	public static void main(String[] args) throws EtaException {      
		//anche il main deve lanciare la stessa eccezione throw di verificaEta
        
//		Operazione operazione = new Operazione();
//		
//		try {
//			
//			//lettura di un file xcel
//			
//			operazione.divisione(7, 0);	
//		}
//		
//		catch(ArithmeticException ex){
//			
//			ex.printStackTrace();
//			
//			
//		}
		
		GestioneEccezioni gestioneEccezioni = new GestioneEccezioni ();
		gestioneEccezioni.verificaEta(15);
		
		

	}

}
