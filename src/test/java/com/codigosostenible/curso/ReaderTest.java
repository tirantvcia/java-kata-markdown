package com.codigosostenible.curso;

import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codigosostenible.curso.data.TestData;

class ReaderTest {

	@Test
	void storesParagrafSourceIntoRepositoryBeforeTransformation() {
		PageService paragrafDepositSpy = mock(PageService.class);
		BookRepository bookRepository = new BookRepository();
		Reader reader = new Reader(paragrafDepositSpy, bookRepository);
		reader.introLine(TestData.DOCUMENT_INTRODUCTION);
		verify(paragrafDepositSpy).add(TestData.DOCUMENT_INTRODUCTION);
	}

	@Test
	public void testAddNewPageInBookRepositoryForEveryNewPage() {

		Console consoleSpy = mock(Console.class);
		
		BookRepository bookRepository = new BookRepository();
		PageRepositoryData repository = new PageRepositoryData();
		PageService pageService = new PageService(new TransformationMarkdownProcess(), repository);
		Reader reader = new Reader(pageService, bookRepository);

		reader.introLine(TestData.IN_TITLE_FIRST_BOOK);
		reader.introLine(TestData.FIRST_BOOK_ABSTRACT);
		reader.introLine(TestData.NEW_PAGE);
		reader.introLine(TestData.IN_TITLE_SECOND_BOOK);
		reader.introLine(TestData.SECOND_BOOK_ABSTRACT);
		reader.introLine(TestData.NEW_PAGE);
		reader.introLine(TestData.IN_TITLE_THIRD_BOOK);
		reader.introLine(TestData.THIRD_BOOK_ABSTRACT);
		reader.introLine(TestData.NEW_PAGE);
		
		assertEquals(3, bookRepository.pagesRepo.size());
	}
	@Test
	public void testReferencePositionByChapter() {

		Console consoleSpy = mock(Console.class);
		
		BookRepository bookRepository = new BookRepository();
		PageRepositoryData repository = new PageRepositoryData();
		PageService pageService = new PageService(new TransformationMarkdownProcess(), repository);
		Reader reader = new Reader(pageService, bookRepository);

		reader.introLine(TestData.IN_TITLE_FIRST_BOOK);
		reader.introLine(TestData.NEW_PAGE);
		reader.introLine(TestData.IN_TITLE_SECOND_BOOK);
		reader.introLine(TestData.NEW_PAGE);
		
		List<String> allLines = bookRepository.allLines();
		assertEquals(4, allLines.size());
    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK, allLines.get(0));
    	assertEquals(TestData.ANCHOR_FIRST_BOOK_REFERENCE+TestData.OUPUT_FIRST_BOOK_REFERENCE, allLines.get(1));
    	assertEquals(TestData.OUPUT_TITLE_SECOND_BOOK, allLines.get(2));
    	assertEquals(TestData.ANCHOR_SECOND_BOOK_REFERENCE+TestData.OUPUT_SECOND_BOOK_REFERENCE, allLines.get(3));


	}	
	
	@Test
    public void testResetReferenceNumberAfterNewChapter() {

			Console consoleSpy = mock(Console.class);
			
			BookRepository bookRepository = new BookRepository();
			PageRepositoryData repository = new PageRepositoryData();
			PageService pageService = new PageService(new TransformationMarkdownProcess(), repository);
			Reader reader = new Reader(pageService, bookRepository);

			reader.introLine(TestData.IN_TITLE_FIRST_BOOK);
			reader.introLine(TestData.NEW_PAGE);
			reader.introLine(TestData.IN_TITLE_SECOND_BOOK);
			reader.introLine(TestData.NEW_CHAPTER);
			reader.introLine(TestData.IN_TITLE_FIRST_BOOK);
			reader.introLine(TestData.NEW_PAGE);

			
			List<String> allLines = bookRepository.allLines();
			assertEquals(6, allLines.size());
	    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK, allLines.get(0));
	    	assertEquals(TestData.ANCHOR_FIRST_BOOK_REFERENCE+TestData.OUPUT_FIRST_BOOK_REFERENCE, allLines.get(1));
	    	assertEquals(TestData.OUPUT_TITLE_SECOND_BOOK, allLines.get(2));
	    	assertEquals(TestData.ANCHOR_SECOND_BOOK_REFERENCE+TestData.OUPUT_SECOND_BOOK_REFERENCE, allLines.get(3));
	    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK, allLines.get(0));
	    	assertEquals(TestData.ANCHOR_FIRST_BOOK_REFERENCE+TestData.OUPUT_FIRST_BOOK_REFERENCE, allLines.get(1));

	}
}
