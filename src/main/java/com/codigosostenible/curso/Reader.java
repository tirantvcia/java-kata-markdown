package com.codigosostenible.curso;


public class Reader {
	
	private static final String NEW_PAGE = "012";
	private static final String NEW_CHAPTER = "022";
	PageService pageService;
	PageRepositoryData pageRepository;
	BookRepository bookRepository;


	public Reader(PageService service, BookRepository bookRepository) {
		this.pageService = service;
		this.pageRepository = new PageRepositoryData(0);
		pageService.setRepository(pageRepository);
		this.bookRepository = bookRepository;
	}

	public void introLine(String text) {
		
		if(NEW_PAGE.equals(text) || NEW_CHAPTER.equals(text)) {
			int chapterReferenceNumber = (NEW_CHAPTER.equals(text))?0:pageRepository.getChapterReferenceNumber();
			bookRepository.save(pageRepository);
			pageRepository = new PageRepositoryData(chapterReferenceNumber);
			pageService.setRepository(pageRepository);
			return;
		}
		
		pageService.add(text);
		
		
	}

}
