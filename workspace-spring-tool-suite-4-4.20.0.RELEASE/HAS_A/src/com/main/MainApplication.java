package com.main;

import com.bean.Azienda;
import com.bean.SedeLegale;

public class MainApplication {

	public static void main(String[] args) {
		
		SedeLegale sedeLegale = new SedeLegale("Via Bianchini",60,"00100","Roma","Italia");//60 non tra "" perchè è int
		
		Azienda azienda = new Azienda("1023T","company",sedeLegale); //sedeLegale non tra "" perchè è una variabile
		
		System.out.println(azienda.toString());
		
		

	}

}
