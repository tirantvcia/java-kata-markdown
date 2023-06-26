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

		ArgumentCaptor<String> paragrafCaptor = ArgumentCaptor.forClass(String.class);
    	Console consoleSpy = mock(Console.class);
    	
		PageRepository paragrafDeposit = new PageRepository(new TransformationMarkdownProcess());
    	Reader reader = new Reader(paragrafDeposit);
    	Writer writer = new Writer(paragrafDeposit, new LinePrinter(consoleSpy));
    	
		reader.introParagraf(TestData.DOCUMENT_INTRODUCTION);
		reader.introParagraf(TestData.IN_TITLE_FIRST_BOOK);
		reader.introParagraf(TestData.FIRST_BOOK_ABSTRACT);
		reader.introParagraf(TestData.IN_TITLE_SECOND_BOOK);
		reader.introParagraf(TestData.SECOND_BOOK_ABSTRACT);
		reader.introParagraf(TestData.IN_TITLE_THIRD_BOOK);
		reader.introParagraf(TestData.THIRD_BOOK_ABSTRACT);
		
    	writer.printLines();
    	
		verify(consoleSpy, times(10)).log(paragrafCaptor.capture());
    	List<String> paragrafCaptured = paragrafCaptor.getAllValues();
    	assertEquals(TestData.DOCUMENT_INTRODUCTION, paragrafCaptured.get(0));
    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK, paragrafCaptured.get(1));
    	assertEquals(TestData.FIRST_BOOK_ABSTRACT, paragrafCaptured.get(2));
    	assertEquals(TestData.OUPUT_TITLE_SECOND_BOOK, paragrafCaptured.get(3));
    	assertEquals(TestData.SECOND_BOOK_ABSTRACT, paragrafCaptured.get(4));
    	assertEquals(TestData.OUPUT_TITLE_THIRD_BOOK, paragrafCaptured.get(5));
    	assertEquals(TestData.THIRD_BOOK_ABSTRACT, paragrafCaptured.get(6));
    	assertEquals(TestData.OUPUT_FIRST_BOOK_REFERENCE, paragrafCaptured.get(7));
    	assertEquals(TestData.OUPUT_SECOND_BOOK_REFERENCE, paragrafCaptured.get(8));
    	assertEquals(TestData.OUPUT_THIRD_BOOK_REFERENCE, paragrafCaptured.get(9));
    	

    }

}
