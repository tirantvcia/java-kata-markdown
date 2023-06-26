package com.codigosostenible.curso.data;

public class TestData {
	
	public static final String OUPUT_TITLE_SECOND_BOOK_WITHOUT_ANCHOR = "Libro 2: 'Aprendiendo TDD en Python' por Harry Percival.";
	public static final String OUPUT_SECOND_BOOK_REFERENCE_WITHOUT_ANCHOR = "Percival, H. (20XX). Aprendiendo TDD en Python. Editorial XYZ";
	public static final String ANCHOR_SECOND_BOOK = "[^anchor2]";
	public static String IN_TITLE_FIRST_BOOK = "Libro 1: 'Pruebas Ágiles de Software' por Lisa Crispin y Janet Gregory. "
			+ "[this book] (Crispin, L., & Gregory, J. (20XX). Pruebas Ágiles de Software. Editorial ABC.)";
	public static String IN_TITLE_SECOND_BOOK = "Libro 2: 'Aprendiendo TDD en Python' por Harry Percival. "
			+ "[this book] (Percival, H. (20XX). Aprendiendo TDD en Python. Editorial XYZ)";
	public static String IN_TITLE_THIRD_BOOK = "Libro 3: 'Clean Code: A Handbook of Agile Software Craftsmanship' por Robert C. Martin. "
			+ "[this book](Martin, R. C. (20XX). Clean Code: A Handbook of Agile Software Craftsmanship. Editorial DEF.)";
	
	public static String DOCUMENT_INTRODUCTION = "Desarrollo Dirigido por Pruebas (TDD) es una metodología de desarrollo de software que se centra en escribir pruebas automatizadas antes de implementar el código.";
	public static String ANCHOR_TEMPLATE = "[^anchorx]";
	public static String OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR = "Libro 1: 'Pruebas Ágiles de Software' por Lisa Crispin y Janet Gregory.";
	public static String ANCHOR_FIRST_BOOK = "[^anchor1]";
	public static String OUPUT_TITLE_FIRST_BOOK = OUPUT_TITLE_FIRST_BOOK_WITHOUT_ANCHOR.concat(ANCHOR_FIRST_BOOK);
	public static String FIRST_BOOK_ABSTRACT = "El TDD es un enfoque en el que los desarrolladores escriben pruebas automatizadas antes de escribir el código de producción.";

	public static String OUPUT_TITLE_SECOND_BOOK = "Libro 2: 'Aprendiendo TDD en Python' por Harry Percival.[^anchor2]";
	public static String SECOND_BOOK_ABSTRACT = "El TDD se basa en el principio de escribir pruebas claras y simples que describen el comportamiento deseado del código.";

	public static String OUPUT_TITLE_THIRD_BOOK = "Libro 3: 'Clean Code: A Handbook of Agile Software Craftsmanship' por Robert C. Martin.[^anchor3]";
	public static String THIRD_BOOK_ABSTRACT = "El TDD es una práctica esencial para escribir código limpio y bien estructurado."
			+ "Además, el ciclo TDD proporciona una retroalimentación rápida y constante, permitiendo a los desarrolladores realizar cambios con confianza.";
	public static String OUPUT_FIRST_BOOK_REFERENCE_WITHOUT_ANCHOR = "Crispin, L., & Gregory, J. (20XX). Pruebas Ágiles de Software. Editorial ABC.";
	public static String OUPUT_FIRST_BOOK_REFERENCE = ANCHOR_FIRST_BOOK + ": Crispin, L., & Gregory, J. (20XX). Pruebas Ágiles de Software. Editorial ABC.";
	public static String OUPUT_SECOND_BOOK_REFERENCE = "[^anchor2]: Percival, H. (20XX). Aprendiendo TDD en Python. Editorial XYZ";
	public static String OUPUT_THIRD_BOOK_REFERENCE = "[^anchor3]: Martin, R. C. (20XX). Clean Code: A Handbook of Agile Software Craftsmanship. Editorial DEF.";

}
