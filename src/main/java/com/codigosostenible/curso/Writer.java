package com.codigosostenible.curso;


public class Writer {

	PageRepository repository;
	LinePrinter linePinter;
	
	public Writer(PageRepository repository, LinePrinter linePinter) {
		this.repository = repository;
		this.linePinter = linePinter;
	}

	public void printLines() {
		 linePinter.print(repository.allLines());
		
	}

}
