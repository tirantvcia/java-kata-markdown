package com.codigosostenible.curso;


public class Reader {
	
	private static final String NEW_PAGE = "012";
	PageService pageService;
	PageRepositoryData pageRepository;
	BookRepository bookRepository;

	public Reader(PageService service, BookRepository bookRepository) {
		this.pageService = service;
		this.pageRepository = new PageRepositoryData();
		pageService.setRepository(pageRepository);
		this.bookRepository = bookRepository;
	}

	public void introLine(String text) {
		
		if(NEW_PAGE.equals(text)) {
			bookRepository.save(pageRepository);
			pageRepository = new PageRepositoryData();
			pageService.setRepository(pageRepository);
		}
		
		pageService.add(text);
		
		
	}

}
