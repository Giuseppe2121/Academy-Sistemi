package com.main;

import com.docenti.Docente;
import com.docenti.DocenteJava;

public class MainApplication {

	public static void main(String[] args) {

//		DocenteJava docenteJava = new DocenteJava();
//		docenteJava.spiegaarchitettura();
//		docenteJava.spiegaframework();
//		docenteJava.spiegalinguaggio();

//		DocenteMicrosoft docenteMicrosoft = new DocenteMicrosoft();
//		docenteMicrosoft.spiegaarchitettura();
//		docenteMicrosoft.spiegaframework();
//		docenteMicrosoft.spiegalinguaggio();

		/*
		 * in JAVA è possibile dare ad una reference lo stesso tipo dell'oggeto
		 * referenziato, ma è anche possibile dare ad una reference un tipo padre
		 * rispetto al tipo dell'oggeto referenziato (Docente tipo padre di docenteJava)
		 */
		/*
		 * il polimorfismo di oggetti apllicato tramiite linguaggio java utilizzando una
		 * reference di tipo interfaccia padre che referenia un oggetto di tipo classe
		 * concreta figlio rappresenta una implentazione intrinseca del pattern loose
		 * coupling
		 */

		Docente docenteJava = new DocenteJava();
		docenteJava.spiegalinguaggio();
		docenteJava.spiegaframework();
		docenteJava.spiegaarchitettura();

	}

}
