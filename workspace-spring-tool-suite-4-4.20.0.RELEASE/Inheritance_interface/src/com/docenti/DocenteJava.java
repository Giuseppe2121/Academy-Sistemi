package com.docenti;

public class DocenteJava implements Docente {

	@Override
	public void spiegalinguaggio() {
		System.out.println("spiega Java");

	}

	@Override
	public void spiegaframework() {
		System.out.println("spiega Spring");

	}

	@Override
	public void spiegaarchitettura() {
		System.out.println("spiega architettura Java Enterprise");

	}

}
