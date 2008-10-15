package org.unicase.documentexport.renderers.elements;

import java.util.Vector;

/**
 * This is just a container.
 */
public class UCompositeSection extends UDocument{
	
	private Vector<UDocument> children = new Vector<UDocument>();

	public void add(UDocument doc) {
		children.add(doc);
		doc.setParent(this);
	}
	
	public Vector<UDocument> getChildren() {
		return children;
	}
}
