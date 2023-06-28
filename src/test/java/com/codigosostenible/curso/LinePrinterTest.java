package com.codigosostenible.curso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.codigosostenible.curso.data.TestData;

class LinePrinterTest {

	@Test
	void printOuputLinesFromOneLineInRepository() {
		List<String> lines = Arrays.asList(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR);
		PageService repository = mock(PageService.class);
		Console consoleSpy = mock(Console.class);
		when(repository.allLines()).thenReturn(lines);
		LinePrinter linePrinter = new LinePrinter(consoleSpy);
		
		linePrinter.print(lines);
		
		
		verify(consoleSpy ).log(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR);
	}
	@Test
	void printOuputMarkDownInRepository() {
		List<String> lines = Arrays.asList(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR, TestData.OUPUT_FIRST_BOOK_REFERENCE);
		PageService repository = mock(PageService.class);
		Console consoleSpy = mock(Console.class);
		when(repository.allLines()).thenReturn(lines);
		LinePrinter linePrinter = new LinePrinter(consoleSpy);
		
		linePrinter.print(lines);
		
		
		verify(consoleSpy ).log(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR);
		verify(consoleSpy ).log(TestData.OUPUT_FIRST_BOOK_REFERENCE);
	}

}
