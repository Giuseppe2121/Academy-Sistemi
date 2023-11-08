package com.bean;

public class Azienda {

	private String partitaIva;
	private String ragioneSociale;
	/*
	 * relazione HAS-A la variabile sedeLegale è del tipo di un'altra classe cioè
	 * SedeLegale
	 * 
	 * la classe azienda HAS-A (contiene) una informazione complessa di un tipo
	 * Object costruito tramite un'altra classe
	 */
	private SedeLegale sedeLegale;

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

	public SedeLegale getSedeLegale() {
		return sedeLegale;
	}

	public void setSedeLegale(SedeLegale sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	
	protected Azienda () {
		
	}

	public Azienda(String partitaIva, String ragioneSociale, SedeLegale sedeLegale) {
		super();
		this.partitaIva = partitaIva;
		this.ragioneSociale = ragioneSociale;
		this.sedeLegale = sedeLegale;
	}
	

	@Override
	public String toString() {
		return "Azienda [partitaIva=" + partitaIva + ", ragioneSociale=" + ragioneSociale + ", sedeLegale=" + sedeLegale
				+ "]";
	}
	

}
