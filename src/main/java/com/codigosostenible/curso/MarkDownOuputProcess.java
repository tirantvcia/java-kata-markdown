package com.codigosostenible.curso;


public class MarkDownOuputProcess {
	
	private String anchorLine;
	private String pageFeedReference;

	public MarkDownOuputProcess(String anchorLine, String pageFeedReference) {
		this.anchorLine = anchorLine;
		this.pageFeedReference = pageFeedReference;
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

}
