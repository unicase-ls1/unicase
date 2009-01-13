package org.unicase.docExport.exportModel.renderers.elements;

/**
 * 
 * @author Sebastian Hoecht
 *
 */
public class ULink extends UParagraph {

	private String internalLinkId;
	
	/**
	 * constructor.
	 * @param text the Text of the Paragraph of the link
	 * @param internalLinkId the internalID which should be unique in the whole document
	 */
	public ULink(String text, String internalLinkId) {
		super(text);
		// TODO Auto-generated constructor stub
		this.setInternalLinkId(internalLinkId);
	}

	/**
	 * @param internalLinkId the internalLinkId to set
	 */
	public void setInternalLinkId(String internalLinkId) {
		this.internalLinkId = internalLinkId;
	}

	/**
	 * @return the internalLinkId
	 */
	public String getInternalLinkId() {
		return internalLinkId;
	}

}
