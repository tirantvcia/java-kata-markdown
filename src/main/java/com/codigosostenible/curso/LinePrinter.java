package com.codigosostenible.curso;


import java.util.List;

public class LinePrinter {
	Console console;
	
	public LinePrinter(Console console) {
		this.console = console;
	}

	public void print(List<String> lines) {
		lines.stream().forEach(line -> console.log(line));
	}
}
