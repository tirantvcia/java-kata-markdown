package com.codigosostenible.curso.data;

public class TestData {
	
	private static final String ANCHOR_THIRD_BOOK = "[^anchor3]";
	private static final String ANCHOR_REFERENCE_SEPARATION = ": ";
	public static final String ANCHOR_FIRST_BOOK = "[^anchor1]";
	public static final String ANCHOR_FIRST_BOOK_REFERENCE = ANCHOR_FIRST_BOOK+ANCHOR_REFERENCE_SEPARATION;
	public static final String ANCHOR_TEMPLATE = "[^anchorx]";
	public static final String ANCHOR_SECOND_BOOK = "[^anchor2]";
	public static final String ANCHOR_SECOND_BOOK_REFERENCE = ANCHOR_SECOND_BOOK+ANCHOR_REFERENCE_SEPARATION;
	public static final String ANCHOR_THIRD_BOOK_REFERENCE = ANCHOR_THIRD_BOOK+ANCHOR_REFERENCE_SEPARATION;
	
	public static final String OUPUT_TITLE_SECOND_BOOK_WITHOUT_ANCHOR = "Libro 2: 'Aprendiendo TDD en Python' por Harry Percival. ";
	public static final String OUPUT_SECOND_BOOK_REFERENCE_WITHOUT_ANCHOR = "Percival, H. 20XX. Aprendiendo TDD en Python. Editorial XYZ";
	
	public static final String IN_TITLE_FIRST_BOOK = "Libro 1: 'Pruebas Ágiles de Software' por Lisa Crispin y Janet Gregory. "
			+ "[this book] (Crispin, L., & Gregory, J. 20XX. Pruebas Ágiles de Software. Editorial ABC.)";
	public static final String IN_TITLE_SECOND_BOOK = "Libro 2: 'Aprendiendo TDD en Python' por Harry Percival. "
			+ "[this book] (Percival, H. 20XX. Aprendiendo TDD en Python. Editorial XYZ)";
	public static final String IN_TITLE_THIRD_BOOK = "Libro 3: 'Clean Code: A Handbook of Agile Software Craftsmanship' por Robert C. Martin. "
			+ "[this book](Martin, R. C. 20XX. Clean Code: A Handbook of Agile Software Craftsmanship. Editorial DEF.)";
	
	public static final String DOCUMENT_INTRODUCTION = "Desarrollo Dirigido por Pruebas (TDD) es una metodología de desarrollo de software que se centra en escribir pruebas automatizadas antes de implementar el código.";
	
	public static final String OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR = "Libro 1: 'Pruebas Ágiles de Software' por Lisa Crispin y Janet Gregory. ";

	public static final String OUPUT_TITLE_FIRST_BOOK = OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR.concat(ANCHOR_FIRST_BOOK);
	public static final String FIRST_BOOK_ABSTRACT = "El TDD es un enfoque en el que los desarrolladores escriben pruebas automatizadas antes de escribir el código de producción.";

	public static final String OUPUT_TITLE_SECOND_BOOK = "Libro 2: 'Aprendiendo TDD en Python' por Harry Percival. [^anchor2]";
	public static final String SECOND_BOOK_ABSTRACT = "El TDD se basa en el principio de escribir pruebas claras y simples que describen el comportamiento deseado del código.";

	public static final String OUPUT_TITLE_THIRD_BOOK = "Libro 3: 'Clean Code: A Handbook of Agile Software Craftsmanship' por Robert C. Martin. [^anchor3]";
	public static final String THIRD_BOOK_ABSTRACT = "El TDD es una práctica esencial para escribir código limpio y bien estructurado."
			+ "Además, el ciclo TDD proporciona una retroalimentación rápida y constante, permitiendo a los desarrolladores realizar cambios con confianza.";
	public static final String OUPUT_FIRST_BOOK_REFERENCE_WITHOUT_ANCHOR = "Crispin, L., & Gregory, J. 20XX. Pruebas Ágiles de Software. Editorial ABC.";
	public static final String OUPUT_FIRST_BOOK_REFERENCE = "Crispin, L., & Gregory, J. 20XX. Pruebas Ágiles de Software. Editorial ABC.";
	public static final String OUPUT_SECOND_BOOK_REFERENCE = "Percival, H. 20XX. Aprendiendo TDD en Python. Editorial XYZ";
	public static final String OUPUT_THIRD_BOOK_REFERENCE = "Martin, R. C. 20XX. Clean Code: A Handbook of Agile Software Craftsmanship. Editorial DEF.";
	public static final String TEXT_LINE_WITH_TWO_MARKDOWN = "algo por escribir.[this book] (http://www.cadenaser.es/libro) y esto otro [this book] (http://www.cadenaser.es/libros)";

	public static final String TEXT_LINE_WITH_TWO_MD_FIRST_ANCHOR = "algo por escribir.";
	public static final String TEXT_LINE_WITH_TWO_MD_FIRST_REFERENCE = "http://www.cadenaser.es/libro";
	public static final String TEXT_LINE_WITH_TWO_MD_SECOND_ANCHOR = "y esto otro";
	public static final String TEXT_LINE_WITH_TWO_MD_SECOND_REFERENCE = "http://www.cadenaser.es/libros";
	public static final String NEW_PAGE = "012";
	public static final String NEW_CHAPTER = "022";

}
