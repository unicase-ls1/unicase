package org.unicase.docExport.exportModel.renderers.elements;

import org.w3c.dom.Element;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class UFormatingObject extends UDocument {

	private Element foElement;
	
	/**
	 * 
	 * @param domElement a dom element consisting of elements using the
	 * formating objects (fo:) namespace
	 */
	public UFormatingObject(Element domElement) {
		
	}
	
	/**
	 * @param foElement the foElement to set
	 */
	public void setFoElement(Element foElement) {
		this.foElement = foElement;
	}
	
	/**
	 * @return the foElement
	 */
	public Element getFoElement() {
		return foElement;
	}
}
