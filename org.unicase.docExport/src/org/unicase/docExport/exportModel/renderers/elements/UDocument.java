/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;

/**
 * Superclass of all renderer elements. This class is part of the Composite Pattern.
 * 
 * @author Sebastian Hoecht
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
	 * 
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
		this.boxModel = EcoreUtil.copy(boxModel);
	}

	/**
	 * @return the boxModel
	 */
	public BoxModelOption getBoxModel() {
		return boxModel;
	}
}
