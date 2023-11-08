package com.business;

import com.exception.EtaException;

public class GestioneEccezioni {
	
	/*
	 * ASSIOMA JAVA
	 * 
	 * Un metodo JAVA che invoca un altro metodo JAVA il quale "lancia"
	 * una eccezione tramite keyword THROW deve a suo volta lanciare 
	 * la stessa eccezione
	 * (verificaEta lancia a sua volta nella sua firma la stessa eccezione del throw)
	 */

	public void verificaEta(int eta) throws EtaException {

		if (eta < 18) {
			
			throw new EtaException("Eta inferiore a 18 ---- no iscrizione!");

		}
		
		else {
			
			System.out.println("la tua richiesta è stata accettata");
		}

	}

}
