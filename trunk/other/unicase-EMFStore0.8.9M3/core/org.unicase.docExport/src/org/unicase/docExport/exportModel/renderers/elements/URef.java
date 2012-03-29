/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

/**
 * A reference to a certain position. This is like a label in LaTeX.
 * 
 * @see ULink
 * @author Sebastian Hoecht
 */
public class URef extends UDocument {

	private String refId;

	/**
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
