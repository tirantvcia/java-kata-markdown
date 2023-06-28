package com.codigosostenible.curso;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.codigosostenible.curso.data.TestData;

class ReaderTest {

	@Test
	void storesParagrafSourceIntoRepositoryBeforeTransformation() {
		PageService paragrafDepositSpy = mock(PageService.class);
		Reader reader = new Reader(paragrafDepositSpy);
		reader.introLine(TestData.DOCUMENT_INTRODUCTION);
		verify(paragrafDepositSpy).add(TestData.DOCUMENT_INTRODUCTION);
	}
//	@Test
//	void processTransformationParagrafSourceBeforeStoresIntoRepository() {
//		ParagrafDeposit paragrafDepositSpy = mock(ParagrafDeposit.class);
//		TransformationMarkdownProcess process = mock(TransformationMarkdownProcess.class);
//		Reader reader = new Reader(paragrafDepositSpy, process);
//		MarkDownOuputProcess markDown = new MarkDownOuputProcess();
//		markDown.setAnchorLine(TestData.OUPUT_TITLE_FIRST_BOOK);
//		markDown.setPageFeedReference(TestData.OUPUT_FIRST_BOOK_REFERENCE);
//		when(process.generatePageFeedReference(TestData.IN_TITLE_FIRST_BOOK)).thenReturn(markDown);
//		reader.introParagraf(TestData.DOCUMENT_INTRODUCTION);
//		verify(paragrafDepositSpy).add(TestData.DOCUMENT_INTRODUCTION);
//	}
}
