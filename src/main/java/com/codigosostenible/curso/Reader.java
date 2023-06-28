package com.codigosostenible.curso;


public class Reader {
	
	PageService paragrafDeposit;

	public Reader(PageService paragrafDeposit) {
		this.paragrafDeposit = paragrafDeposit;
	}

	public void introParagraf(String text) {
		paragrafDeposit.add(text);
		
	}

}
