package org.unicase.documentexport.renderers.elements;


/**
 * Superclass of all renderer elements.
 * This class is part of the Composite Pattern.
 * 
 * @author Sebastian Höcht
 */
public abstract class UDocument {
	
	private UDocument parent;
	
	/**
	 * constructor.
	 */
	public UDocument() {
		
	}
	
	/**
	 * set the parent UDocument.
	 * @param newParent the new parent
	 */
	protected void setParent(UDocument newParent) {
		this.parent = newParent;
	}
	
	/**
	 * @return the parent UDocument
	 */
	public UDocument getParent() {
		return this.parent;
	}
}
