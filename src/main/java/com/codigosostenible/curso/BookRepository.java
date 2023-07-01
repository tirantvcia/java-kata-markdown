package com.codigosostenible.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {
	List<PageRepositoryData> pagesRepo;

	public BookRepository() {
		pagesRepo = new ArrayList<>();
	}

	public void save(PageRepositoryData pageRepository) {
		pagesRepo.add(pageRepository);
	}

	public List<String> allLines() {
		List<String> lineasResultantes = pagesRepo.stream().map(page -> page.findAll()).flatMap(paginas -> paginas.stream()).collect(Collectors.toList());
		return lineasResultantes;
	}
	
	
}
