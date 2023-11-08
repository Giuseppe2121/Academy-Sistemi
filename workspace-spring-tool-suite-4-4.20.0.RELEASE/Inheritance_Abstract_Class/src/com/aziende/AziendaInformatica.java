package com.aziende;

public class AziendaInformatica extends Azienda {

	@Override
	public void produce() {

		System.out.println("produce software/hardware");
	}

	@Override
	public void assume() {

		System.out.println("assume esperti informatici");
	}

}
