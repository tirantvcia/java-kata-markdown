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
    	PageRepositoryData repository = new PageRepositoryData();
		PageService pageService = new PageService(new TransformationMarkdownProcess(), repository);
    	Reader reader = new Reader(pageService);
    	Writer writer = new Writer(pageService, new LinePrinter(consoleSpy));
    	
		reader.introLine(TestData.DOCUMENT_INTRODUCTION);
		reader.introLine(TestData.IN_TITLE_FIRST_BOOK);
		reader.introLine(TestData.FIRST_BOOK_ABSTRACT);
		reader.introLine(TestData.IN_TITLE_SECOND_BOOK);
		reader.introLine(TestData.SECOND_BOOK_ABSTRACT);
		reader.introLine(TestData.IN_TITLE_THIRD_BOOK);
		reader.introLine(TestData.THIRD_BOOK_ABSTRACT);
		
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
    	assertEquals(TestData.ANCHOR_FIRST_BOOK_REFERENCE+TestData.OUPUT_FIRST_BOOK_REFERENCE, paragraphCaptured.get(7));
    	assertEquals(TestData.ANCHOR_SECOND_BOOK_REFERENCE+TestData.OUPUT_SECOND_BOOK_REFERENCE, paragraphCaptured.get(8));
    	assertEquals(TestData.ANCHOR_THIRD_BOOK_REFERENCE+TestData.OUPUT_THIRD_BOOK_REFERENCE, paragraphCaptured.get(9));
    	

    }
	
	
//	@Test
//    public void printsTwoPagesWithReferencesAtLeast() {
//
//		ArgumentCaptor<String> paragraphCaptor = ArgumentCaptor.forClass(String.class);
//    	Console consoleSpy = mock(Console.class);
//    	PageRepositoryData repository = new PageRepositoryData();
//		PageService pageService = new PageService(new TransformationMarkdownProcess(), repository);
//    	Reader reader = new Reader(pageService);
//    	Writer writer = new Writer(pageService, new LinePrinter(consoleSpy));
//    	
//		reader.introLine(TestData.DOCUMENT_INTRODUCTION);
//		reader.introLine(TestData.IN_TITLE_FIRST_BOOK);
//		reader.introLine(TestData.FIRST_BOOK_ABSTRACT);
//		reader.introLine(TestData.IN_TITLE_SECOND_BOOK);
//		reader.introLine(TestData.SECOND_BOOK_ABSTRACT);
//		reader.introLine(TestData.NEW_PAGE);
//		reader.introLine(TestData.IN_TITLE_THIRD_BOOK);
//		reader.introLine(TestData.THIRD_BOOK_ABSTRACT);
//		
//    	writer.printLines();
//    	
//		verify(consoleSpy, times(10)).log(paragraphCaptor.capture());
//    	List<String> paragraphCaptured = paragraphCaptor.getAllValues();
//    	assertEquals(TestData.DOCUMENT_INTRODUCTION, paragraphCaptured.get(0));
//    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK, paragraphCaptured.get(1));
//    	assertEquals(TestData.FIRST_BOOK_ABSTRACT, paragraphCaptured.get(2));
//    	assertEquals(TestData.OUPUT_TITLE_SECOND_BOOK, paragraphCaptured.get(3));
//    	assertEquals(TestData.SECOND_BOOK_ABSTRACT, paragraphCaptured.get(4));
//    	assertEquals(TestData.ANCHOR_FIRST_BOOK_REFERENCE+TestData.OUPUT_FIRST_BOOK_REFERENCE, paragraphCaptured.get(7));
//    	assertEquals(TestData.ANCHOR_SECOND_BOOK_REFERENCE+TestData.OUPUT_SECOND_BOOK_REFERENCE, paragraphCaptured.get(8));
//    	assertEquals(TestData.OUPUT_TITLE_THIRD_BOOK, paragraphCaptured.get(5));
//    	assertEquals(TestData.THIRD_BOOK_ABSTRACT, paragraphCaptured.get(6));    	
//    	assertEquals(TestData.ANCHOR_THIRD_BOOK_REFERENCE+TestData.OUPUT_THIRD_BOOK_REFERENCE, paragraphCaptured.get(9));	
//
//    }

}
