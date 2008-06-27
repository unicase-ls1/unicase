/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Abstract class for the ME controls.
 * 
 * @author helming
 * 
 */
public abstract class AbstractMEControl implements MEControl {

	// AS: change to private and generate getters?
	protected FormToolkit toolkit;
	protected EObject modelElement;
	protected EditingDomain editingDomain;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain
	 *            the editing domain
	 * @param modelElement
	 *            the ME
	 * @param toolkit
	 *            gui toolkit used for rendering
	 */
	public AbstractMEControl(EditingDomain editingDomain, EObject modelElement,
			FormToolkit toolkit) {
		super();
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
	}
	
	public void dispose(){
		
	}

}
