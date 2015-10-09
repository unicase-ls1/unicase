/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import org.w3c.dom.Element;

/**
 * A wrapper element for custom XSL-FO elements.
 * 
 * @author Sebastian Hoecht
 */
public class UFormatingObject extends UDocument {

	private Element foElement;

	/**
	 * @param domElement a dom element consisting of elements using the formating objects (fo:) namespace
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
