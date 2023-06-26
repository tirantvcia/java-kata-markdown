package com.codigosostenible.curso;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformationMarkdownProcess {
	
	String regex = "(.*)(\\[.+\\])\\s*(\\(.+\\))";
	
	public MarkDownOuputProcess generatePageFeedReference(String text) {
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String bookTitle = text;
        String bookLink = "";
        if (matcher.find()) {
			bookTitle = matcher.group(1);
	        bookLink = matcher.group(3).substring(1, matcher.group(3).length() - 1);
        }
		return new MarkDownOuputProcess(bookTitle.trim(), bookLink);
	}

	public boolean lineContainsMarkDownReference(String text) {
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
		return matcher.matches();
	}

}
