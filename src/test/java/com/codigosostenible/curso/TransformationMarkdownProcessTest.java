package com.codigosostenible.curso;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codigosostenible.curso.data.TestData;

class TransformationMarkdownProcessTest {

	@Test
	void testGeneratePageFeedReference() {
		MarkDownOuputProcess output = new MarkDownOuputProcess(TestData.OUPUT_TITLE_SECOND_BOOK_WITHOUT_ANCHOR, TestData.OUPUT_SECOND_BOOK_REFERENCE_WITHOUT_ANCHOR);
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		MarkDownOuputProcess generatePageFeedReference = process.generatePageFeedReference(TestData.IN_TITLE_SECOND_BOOK);
		assertEquals(output.getAnchorLine(), generatePageFeedReference.getAnchorLine());
		assertEquals(output.getPageFeedReference(), generatePageFeedReference.getPageFeedReference());
	}
	@Test
	void testLineWithoutMarkDown() {
		MarkDownOuputProcess output = new MarkDownOuputProcess(TestData.SECOND_BOOK_ABSTRACT, "");
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		MarkDownOuputProcess generatePageFeedReference = process.generatePageFeedReference(TestData.SECOND_BOOK_ABSTRACT);
		assertEquals(output.getAnchorLine(), generatePageFeedReference.getAnchorLine());
		assertEquals(output.getPageFeedReference(), generatePageFeedReference.getPageFeedReference());
	}
	

	@Test
	void testLineContainsThisBookRerenceAndLinkBook() {
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		boolean lineContainsMarkDownReference = process.lineContainsMarkDownReference("[this book] (http://www.cadenaser.es/libro)");
		assertEquals(true, lineContainsMarkDownReference);
		
	}
	@Test
	void testlineTextWithMarkDown() {
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		boolean lineContainsMarkDownReference = process.lineContainsMarkDownReference("algo por escribir.[this book] (http://www.cadenaser.es/libro)");
		assertEquals(true, lineContainsMarkDownReference);
		
	}
	@Test
	void testlineTextWithoutMarkDown() {
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		boolean lineContainsMarkDownReference = process.lineContainsMarkDownReference("algo por escribir.[this book]");
		assertEquals(false, lineContainsMarkDownReference);
		
	}
}
