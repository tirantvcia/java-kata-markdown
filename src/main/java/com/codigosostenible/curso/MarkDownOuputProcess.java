package com.codigosostenible.curso;


public class MarkDownOuputProcess {
	
	private String anchorLine;
	private String pageFeedReference;
	boolean hasPageFeedReference;

	public MarkDownOuputProcess(String anchorLine, String pageFeedReference) {
		this.anchorLine = anchorLine;
		this.pageFeedReference = pageFeedReference;
		this.hasPageFeedReference = getPageFeedReference() != null && getPageFeedReference().trim().length() > 0;
	}

	public String getAnchorLine() {
		return anchorLine;
	}

	public String getPageFeedReference() {
		return pageFeedReference;
	}

	public void setAnchorLine(String anchorLine) {
		this.anchorLine = anchorLine;
		
	}

	public void setPageFeedReference(String pageFeedReference) {
		this.pageFeedReference = pageFeedReference;
		
	}

	public boolean isHasPageFeedReference() {
		return hasPageFeedReference;
	}

	public void setHasPageFeedReference(boolean hasPageFeedReference) {
		this.hasPageFeedReference = hasPageFeedReference;
	}

}
