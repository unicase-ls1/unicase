/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import java.util.Vector;

/**
 * This element is just a container for more elements.
 * 
 * @author Sebastian Hoecht
 */
public abstract class UCompositeSection extends UDocument {

	private Vector<UDocument> children = new Vector<UDocument>();

	/**
	 * @param doc the UDocument which shall be appended as a child.
	 */
	public void add(UDocument doc) {
		children.add(doc);
		doc.setParent(this);
	}

	/**
	 * @return a vector of all children.
	 */
	public Vector<UDocument> getChildren() {
		return children;
	}
}
