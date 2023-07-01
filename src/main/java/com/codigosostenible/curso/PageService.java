package com.codigosostenible.curso;


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



	public void setRepository(PageRepositoryData repository) {
		this.repository = repository;
	}

}
