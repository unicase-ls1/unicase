/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

/**
 * An Element which links to a URef element within a document.
 * 
 * @see URef
 * @author Sebastian Hoecht
 */
public class ULink extends UParagraph {

	private String internalLinkId;
	private boolean hideLinkedPage;

	/**
	 * constructor.
	 * 
	 * @param text the Text of the Paragraph of the link
	 * @param internalLinkId the internalID which should be unique in the whole document
	 */
	public ULink(String text, String internalLinkId) {
		super(text);
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

	/**
	 * @param hideLinkedPage the hideLinkedPage to set
	 */
	public void setHideLinkedPage(boolean hideLinkedPage) {
		this.hideLinkedPage = hideLinkedPage;
	}

	/**
	 * @return the hideLinkedPage
	 */
	public boolean isHideLinkedPage() {
		return hideLinkedPage;
	}

}
