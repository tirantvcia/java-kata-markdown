package com.codigosostenible.curso;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.codigosostenible.curso.data.TestData;

public class WriterTest {
	
	@Test
	void printsStatementThroughtStatementPrinter() {
		
		List<String> lines = Arrays.asList(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR, TestData.OUPUT_FIRST_BOOK_REFERENCE);
		PageRepository repository = mock(PageRepository.class);
		when(repository.allLines()).thenReturn(lines);
		LinePrinter linePinterSpy = mock(LinePrinter.class);
		Writer writer = new Writer(repository, linePinterSpy);
		
		
		writer.printLines();
		
		verify(linePinterSpy).print(lines);
    	

	}
}
