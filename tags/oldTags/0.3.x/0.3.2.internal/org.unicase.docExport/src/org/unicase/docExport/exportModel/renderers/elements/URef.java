package org.unicase.docExport.exportModel.renderers.elements;

/**
 * 
 * @author Sebastian Hoecht
 *
 */
public class URef extends UDocument {
	
	private String refId;
	
	/**
	 * 
	 * @param refId the internalId of the ULink, where this link leads to
	 * @see ULink
	 */
	public URef(String refId) {
		this.setRefId(refId);
	}

	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}

	/**
	 * @return the refId
	 */
	public String getRefId() {
		return refId;
	}

}
