package com.codigosostenible.curso;


import java.util.ArrayList;
import java.util.List;

public class PageService {

	TransformationMarkdownProcess markDownProcess;
	PageRepositoryData repository;



	public PageService(TransformationMarkdownProcess markDownProcess, PageRepositoryData repository) {
		this.markDownProcess = markDownProcess;
		this.repository = repository;

	}

	public void add(String sourceLine) {
		List<MarkDownOuputProcess> generatedPageFeedReference = markDownProcess.generatePageFeedReference(sourceLine);
		
		repository.save(generatedPageFeedReference);
		

		
	}


	public List<String> allLines() {
		return repository.findAll();
	}

}
