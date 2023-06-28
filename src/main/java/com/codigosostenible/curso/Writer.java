package com.codigosostenible.curso;


public class Writer {

	PageService repository;
	LinePrinter linePinter;
	
	public Writer(PageService repository, LinePrinter linePinter) {
		this.repository = repository;
		this.linePinter = linePinter;
	}

	public void printLines() {
		 linePinter.print(repository.allLines());
		
	}

}
