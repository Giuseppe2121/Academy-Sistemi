package com.exception;

public class EtaException extends Exception {

	public EtaException(String message) {
		
		//consente di invocare il costruttore del padre e poi invoca il suo
		super(message);

	}

}
