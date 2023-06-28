package com.codigosostenible.curso;


public class Reader {
	
	PageService paragrafDeposit;

	public Reader(PageService paragrafDeposit) {
		this.paragrafDeposit = paragrafDeposit;
	}

	public void introLine(String text) {
		paragrafDeposit.add(text);
		
	}

}
