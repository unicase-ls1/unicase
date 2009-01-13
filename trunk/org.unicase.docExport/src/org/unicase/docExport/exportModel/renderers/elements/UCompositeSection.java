package org.unicase.docExport.exportModel.renderers.elements;

import java.util.Vector;

/**
 * This class is just a container for more elements.
 * This is a part of the Composite Pattern.
 * @author Sebastian Höcht
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
