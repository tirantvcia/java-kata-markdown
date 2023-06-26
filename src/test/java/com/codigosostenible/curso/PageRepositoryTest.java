package com.codigosostenible.curso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.codigosostenible.curso.data.TestData;

public class PageRepositoryTest {
	@Test
	public void storesAnchorAndReferenceForMarkDownLine() {
		
		TransformationMarkdownProcess markDownProcess = mock(TransformationMarkdownProcess.class);
		PageRepository repository = new PageRepository(markDownProcess);
		when(markDownProcess.generatePageFeedReference(TestData.IN_TITLE_FIRST_BOOK)).thenReturn(new MarkDownOuputProcess(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR, TestData.OUPUT_FIRST_BOOK_REFERENCE_WITHOUT_ANCHOR));
		
		repository.add(TestData.IN_TITLE_FIRST_BOOK);
				
		List<String> lines = repository.allLines();
		assertEquals(2, lines.size());
    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR.concat(TestData.ANCHOR_FIRST_BOOK), lines.get(0));
    	assertEquals(TestData.OUPUT_FIRST_BOOK_REFERENCE, lines.get(1));
    	
	}
	@Test
	public void storesSameLineIfThereIsNotMarkDown() {
		
		TransformationMarkdownProcess markDownProcess = mock(TransformationMarkdownProcess.class);
		PageRepository repository = new PageRepository(markDownProcess);
		when(markDownProcess.generatePageFeedReference(TestData.FIRST_BOOK_ABSTRACT)).thenReturn(new MarkDownOuputProcess(TestData.FIRST_BOOK_ABSTRACT, null));
		
		repository.add(TestData.FIRST_BOOK_ABSTRACT);
				
		List<String> lines = repository.allLines();
		assertEquals(1, lines.size());
    	assertEquals(TestData.FIRST_BOOK_ABSTRACT, lines.get(0));
    	
	}
	@Test
	public void storesTwoAnchorWithSameReferenceForSameMarkDown() {
		
		TransformationMarkdownProcess markDownProcess = mock(TransformationMarkdownProcess.class);
		PageRepository repository = new PageRepository(markDownProcess);
		when(markDownProcess.generatePageFeedReference(TestData.IN_TITLE_FIRST_BOOK)).thenReturn(new MarkDownOuputProcess(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR, TestData.OUPUT_FIRST_BOOK_REFERENCE_WITHOUT_ANCHOR));
		
		repository.add(TestData.IN_TITLE_FIRST_BOOK);
		repository.add(TestData.IN_TITLE_FIRST_BOOK);
				
		List<String> lines = repository.allLines();
		assertEquals(3, lines.size());
    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR.concat(TestData.ANCHOR_FIRST_BOOK), lines.get(0));
    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR.concat(TestData.ANCHOR_FIRST_BOOK), lines.get(1));
    	assertEquals(TestData.OUPUT_FIRST_BOOK_REFERENCE, lines.get(2));
    	
	}	
	@Test
	public void storesTwoAnchorWithDifferentReferenceForSeveralMarkDown() {
		
		TransformationMarkdownProcess markDownProcess = mock(TransformationMarkdownProcess.class);
		PageRepository repository = new PageRepository(markDownProcess);
		when(markDownProcess.generatePageFeedReference(TestData.IN_TITLE_FIRST_BOOK)).thenReturn(new MarkDownOuputProcess(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR, TestData.OUPUT_FIRST_BOOK_REFERENCE_WITHOUT_ANCHOR));
		when(markDownProcess.generatePageFeedReference(TestData.IN_TITLE_SECOND_BOOK)).thenReturn(new MarkDownOuputProcess(TestData.OUPUT_TITLE_SECOND_BOOK_WITHOUT_ANCHOR, TestData.OUPUT_SECOND_BOOK_REFERENCE_WITHOUT_ANCHOR));
		
		repository.add(TestData.IN_TITLE_FIRST_BOOK);
		repository.add(TestData.IN_TITLE_SECOND_BOOK);
				
		List<String> lines = repository.allLines();
		assertEquals(4, lines.size());
    	assertEquals(TestData.OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR.concat(TestData.ANCHOR_FIRST_BOOK), lines.get(0));
    	assertEquals(TestData.OUPUT_TITLE_SECOND_BOOK_WITHOUT_ANCHOR.concat(TestData.ANCHOR_SECOND_BOOK), lines.get(1));
    	assertEquals(TestData.OUPUT_FIRST_BOOK_REFERENCE, lines.get(2));
    	assertEquals(TestData.OUPUT_SECOND_BOOK_REFERENCE, lines.get(3));
	}
}