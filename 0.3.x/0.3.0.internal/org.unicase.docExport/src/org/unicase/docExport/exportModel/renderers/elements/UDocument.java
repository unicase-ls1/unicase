package org.unicase.docExport.exportModel.renderers.elements;

import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;


/**
 * Superclass of all renderer elements.
 * This class is part of the Composite Pattern.
 * 
 * @author Sebastian Höcht
 */
public abstract class UDocument {
	
	private BoxModelOption boxModel = OptionsFactory.eINSTANCE.createBoxModelOption();
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

	/**
	 * @param boxModel the boxModel to set
	 */
	public void setBoxModel(BoxModelOption boxModel) {
		this.boxModel = boxModel;
	}

	/**
	 * @return the boxModel
	 */
	public BoxModelOption getBoxModel() {
		return boxModel;
	}
}
