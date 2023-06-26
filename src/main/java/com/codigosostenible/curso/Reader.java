package com.codigosostenible.curso;


public class Reader {
	
	PageRepository paragrafDeposit;

	public Reader(PageRepository paragrafDeposit) {
		this.paragrafDeposit = paragrafDeposit;
	}

	public void introParagraf(String text) {
		paragrafDeposit.add(text);
		
	}

}
