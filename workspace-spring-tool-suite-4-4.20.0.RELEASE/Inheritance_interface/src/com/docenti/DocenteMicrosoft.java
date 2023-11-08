package com.docenti;

public class DocenteMicrosoft implements Docente {

	@Override
	public void spiegalinguaggio() {
		System.out.println("spiega C#");

	}

	@Override
	public void spiegaframework() {
		System.out.println("spiega .Net");
	}

	@Override
	public void spiegaarchitettura() {
		System.out.println("spiega archittetura IIS");

	}

}
