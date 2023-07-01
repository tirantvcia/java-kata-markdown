package com.codigosostenible.curso;

import java.util.ArrayList;
import java.util.List;

public class PageRepositoryData {

	private static final String ANCHOR_REFERENCE_SEPARATION = ": ";
	private static String ANCHOR_TEMPLATE = "[^anchorX]";
	public List<String> outputLines;
	public List<String> referenceLines;
	int chpaterReferenceNumber;
	
	public PageRepositoryData(int chpaterReferenceNumber) {
		this.outputLines = new ArrayList<>();
		this.referenceLines = new ArrayList<>();
		this.chpaterReferenceNumber = chpaterReferenceNumber;
		
	}
	
	public PageRepositoryData() {
		this.outputLines = new ArrayList<>();
		this.referenceLines = new ArrayList<>();
	}

	public void save(List<MarkDownOuputProcess> generatedPageFeedReferences) {
		
		StringBuilder outputLineWithEveryAnchorReference = new StringBuilder();
		
		generatedPageFeedReferences.stream().forEach(markDaown -> {
			String sameRferenceAppearedBefore = referenceLines.stream().filter(inlineReference -> matches(inlineReference, markDaown.getPageFeedReference())).findAny().orElse(null);
			String anchorToBePlaced = (markDaown.hasPageFeedReference)?getsAnchorReferenceToBePlace(sameRferenceAppearedBefore):"";
			outputLineWithEveryAnchorReference.append(markDaown.getAnchorLine().concat(anchorToBePlaced));	
			if (markDaown.hasPageFeedReference && sameRferenceAppearedBefore == null) {
				referenceLines.add(anchorToBePlaced
						.concat(ANCHOR_REFERENCE_SEPARATION + markDaown.getPageFeedReference()));
			}
		});
		
		outputLines.add(outputLineWithEveryAnchorReference.toString());

	}

	private String getsAnchorReferenceToBePlace(String sameRferenceAppearedBefore) {
		return (sameRferenceAppearedBefore != null)? sameRferenceAppearedBefore.substring(0, sameRferenceAppearedBefore.indexOf(":")):ANCHOR_TEMPLATE.replace("X", String.valueOf(referenceLines.size() + 1));
	}


	private boolean matches(String referenceLine, String pageFeedReference) {

		return referenceLine.contains(pageFeedReference);
	}

	public List<String> findAll() {
		List<String> lines = new ArrayList<>();
		lines.addAll(outputLines);
		lines.addAll(referenceLines);
		return lines;
	}

}