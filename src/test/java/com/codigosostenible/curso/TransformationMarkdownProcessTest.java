package com.codigosostenible.curso;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.codigosostenible.curso.data.TestData;

class TransformationMarkdownProcessTest {

	@Test
	void testGeneratePageFeedReference() {
		MarkDownOuputProcess output = new MarkDownOuputProcess(TestData.OUPUT_TITLE_SECOND_BOOK_WITHOUT_ANCHOR, TestData.OUPUT_SECOND_BOOK_REFERENCE_WITHOUT_ANCHOR);
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		List<MarkDownOuputProcess> generatePageFeedReference = process.generatePageFeedReference(TestData.IN_TITLE_SECOND_BOOK);
		assertEquals(output.getAnchorLine(), generatePageFeedReference.get(0).getAnchorLine());
		assertEquals(output.getPageFeedReference(), generatePageFeedReference.get(0).getPageFeedReference());
	}
	@Test
	void testLineWithoutMarkDown() {
		MarkDownOuputProcess output = new MarkDownOuputProcess(TestData.SECOND_BOOK_ABSTRACT, "");
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		List<MarkDownOuputProcess> generatePageFeedReference = process.generatePageFeedReference(TestData.SECOND_BOOK_ABSTRACT);
		assertEquals(output.getAnchorLine(), generatePageFeedReference.get(0).getAnchorLine());
		assertEquals(output.getPageFeedReference(), generatePageFeedReference.get(0).getPageFeedReference());
	}
	

	@Test
	void testlineTextWithMarkDown() {
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		List<MarkDownOuputProcess> lineContainsMarkDownReference = process.generatePageFeedReference("algo por escribir.[this book] (http://www.cadenaser.es/libro)");
		
		assertEquals("algo por escribir.", lineContainsMarkDownReference.get(0).getAnchorLine());
		assertEquals("http://www.cadenaser.es/libro", lineContainsMarkDownReference.get(0).getPageFeedReference());
		
	}
	
	@Test
	void testlineTextWithSomeMarkDown() {
		MarkDownOuputProcess output1 = new MarkDownOuputProcess("algo por escribir.", "http://www.cadenaser.es/libro");
		MarkDownOuputProcess output2 = new MarkDownOuputProcess("y esto otro", "http://www.cadenaser.es/libro");
		List<MarkDownOuputProcess> asList = Arrays.asList(output1, output2);
		
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		List<MarkDownOuputProcess> lineContainsMarkDownReference = process.generatePageFeedReference("algo por escribir.[this book] (http://www.cadenaser.es/libro) y esto otro [this book] (http://www.cadenaser.es/libro)");
		assertEquals(2, lineContainsMarkDownReference.size());
		
		
	}
	
	@Test
	void testlineTextWithoutMarkDown() {
		TransformationMarkdownProcess process = new TransformationMarkdownProcess();
		List<MarkDownOuputProcess> lineWithoutMarkDownReference = process.generatePageFeedReference("algo por escribir.[this book]");
		MarkDownOuputProcess markDownOuputProcess = lineWithoutMarkDownReference.get(0);
		assertEquals("algo por escribir.[this book]", markDownOuputProcess.getAnchorLine());
		
	}
}
