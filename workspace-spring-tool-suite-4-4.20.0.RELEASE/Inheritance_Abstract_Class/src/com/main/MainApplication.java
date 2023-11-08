package com.main;

import com.aziende.AziendaInformatica;
import com.aziende.AziendaMeccanica;

public class MainApplication {

	public static void main(String[] args) {

		AziendaMeccanica aziendaMeccanica = new AziendaMeccanica();
		aziendaMeccanica.assume();
		aziendaMeccanica.produce();
		aziendaMeccanica.fattura();

		AziendaInformatica aziendaInformatica = new AziendaInformatica();
		aziendaInformatica.assume();
		aziendaInformatica.produce();
		aziendaInformatica.fattura();

	}

}
