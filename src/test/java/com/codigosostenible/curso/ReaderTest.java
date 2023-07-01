package com.codigosostenible.curso;

import static org.mockito.Mockito.*;
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
}
