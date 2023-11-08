package com.bean;

public class Azienda {

	private String partitaIva;
	private String ragioneSociale;
	private String sedeLegale;
	private int numeroDipendenti;

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getSedeLegale() {
		return sedeLegale;
	}

	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}

	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}

	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}

	public Azienda(String partitaIva, String ragioneSociale, String sedeLegale, int numeroDipendenti) {
		super();
		this.partitaIva = partitaIva;
		this.ragioneSociale = ragioneSociale;
		this.sedeLegale = sedeLegale;
		this.numeroDipendenti = numeroDipendenti;
	}

	protected Azienda() {

	}

	@Override
	public String toString() {
		return "Azienda [partitaIva=" + partitaIva + ", ragioneSociale=" + ragioneSociale + ", sedeLegale=" + sedeLegale
				+ ", numeroDipendenti=" + numeroDipendenti + "]";
	}

}
