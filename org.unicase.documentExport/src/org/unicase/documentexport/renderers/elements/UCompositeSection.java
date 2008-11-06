package org.unicase.documentexport.renderers.elements;

import java.util.Vector;

import org.unicase.documentexport.documentTemplate.renderers.options.RendererOption;

/**
 * This class is just a container for more elements.
 * This is a part of the Composite Pattern.
 * @author Sebastian Höcht
 */
public class UCompositeSection extends UDocument {
	
	private Vector<UDocument> children = new Vector<UDocument>();
	private RendererOption option;

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

	/**
	 * @param option the option to set
	 */
	public void setOption(RendererOption option) {
		this.option = option;
	}

	/**
	 * @return the option
	 */
	public RendererOption getOption() {
		return option;
	}
}
