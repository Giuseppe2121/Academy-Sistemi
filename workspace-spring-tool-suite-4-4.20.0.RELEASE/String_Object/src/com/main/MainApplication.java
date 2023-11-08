package com.main;

public class MainApplication {

	public static void main(String[] args) {

		/*
		 * Se trattiamo String come Literal (assegnazione diretta) in ogni caso le
		 * reference referenziano locazioni di memoriA (non oggetti) che vengono
		 * inserite in un aria di mmoria speciale dell'heap detta String Constant pool
		 * ciò consente di consumare meno memoria rispetto all'utilizzo di string come
		 * Classic Object (con l'utilizzo del costruttore)
		 * 
		 * se due reference (literal) vengono assegnate allo stesso valore in ogni caso
		 * vengono create due locazioni di memoria differenti all'interno dello string
		 * constant pool
		 */

		String s1 = "hello";
		String s2 = "hello";

		System.out.println(s1);
		System.out.println(s2);

		/*
		 * Nel caso in cui venga applicato alle String sotto forma di liteal un metodo
		 * che coinvolge il valore di due locazioni di memoria differenti dentro lo
		 * string constant pool viene creata una nuova locazione di memoria con un nuovo
		 * valore
		 * 
		 * se String è usato sotto forma di literal è IMMUTABLE
		 */

		s1.concat(s2);

		System.out.println(s1);
		System.out.println(s2);

	}

}
