package com.codigosostenible.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransformationMarkdownProcess {

	String bookTag = "[this book]";
	String openingParenthesis = "(";
	String closingParenthesis = ")";

	public List<MarkDownOuputProcess> generatePageFeedReference(String text) {
		List<MarkDownOuputProcess> listMarkDowns = new ArrayList<MarkDownOuputProcess>();
		if (!isThereCompletMarkdown(text)) {
			listMarkDowns.add(new MarkDownOuputProcess(text.trim(), ""));
			return listMarkDowns;
		}
		while (isThereCompletMarkdown(text)) {
			String anchorLine = text.substring(0, text.indexOf(bookTag));
			String referenceLine = text.substring(text.indexOf(openingParenthesis) + 1,
					text.indexOf(closingParenthesis));
			listMarkDowns.add(new MarkDownOuputProcess(anchorLine.trim(), referenceLine.trim()));
			text = text.substring(text.indexOf(closingParenthesis) + 1);
		}
		if (text != null && text.trim().length() > 0) {
			listMarkDowns.add(new MarkDownOuputProcess(text.trim(), ""));
		}
		return listMarkDowns;
	}

	private boolean isThereCompletMarkdown(String text) {
		return text.indexOf(bookTag) != -1 && text.indexOf(openingParenthesis) != -1
				&& text.indexOf(closingParenthesis) != -1 && text.indexOf(openingParenthesis) > text.indexOf(bookTag) && text.indexOf(closingParenthesis) > text.indexOf(openingParenthesis);
	}

}
