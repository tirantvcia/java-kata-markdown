package com.codigosostenible.curso;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.codigosostenible.curso.data.TestData;

public class AppTest {

	@Test
    public void printsPageDocumentationWithReferencesAtLeast() {

		ArgumentCaptor<String> paragraphCaptor = ArgumentCaptor.forClass(String.class);
    	Console consoleSpy = mock(Console.class);
    	
		PageRepository pageRepository = new PageRepository(new TransformationMarkdownProcess());
    	Reader reader = new Reader(pageRepository);
    	Writer writer = new Writer(pageRepository, new LinePrinter(consoleSpy));
    	
		reader.introParagraf(TestData.DOCUMENT_INTRODUCTION);
		reader.introParagraf(TestData.IN_TITLE_FIRST_BOOK);
		reader.introParagraf(TestData.FIRST_BOOK_ABSTRACT);
		reader.introParagraf(TestData.IN_TITLE_SECOND_BOOK);
		reader.introParagraf(TestData.SECOND_BOOK_ABSTRACT);
		reader.introParagraf(TestData.IN_TITLE_THIRD_BOOK);
		reader.introParagraf(TestData.THIRD_BOOK_ABSTRACT);
		
    	writer.printLines();
    	
		verify(consoleSpy, times(10)).log(paragraphCaptor.capture());
    	List<String> paragraphCaptured = paragraphCaptor.getAllValues();
    	assertEquals(TestData.DOCUMENT_INTRODUCTION, paragraphCaptured.get(0));
    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK, paragraphCaptured.get(1));
    	assertEquals(TestData.FIRST_BOOK_ABSTRACT, paragraphCaptured.get(2));
    	assertEquals(TestData.OUPUT_TITLE_SECOND_BOOK, paragraphCaptured.get(3));
    	assertEquals(TestData.SECOND_BOOK_ABSTRACT, paragraphCaptured.get(4));
    	assertEquals(TestData.OUPUT_TITLE_THIRD_BOOK, paragraphCaptured.get(5));
    	assertEquals(TestData.THIRD_BOOK_ABSTRACT, paragraphCaptured.get(6));
    	assertEquals(TestData.OUPUT_FIRST_BOOK_REFERENCE, paragraphCaptured.get(7));
    	assertEquals(TestData.OUPUT_SECOND_BOOK_REFERENCE, paragraphCaptured.get(8));
    	assertEquals(TestData.OUPUT_THIRD_BOOK_REFERENCE, paragraphCaptured.get(9));
    	

    }

}
