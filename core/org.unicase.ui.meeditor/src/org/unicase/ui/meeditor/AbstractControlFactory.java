/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.meeditor.mecontrols.MEControl;

/**
 * An abstract factory for generating {@link MEControl}'s according to a {@link IItemPropertyDescriptor}.
 * 
 * @author shterev
 */
public abstract class AbstractControlFactory {
	private ModelElement modelElement;
	private EditingDomain editingDomain;
	private FormToolkit toolkit;

	/**
	 * Default constructor.
	 */
	public AbstractControlFactory() {
	}

	/**
	 * @param editingDomain the editing domain
	 * @param modelElement the model element
	 * @param toolkit the gui toolkit
	 */
	public void init(EditingDomain editingDomain, ModelElement modelElement, FormToolkit toolkit) {
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
	}

	/**
	 * Creates a {@link MEControl} according to the {@link IItemPropertyDescriptor}.
	 * 
	 * @param itemPropertyDescriptor the descriptor
	 * @return the {@link MEControl}
	 */
	public abstract MEControl createControl(IItemPropertyDescriptor itemPropertyDescriptor);

	/**
	 * Getter for the model element.
	 */
	public ModelElement getModelElement() {
		return modelElement;
	}

	/**
	 * Getter for the toolkit.
	 */
	public FormToolkit getToolkit() {
		return toolkit;
	}

	/**
	 * Getter for the editing domain.
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

}
