package com.codigosostenible.curso;


public class Writer {

	BookRepository repository;
	LinePrinter linePinter;
	
	public Writer(BookRepository repository, LinePrinter linePinter) {
		this.repository = repository;
		this.linePinter = linePinter;
	}

	public void printLines() {
		 linePinter.print(repository.allLines());
		
	}

}
