package com.codigosostenible.curso;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PageRepository {

	private static final String ANCHOR_REFERENCE_SEPARATION = ": ";
	private static String ANCHOR_TEMPLATE = "[^anchorX]";
	TransformationMarkdownProcess markDownProcess;
	List<String> outputLines;
	List<String> referenceLines;
	
	
	public PageRepository(TransformationMarkdownProcess markDownProcess) {
		this.markDownProcess = markDownProcess;
		this.outputLines = new ArrayList<>();
		this.referenceLines = new ArrayList<>();
	}

	public void add(String text) {
		List<MarkDownOuputProcess> generatedPageFeedReference = markDownProcess.generatePageFeedReference(text);
		StringBuilder anchorLine = new StringBuilder();
		
		for(int i = 0; i < generatedPageFeedReference.size(); i++) {
			String anchorToBePlaced = "";
			if(generatedPageFeedReference.get(i).isHasPageFeedReference()) {
				int position = findReferenceIntoReferenceLines(generatedPageFeedReference.get(i).getPageFeedReference());
				anchorToBePlaced = (isReferenceInPageFeed(position))?ANCHOR_TEMPLATE.replace("X", String.valueOf(position + 1)):ANCHOR_TEMPLATE.replace("X", String.valueOf(referenceLines.size() + 1));
				if(!isReferenceInPageFeed(position)) {
					referenceLines.add(anchorToBePlaced.concat(ANCHOR_REFERENCE_SEPARATION+generatedPageFeedReference.get(i).getPageFeedReference()));	
				}
				
				
			}
			anchorLine.append(generatedPageFeedReference.get(i).getAnchorLine().concat(anchorToBePlaced));
			
			
		}
		this.outputLines.add(anchorLine.toString());
	}

	private int findReferenceIntoReferenceLines(String pageFeedReference) {
		return IntStream.range(0, referenceLines.size()).filter(i -> matches(referenceLines.get(i), pageFeedReference)).findFirst().orElse(-1);
	}

	private boolean isReferenceInPageFeed(int position) {
		return position != -1;
	}


	private boolean matches(String referenceLine, String pageFeedReference) {
		
		return referenceLine.contains(pageFeedReference);
	}

	public List<String> allLines() {
		List<String> lines = new ArrayList<>();
		lines.addAll(outputLines);
		lines.addAll(referenceLines);
		return lines;
	
	}

}
