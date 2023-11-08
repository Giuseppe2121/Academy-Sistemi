package com.bean;

public class SedeLegale {

	private String Via;
	private int numeroCivico;
	private String Cap;
	private String Citta;
	private String Nazione;

	public String getVia() {
		return Via;
	}

	public void setVia(String via) {
		Via = via;
	}

	public int getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getCap() {
		return Cap;
	}

	public void setCap(String cap) {
		Cap = cap;
	}

	public String getCitta() {
		return Citta;
	}

	public void setCitta(String citta) {
		Citta = citta;
	}

	public String getNazione() {
		return Nazione;
	}

	public void setNazione(String nazione) {
		Nazione = nazione;
	}
	
	protected SedeLegale() {
		
	}

	public SedeLegale(String via, int numeroCivico, String cap, String citta, String nazione) {
		super();
		Via = via;
		this.numeroCivico = numeroCivico;
		Cap = cap;
		Citta = citta;
		Nazione = nazione;
	}

	@Override
	public String toString() {
		return "SedeLegale [Via=" + Via + ", numeroCivico=" + numeroCivico + ", Cap=" + Cap + ", Citta=" + Citta
				+ ", Nazione=" + Nazione + "]";
	}
	
	

}
