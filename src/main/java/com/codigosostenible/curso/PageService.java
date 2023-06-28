package com.codigosostenible.curso;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PageService {

	private static final String ANCHOR_REFERENCE_SEPARATION = ": ";
	private static String ANCHOR_TEMPLATE = "[^anchorX]";
	TransformationMarkdownProcess markDownProcess;
	PageRepositoryData data = new PageRepositoryData();



	public PageService(TransformationMarkdownProcess markDownProcess) {
		this.markDownProcess = markDownProcess;

	}

	public void add(String text) {
		List<MarkDownOuputProcess> generatedPageFeedReference = markDownProcess.generatePageFeedReference(text);
		StringBuilder outputLineWithAllMarkDownResults = new StringBuilder();
		
		for(int i = 0; i < generatedPageFeedReference.size(); i++) {
			String anchorToBePlaced = "";
			if(generatedPageFeedReference.get(i).isHasPageFeedReference()) {
				int position = findReferenceIntoReferenceLines(generatedPageFeedReference.get(i).getPageFeedReference());
				anchorToBePlaced = (isReferenceInPageFeed(position))?ANCHOR_TEMPLATE.replace("X", String.valueOf(position + 1)):ANCHOR_TEMPLATE.replace("X", String.valueOf(data.referenceLines.size() + 1));
				if(!isReferenceInPageFeed(position)) {
					data.referenceLines.add(anchorToBePlaced.concat(ANCHOR_REFERENCE_SEPARATION+generatedPageFeedReference.get(i).getPageFeedReference()));	
				}
				
				
			}
			outputLineWithAllMarkDownResults.append(generatedPageFeedReference.get(i).getAnchorLine().concat(anchorToBePlaced));
			
			
		}
		this.data.outputLines.add(outputLineWithAllMarkDownResults.toString());
	}

	private int findReferenceIntoReferenceLines(String pageFeedReference) {
		return IntStream.range(0, data.referenceLines.size()).filter(i -> matches(data.referenceLines.get(i), pageFeedReference)).findFirst().orElse(-1);
	}

	private boolean isReferenceInPageFeed(int position) {
		return position != -1;
	}


	private boolean matches(String referenceLine, String pageFeedReference) {
		
		return referenceLine.contains(pageFeedReference);
	}

	public List<String> allLines() {
		List<String> lines = new ArrayList<>();
		lines.addAll(data.outputLines);
		lines.addAll(data.referenceLines);
		return lines;
	
	}

}
